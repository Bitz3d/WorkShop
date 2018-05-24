package pl.RafalWorkshop;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.Dao.CustomerDao;
import pl.Dao.OrderDao;

/**
 * Servlet implementation class DeleteOrder
 */
@WebServlet("/DeleteOrder")
public class DeleteOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Integer orderId = Integer.parseInt(request.getParameter("orderId"));

			OrderDao orderDao = OrderDao.getInstance();

			orderDao.delete(orderId);

			response.sendRedirect("OrderPanel");

		} catch (Exception e) {

			response.sendRedirect("orderPanel");

		}
	}

}
