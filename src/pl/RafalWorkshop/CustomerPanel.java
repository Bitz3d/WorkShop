package pl.RafalWorkshop;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.Dao.CustomerDao;
import pl.Dao.EmployeeDao;

@WebServlet("/CustomerPanel")
public class CustomerPanel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		CustomerDao customerDao = CustomerDao.getInstance();
		
		List<Customer> customers = customerDao.getAll();

		request.setAttribute("customers", customers);

		getServletContext().getRequestDispatcher("/WEB-INF/CustomerPanel.jsp").forward(request, response);
		
		
		
		
		
	}


}
