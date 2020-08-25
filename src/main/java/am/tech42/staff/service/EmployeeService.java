package am.tech42.staff.service;

import am.tech42.staff.model.Employee;
import am.tech42.staff.model.User;
import am.tech42.staff.model.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.sql.Date;


public class EmployeeService {


    public static User registerEmployee(String id, String email, String pass, Date date, String firstName, String lastName)  throws DuplicateValueException{
        try (Session session = SessionFactoryConnector.getSessionFactory().openSession()){
            Transaction  tx = session.beginTransaction();
            UserEntity userEntity =  UserService.registerUsers(id,UserType.EMPLOYEE.getValue(),email,pass);
            Employee employee = new Employee(id,firstName,lastName,date);
            session.save(employee);
            User user = new User( userEntity.getId(),UserType.EMPLOYEE,employee.getFirstName());
            tx.commit();
            return user;
        }

    }

    public static Employee getEmployee(String id){
         try(Session session = SessionFactoryConnector.getSessionFactory().openSession()){
             Transaction tx =session.beginTransaction();
             Query<Employee> query = session.createQuery("from Employee e where e.userId = :userId ",Employee.class);
             query.setParameter("userId",id);
             Employee employee = query.getSingleResult();
             tx.commit();
             employee.evaluateAgeFromBirthday();
             return employee;
         }
    }
}
