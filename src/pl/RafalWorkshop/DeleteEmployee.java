package pl.RafalWorkshop;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.Dao.EmployeeDao;

@WebServlet("/DeleteEmployee")
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Integer employeeId = Integer.parseInt(request.getParameter("employeeId"));

			EmployeeDao employeeDao = EmployeeDao.getInstance();

			employeeDao.delete(employeeId);

			response.sendRedirect("EmployeePanel");

		} catch (Exception e) {

			response.sendRedirect("EmployeePanel");

		}
	}

}
