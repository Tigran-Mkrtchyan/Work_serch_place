package am.tech42.staff.servlets;

import am.tech42.staff.model.User;
import am.tech42.staff.service.EmployeeService;
import am.tech42.staff.service.DuplicateValueException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;


public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       String type = req.getParameter("company");

      if(type == null){
         req.getRequestDispatcher("/WEB-INF/pages/employeeRegister.jsp").forward(req, resp);
       }else {
        req.getRequestDispatcher("/WEB-INF/pages/companyRegister.jsp").forward(req, resp);
      }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String pass = req.getParameter("pass");
        String id = req.getSession().getId();
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String birthday = req.getParameter("y")+"-"+req.getParameter("m")+"-"+req.getParameter("d");
        req.getSession().invalidate();// for providing new session number

        try {
            User user = EmployeeService.registerEmployee(id,email,pass, Date.valueOf(birthday), firstName, lastName);
            req.getSession().setAttribute("logged" , user);
            req.getRequestDispatcher("/posts").forward(req,resp);
        } catch (DuplicateValueException e) {
            if (e.getConstraint().equals("users_pkey")) {
                req.getSession().invalidate(); // for providing new session number
                resp.setStatus(302);
                resp.setHeader("location", "/register?error=pk");
            } else if (e.getConstraint().equals("users_email_key")) {
                resp.setStatus(302);
                resp.setHeader("location", "/register?error=email");
            }

        }

    }
}
