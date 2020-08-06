package am.tech42.staff.service;


import org.postgresql.util.PSQLException;


import java.sql.*;

public class DBManager {
    private static final String  URL = "jdbc:postgresql://fm-toolbox.duckdns.org:5433/staff";
    private static final String  USERNAME = "test";
    private static final String PASSWORD = "test";
    private static final Connection connect;
    private static PreparedStatement ps;
    static{

        try {
            Class.forName("org.postgresql.Driver");
            connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
          throw  new RuntimeException(e);
        }

    }
   public static User registerUsers(String id,String type, String email,  String password ) throws DuplicateValueException {
        try{
            ps = connect.prepareStatement("insert into users (id,email,password,type) values  (?,?,?,?)");
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
    private static User getUser(String email,String password) throws SQLException{
        ps = connect.prepareStatement("select id,type from users where email=? and password=?");
        ps.setString(1,email);
        ps.setString(2,password);
        ResultSet rs = ps.executeQuery();
        if( rs.next()) {
            String id = rs.getString(1);
            String type = rs.getString(2);
            return new User(id,type);
        }
     return null;
    }
   public static void registerEmployee(String id,Date date,String firstName,String lastName)  {
       try {
           ps = connect.prepareStatement("insert into employees (user_id,first_name,Last_name,birthday) values  (?,?,?,?)");
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
     public static void updateEmployeesAttribute(String id, EmployeeAttributes attribute, String value)  {
        switch (attribute){
            case ADDRESS:
                updateEmployees(id,EmployeeAttributes.ADDRESS.getValue(),value);
                break;
            case BIRTHDAY:
                updateEmployees(id,EmployeeAttributes.BIRTHDAY.getValue(),value);
                break;
            case LAST_NAME:
                updateEmployees(id,EmployeeAttributes.LAST_NAME.getValue(),value);
                break;
            case FIRST_NAME:
                updateEmployees(id,EmployeeAttributes.FIRST_NAME.getValue(),value);
                break;
            case PHONE_NUMBER:
                updateEmployees(id,EmployeeAttributes.PHONE_NUMBER.getValue(),value);
                break;
        }
    }

    private static void updateEmployees(String id,String attribute, String value)  {
        try {
            ps=connect.prepareStatement("Update employees set "+attribute +"=? where user_id=?");
            ps.setString(1,value);
            ps.setString(2,id);
            ps.execute();
        } catch (SQLException e) {
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

//
//    public static void main(String[] args) throws DuplicateValueException {
//        registerUsers("110B186A9F9FpADD2DB306F67B9p017D","employee","kkkll","lll");
//
//    }

}
