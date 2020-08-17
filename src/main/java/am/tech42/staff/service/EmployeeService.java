package am.tech42.staff.service;

import am.tech42.staff.main.Employee;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeService {
    private static PreparedStatement ps;

    public static void registerEmployee(String id, Date date, String firstName, String lastName)  {
        try {
            ps = DBConnector.getConnection().prepareStatement("insert into employees (user_id,first_name,Last_name,birthday) values  (?,?,?,?)");
            ps.setString(1,id);
            ps.setString(2,firstName);
            ps.setString(3,lastName);
            ps.setDate(4,date);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public static Employee getEmployee(String id){
        String sql ="select first_name,last_name,birthday,phone_number,address ,cv_path,img_path\n" +
                "       from employees e\n" +
                "            left join cvs c on e.user_id = c.user_id\n" +
                "            left join imges i on e.user_id = i.user_id\n" +
                "                where e.user_id = ?";
        try {
            ps = DBConnector.getConnection().prepareStatement(sql);
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String firstName = rs.getString(1);
                String lastName = rs.getString(2);
                Date birthday = rs.getDate(3);
                String phoneNumber  = rs.getString(4);
                String address = rs.getString(5);
                String cvPath =rs.getString(6);
                String imgPath= rs.getString(7);
                Employee employee =new Employee(firstName,lastName,birthday);
                if(phoneNumber != null){
                    employee.setPhoneNumber(phoneNumber);
                }
                if(address != null){
                    employee.setAddress(address);
                }
                if(cvPath != null){
                    employee.setCvPath(cvPath);
                }
                if(imgPath != null){
                    employee.setImgPath(imgPath);
                }
                return employee;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
    public static void updateEmployeesAttribute(String id, EmployeeAttributes attribute, String value){
        updateEmployees(id,attribute.getValue(),value);
    }

    private static void updateEmployees(String id,String attribute, String value)  {
        try {
            ps=DBConnector.getConnection().prepareStatement("Update employees set "+attribute +"=? where user_id=?");
            ps.setString(1,value);
            ps.setString(2,id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }

    public static String getEmployeeInformation(String id , EmployeeAttributes attribute){
        return getAttributeValue(id,attribute.getValue());
    }

    private static  String getAttributeValue(String id, String attribute){
        String attributeValue = null;
        try {
            ps = DBConnector.getConnection().prepareStatement("select "+attribute+" from employees where user_id = ? ");
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                attributeValue = rs.getString(1);
            }
            return attributeValue;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) {
        Employee employee = EmployeeService.getEmployee("D884B87B6A3E8EFE0F1E77741647F19A");
       System.out.println(employee.getFirstName() +employee.getAge());
    }
}
