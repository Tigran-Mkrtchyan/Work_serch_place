package am.tech42.staff.servlets;

import am.tech42.staff.service.DBManager;
import am.tech42.staff.service.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/employee.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("pass");
        User user = DBManager.signIn(email,password);
        if(user == null){
            resp.setStatus(302);
           resp.setHeader("location","/?error");
        }
        req.getSession().setAttribute("logged" ,user);
        req.getRequestDispatcher("/WEB-INF/pages/employee.jsp").forward(req,resp);
    }
}
