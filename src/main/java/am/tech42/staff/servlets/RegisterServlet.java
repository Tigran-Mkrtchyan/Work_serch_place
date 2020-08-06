package am.tech42.staff.servlets;

import am.tech42.staff.service.DBManager;
import am.tech42.staff.service.DuplicateValueException;
import am.tech42.staff.service.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;


public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String type= req.getParameter("company");
        System.out.println(type);
        if(type == null){
            req.setAttribute("type","employee");
            req.getRequestDispatcher("/WEB-INF/pages/employeeRegister.jsp").forward(req, resp);
        }
        req.setAttribute("type", "company");
        req.getRequestDispatcher("/WEB-INF/pages/companyRegister.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String pass = req.getParameter("pass");
        String id = req.getSession().getId();
        String type ="employee" ;

        try {
            User  user = DBManager.registerUsers(id,type,email,pass);
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String birthday = req.getParameter("y")+"-"+req.getParameter("m")+"-"+req.getParameter("d");
            System.out.println(birthday);
            DBManager.registerEmployee(user.getId(), Date.valueOf(birthday), firstName, lastName);
            req.getSession().setAttribute("logged" ,user);
            req.getRequestDispatcher("/userPage").forward(req,resp);
        } catch (DuplicateValueException e) {
            if (e.getConstraint().equals("users_pkey")) {
                req.getSession().invalidate(); // for providing new session number
                resp.setStatus(302);
                resp.setHeader("location", "/signUp?error=pk");
            } else if (e.getConstraint().equals("users_email_key")) {
                resp.setStatus(302);
                resp.setHeader("location", "/signUp?error=email");
            }

        }

    }
}
