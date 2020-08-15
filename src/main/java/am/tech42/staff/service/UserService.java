package am.tech42.staff.service;

import am.tech42.staff.main.User;
import org.postgresql.util.PSQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
