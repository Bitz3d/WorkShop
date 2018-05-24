package pl.RafalWorkshop;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.Dao.EmployeeDao;

@WebServlet("/SearchResult")
public class SearchResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		String search = request.getParameter("search");
		EmployeeDao employeeDao = new EmployeeDao();
		
		List<Employee> employee = employeeDao.search(search);

		request.setAttribute("employee", employee);

		getServletContext().getRequestDispatcher("/WEB-INF/SearchResult.jsp").forward(request, response);
		
		
		
		
	}



}
