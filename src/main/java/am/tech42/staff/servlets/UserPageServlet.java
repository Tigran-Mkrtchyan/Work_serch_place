package am.tech42.staff.servlets;

import am.tech42.staff.model.Employee;
import am.tech42.staff.model.User;
import am.tech42.staff.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserPageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("logged");
        if(user.getType().equals("employee")){
            Employee employee = EmployeeService.getEmployee(user.getId());
                request.getSession().setAttribute("employee",employee);
            request.getRequestDispatcher("WEB-INF/pages/employee.jsp").forward(request,response);
        }
        request.getRequestDispatcher("WEB-INF/pages/company.jsp").forward(request,response);


    }
}
