package am.tech42.staff.servlets;

import am.tech42.staff.main.PostHeader;
import am.tech42.staff.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PostsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PostHeader> postHeaders = PostService.getPostHeader();
        request.getSession().setAttribute("postHeaders", postHeaders);
        request.getRequestDispatcher("WEB-INF/pages/posts.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String skill= request.getParameter("skill");
       String jobType = request.getParameter("jobType");
       String company = request.getParameter("company");
       String level = request.getParameter("level");

        List<PostHeader> postHeaders = PostService.getPostHeader(skill,jobType,company,level);
        request.getSession().setAttribute("postHeaders", postHeaders);
        request.getRequestDispatcher("WEB-INF/pages/posts.jsp").forward(request,response);

    }
}
