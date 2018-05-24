package pl.RafalWorkshop;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.Dao.CustomerDao;


@WebServlet("/DeleteCustomer")
public class DeleteCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Integer employeeId = Integer.parseInt(request.getParameter("customerId"));

			CustomerDao customerDao = CustomerDao.getInstance();

			customerDao.delete(employeeId);

			response.sendRedirect("CustomerPanel");

		} catch (Exception e) {

			response.sendRedirect("CustomerPanel");

		}
	}

}
