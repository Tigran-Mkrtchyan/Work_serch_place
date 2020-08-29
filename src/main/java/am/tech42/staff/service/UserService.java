package am.tech42.staff.service;

import am.tech42.staff.model.Company;
import am.tech42.staff.model.Employee;
import am.tech42.staff.model.User;
import am.tech42.staff.model.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.postgresql.util.PSQLException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import java.sql.SQLException;


public class UserService {

    public static UserEntity registerUsers(String id, String type, String email, String password) throws DuplicateValueException {
        try (Session session = SessionFactoryConnector.getSessionFactory().openSession()) {
            Transaction  tx = session.beginTransaction();
            UserEntity userEntity = new UserEntity();
            userEntity.setId(id);
            userEntity.setType(type);
            userEntity.setEmail(email);
            userEntity.setPassword(password);
            session.save(userEntity);
            tx.commit();
            return userEntity;
        } catch (PersistenceException e) {
            if (e.getCause().getCause() instanceof SQLException) {
                PSQLException causeOfException = (PSQLException) e.getCause().getCause();
                throw new DuplicateValueException(causeOfException);
            } else {
                new RuntimeException(e);
            }
            return null;
        }
    }

    public static User signIn(String email, String password) {
        User user;
        String name = null;
        UserType userType;
        try (Session session = SessionFactoryConnector.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Query<UserEntity> query = session.createQuery("from UserEntity where email= :email and password= :pass ", UserEntity.class);
            query.setParameter("email", email);
            query.setParameter("pass", password);
            UserEntity userEntity = query.getSingleResult();
            if (userEntity.getType().equals(UserType.EMPLOYEE.getValue())) {
                Employee employee = session.find(Employee.class, userEntity.getId());
                name = employee.getFirstName();
                userType = UserType.EMPLOYEE;
            } else {
                 Company company = session.find(Company.class,userEntity.getId());
                 name = company.getCompanyName();
                userType = UserType.COMPANY;
            }
            user = new User(userEntity.getId(), userType, name);
            tx.commit();
            return user;
        } catch (NoResultException e) {
            return null;
        }

    }

}
