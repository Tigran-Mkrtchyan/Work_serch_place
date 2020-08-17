package am.tech42.staff.service;

import am.tech42.staff.main.PostHeader;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostService {
    private static PreparedStatement ps;

    public static List<PostHeader> getPostHeader(){
        String sql = "select p.id, p.\"isDeadPost\",logo_path,p.deadline,c.company_name as name ,s.skill_name as skill ,jt.type_name as type,string_agg(level_name,',/ ' ) as levels from posts p\n" +
                "    inner join companies c on p.user_id = c.user_id\n" +
                "    inner join skills s on p.skill_id = s.id\n" +
                "    inner join job_types jt on p.jobType_id = jt.id\n" +
                "    inner join logos on p.user_id = logos.user_id\n" +
                "    left join post_level pl on p.id = pl.post_id\n" +
                "    left join levels l on pl.level_id = l.id\n" +
                "    group by  p.id, c.company_name, logo_path,s.skill_name, jt.type_name";
        try {
            ps = DBConnector.getConnection().prepareStatement(sql);
            ResultSet rs =  ps.executeQuery();
            return getPostHeaders(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
    public static List<PostHeader> getPostHeader( String ...filterValues){
        String skill= filterValues[0].equals("All") ? "%" : filterValues[0];
        String jobType = filterValues[1].equals("All") ? "%" : filterValues[1];
        String company = filterValues[2].equals("All") ? "%" : filterValues[2];
        String level = filterValues[3].equals("All")? "%" : "%"+filterValues[3]+"%";
        String sql = "select p.id, p.\"isDeadPost\",logo_path,p.deadline,c.company_name as name ,s.skill_name as skill ,jt.type_name as type,string_agg(level_name,',/ ' ) as levels from posts p\n" +
                "    inner join companies c on p.user_id = c.user_id\n" +
                "    inner join skills s on p.skill_id = s.id\n" +
                "    inner join job_types jt on p.jobType_id = jt.id\n" +
                "    inner join logos on p.user_id = logos.user_id\n" +
                "    left join post_level pl on p.id = pl.post_id\n" +
                "    left join levels l on pl.level_id = l.id\n" +
                "    group by  p.id, c.company_name, logo_path,s.skill_name, jt.type_name\n" +
                "\n" +
                "    having s.skill_name like ? and  c.company_name like ? and string_agg(level_name,',/' ) like ? and jt.type_name like ?";
        try {
            ps = DBConnector.getConnection().prepareStatement(sql);
            ps.setString(1,skill);
            ps.setString(2,company);
            ps.setString(3,level);
            ps.setString(4,jobType);
            ResultSet rs =  ps.executeQuery();
            return getPostHeaders(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static List<PostHeader> getPostHeaders(ResultSet rs) throws SQLException {
        List <PostHeader> posts = new ArrayList<>();

        while(rs.next()) {
            if(!rs.getBoolean("isDeadPost")) {
                int postId = rs.getInt("id");
                String companyName = rs.getString("name");
                String skill = rs.getString("skill");
                String jobType = rs.getString("type");
                String [] levels = rs.getString("levels").split(",");
                String logo = rs.getString("logo_path");
                Date deadline = rs.getDate("deadline");
                PostHeader post = new PostHeader(postId,companyName,skill,jobType,levels,deadline,logo);
                posts.add(post);
            }
        }
        return posts;
    }

    public static void main(String[] args) {
      List<PostHeader> posts =   getPostHeader();
      for (PostHeader ph : posts){
          System.out.println(ph.getCompanyName());
          System.out.println(ph.getSkill());
          System.out.println(ph.getPostId());

      }
    }

}
