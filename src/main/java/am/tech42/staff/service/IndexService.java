package am.tech42.staff.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class IndexService {
    private  static PreparedStatement ps;

    public static List<String> getSkills(){
        String sql = "select skill_name from skills";
        return getListOfColumn( sql);
    }
    public static List<String> getCompanies(){
        String sql = "select company_name from companies";
        return getListOfColumn( sql);
    }
    public static List<String> getLevel(){
        String sql = "select level_name from levels";
        return getListOfColumn( sql);
    }
    public static List<String> getJobTypes(){
        String sql = "select type_name from job_types";
        return getListOfColumn( sql);
    }
    private static List<String> getListOfColumn( String sql) {
        List<String> list = new LinkedList<>();
        try {
            ps = DBConnector.getConnection().prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                list.add(rs.getString(1));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
