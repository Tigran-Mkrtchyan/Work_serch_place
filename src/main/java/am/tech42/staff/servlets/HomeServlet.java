package am.tech42.staff.servlets;

import am.tech42.staff.service.IndexService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> skills = IndexService.getSkills();
        List<String> companies = IndexService.getCompanies();
        List<String> levels = IndexService.getLevel();
        List<String> jobTypes = IndexService.getJobTypes();
        request.setAttribute("skills",skills);
        request.setAttribute("companies",companies);
        request.setAttribute("levels",levels);
        request.setAttribute("jobTypes",jobTypes);
        request.getRequestDispatcher("WEB-INF/pages/index.jsp").forward(request,response);
    }
}
