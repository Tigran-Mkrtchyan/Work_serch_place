package am.tech42.staff.service;

import am.tech42.staff.main.Employee;
import am.tech42.staff.main.User;
import org.postgresql.util.PSQLException;
import java.sql.*;

public class UserService {

    private static PreparedStatement ps;

   public static User registerUsers(String id, String type, String email, String password ) throws DuplicateValueException {
        try{
            ps = DBConnector.getConnection().prepareStatement("insert into users (id,email,password,type) values  (?,?,?,?)");
            ps.setString(1,id);
            ps.setString(2,email);
            ps.setString(3,password);
            ps.setString(4,type);
            ps.executeUpdate();
            return getUser(email,password);
        }
        catch (PSQLException pe) {
          throw new DuplicateValueException(pe);
        }
        catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
   }
    public static User signIn(String email,String password){
        try {
            return getUser(email, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    private static User getUser(String email,String password) throws SQLException{
        String sql = "select u.id ,u.type, concat( e.first_name ,c.company_name) as name from users u\n" +
                "    left join employees e on u.id = e.user_id\n" +
                "    left join companies c on u.id = c.user_id\n" +
                "    where u.email = ? and u.password = ?";
        ps = DBConnector.getConnection().prepareStatement(sql);
        ps.setString(1,email);
        ps.setString(2,password);
        ResultSet rs = ps.executeQuery();
        if( rs.next()) {
            String id = rs.getString(1);
            String type = rs.getString(2);
            String name = rs.getString(3);
            return new User(id,type,name);
        }
     return null;
    }

   public static void registerEmployee(String id,Date date,String firstName,String lastName)  {
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
       String sql ="select first_name,last_name,birthday,phone_number,address \n" +
               "    from employees where user_id = ?";
        try {
            ps = DBConnector.getConnection().prepareStatement(sql);
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String firstName = rs.getString(1);
                String lastName = rs.getString(2);
                Date birthday = rs.getDate(3);
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
//
//    public static void main(String[] args) throws SQLException {
//      User value=  DBManager.getUser("aaa","aaa");
//        System.out.println(value);
//    }

}
