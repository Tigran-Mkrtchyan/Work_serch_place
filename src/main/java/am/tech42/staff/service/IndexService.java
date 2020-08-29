package am.tech42.staff.service;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class IndexService {

    public static List<String> getSkills() {
        List<String> skills;
        try (Session session = SessionFactoryConnector.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Query<String> query = session.createQuery("Select skillName from Skill ", String.class);
            skills = query.list();
            tx.commit();
            return skills;
        }
    }

    public static List<String> getCompanies() {
        List<String> companyNames;
        try (Session session = SessionFactoryConnector.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Query<String> query = session.createQuery("Select companyName from Company ", String.class);
            companyNames = query.list();
            tx.commit();
            return companyNames;
        }
    }

    public static List<String> getLevel() {
        List<String> levels;
        try (Session session = SessionFactoryConnector.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Query<String> query = session.createQuery("Select levelName from Level ", String.class);
            levels = query.list();
            tx.commit();
            return levels;
        }
    }

    public static List<String> getJobTypes() {
        List<String> jobTypes;
        try (Session session = SessionFactoryConnector.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Query<String> query = session.createQuery("Select typeName from JobType ", String.class);
            jobTypes = query.list();
            tx.commit();
            return jobTypes;
        }
    }
}
