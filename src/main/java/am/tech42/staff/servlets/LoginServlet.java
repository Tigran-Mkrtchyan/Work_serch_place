package am.tech42.staff.servlets;

import am.tech42.staff.main.Employee;
import am.tech42.staff.service.UserService;
import am.tech42.staff.main.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("pass");
        User user = UserService.signIn(email,password);
        if(user == null){
            resp.setStatus(302);
           resp.setHeader("location","/?error");
        }else if(user.getType().equals("employee")) {
            req.getSession().setAttribute("logged" ,user);
            req.getRequestDispatcher("WEB-INF/pages/index.jsp").forward(req,resp);
        }
    }
}
