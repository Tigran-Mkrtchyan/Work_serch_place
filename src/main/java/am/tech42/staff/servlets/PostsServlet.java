package am.tech42.staff.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PostsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/posts.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String skill= request.getParameter("skill");
       String jobType = request.getParameter("jobType");
       String company = request.getParameter("company");
       String level = request.getParameter("level");

        request.setAttribute("jobType",jobType);
        request.setAttribute("skill",skill);
        request.setAttribute("company",company);
        request.setAttribute("level",level);


        request.getRequestDispatcher("WEB-INF/pages/posts.jsp").forward(request,response);

    }
}
