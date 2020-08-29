package am.tech42.staff.service;

import am.tech42.staff.model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.sql.Date;
import java.util.*;

public class PostService {
    public static void addPost(String userId, int skillId, int jobTypeId, int[] levelsId, String description, Date deadLine) {
        try (Session session = SessionFactoryConnector.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Company company = session.find(Company.class, userId);
            Skill skill = session.find(Skill.class, skillId);
            JobType jobType = session.find(JobType.class, jobTypeId);
            Set<Level> levels = new HashSet<>();
            for (int levelId : levelsId) {
                Level level = session.find(Level.class, levelId);
                levels.add(level);
            }
            Post post = new Post(company, description, deadLine, jobType, levels, skill);
            session.persist(post);
            tx.commit();
        }
    }

    public static List<PostHeader> getPostHeader() {
        List<PostHeader> postHeaders = new ArrayList<>();
        try (Session session = SessionFactoryConnector.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Query<Object[]> query = session.createQuery("select p.id,p.deadline,c.companyName,s.skillName ,j.typeName ,lo.logoUrl from Post p " +
                                                            "join p.company c " +
                                                            "join p.skill s " +
                                                            "join p.jobType j " +
                                                            "left join c.logo lo", Object[].class);
            List<Object[]> posts = query.list();
            for (Object[] resultEntry : posts) {
                Date deadLine = (Date) resultEntry[1];
                // must be checking validation of post date here and remove if deadline has passed
                int postId = (int) resultEntry[0];
                String companyName = (String) resultEntry[2];
                String skillName = (String) resultEntry[3];
                String jobTypeName = (String) resultEntry[4];
                String logoPath = (String) resultEntry[5];
                PostHeader postHeader = new PostHeader(postId, companyName, skillName, jobTypeName, deadLine, logoPath);
                postHeaders.add(postHeader);
            }
            return postHeaders;
        }
    }

    public static List<PostHeader> getPostHeader(String... filterValues) {
        List<PostHeader> postHeaders = new ArrayList<>();
        try (Session session = SessionFactoryConnector.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Query<Object[]> query = session.createQuery("select DISTINCT p.id,p.deadline,c.companyName,s.skillName ,j.typeName ,lo.logoUrl from Post p " +
                    "join p.company c " +
                    "join p.skill s " +
                    "join p.jobType j " +
                    "join p.levels l " +
                    "left join c.logo lo " +
                    "where s.skillName like :skillName and j.typeName like :typeName and c.companyName like :companyName and l.levelName like :levelName", Object[].class);
            String skillName = filterValues[0].equals("All")? "%" : filterValues[0];
            String jobType = filterValues[1].equals("All")? "%" : filterValues[1];
            String companyName = filterValues[2].equals("All")? "%" : filterValues[2];
            String level = filterValues[3].equals("All")? "%" : filterValues[3];
            query.setParameter("skillName",skillName);
            query.setParameter("typeName",jobType);
            query.setParameter("companyName",companyName);
            query.setParameter("levelName",level);
            List<Object[]> posts = query.list();
            for (Object[] resultEntry : posts) {
                Date deadLine = (Date) resultEntry[1];
                int postId = (int) resultEntry[0];
                companyName = (String) resultEntry[2];
                skillName = (String) resultEntry[3];
                jobType = (String) resultEntry[4];
                String logoPath = (String) resultEntry[5];
                PostHeader postHeader = new PostHeader(postId, companyName, skillName, jobType, deadLine, logoPath);
                postHeaders.add(postHeader);
            }
            tx.commit();
            return postHeaders;
        }
    }


}
