package pl.RafalWorkshop;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.Dao.OrderDao;
import pl.Dao.VegicleDao;

@WebServlet("/AddOrder")
public class AddOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {


			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("planingStartOfWork")); 
			java.sql.Date sd = new java.sql.Date(date.getTime());
			Integer employeeId = Integer.parseInt(request.getParameter("employeeId"));
			String problemDescription = request.getParameter("problemDescription");
			String status = request.getParameter("status");
			Integer vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
			
			
			
			

			if (date!=null && employeeId!=null && !problemDescription.equals("") 
				&& vehicleId != null) {

				OrderDao orderDao = OrderDao.getInstance();

				orderDao.save(date, employeeId, problemDescription, status, vehicleId);

				response.sendRedirect("OrderPanel");

			} else {

				Cookie newCookie = new Cookie("myCookie", "true");
				newCookie.setMaxAge(-1);
				response.addCookie(newCookie);
				response.sendRedirect("AddOrder.jsp");
			}

		} catch (Exception e) {

			Cookie newCookie = new Cookie("myCookie", "true");
			newCookie.setMaxAge(-1);
			response.addCookie(newCookie);

			response.sendRedirect("AddOrder.jsp");

		}

	}

}

