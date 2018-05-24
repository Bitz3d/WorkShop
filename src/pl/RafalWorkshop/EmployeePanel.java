package pl.RafalWorkshop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.Dao.EmployeeDao;

@WebServlet("/EmployeePanel")
public class EmployeePanel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		EmployeeDao employeeDao = new EmployeeDao();
		
		List<Employee> employee = employeeDao.getAll();

		request.setAttribute("employee", employee);

		getServletContext().getRequestDispatcher("/WEB-INF/EmployeePanel.jsp").forward(request, response);

	}
}
