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


@WebServlet("/EditOrder")
public class EditOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			Integer orderId = Integer.parseInt(request.getParameter("orderId"));
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("planingStartOfWork")); 
			java.sql.Date sd = new java.sql.Date(date.getTime());
			
			Date startOfWork = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("start_of_work")); 
			java.sql.Date sqlStartOfWork = new java.sql.Date(startOfWork.getTime());

			Integer employeeId = Integer.parseInt(request.getParameter("employeeId"));
			String problemDescription = request.getParameter("problemDescription");
			String afterFixDescription = request.getParameter("afterFixDescription");
			String status = request.getParameter("status");
			Integer vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
			Double partsCost = Double.parseDouble(request.getParameter("partsCost"));
			Double laborHouresToFix = Double.parseDouble(request.getParameter("laborHouresToFix"));
			

			if (date!=null && sqlStartOfWork!=null && employeeId!=null && !problemDescription.equals("")  && !afterFixDescription.equals("") && !status.equals("")
				&& vehicleId != null && partsCost != null && laborHouresToFix != null) {

				OrderDao orderDao = OrderDao.getInstance();

				orderDao.update(date, sqlStartOfWork, employeeId, problemDescription, afterFixDescription, status, vehicleId, partsCost, laborHouresToFix, orderId);

				response.sendRedirect("OrderPanel");

			} else {

				Cookie newCookie = new Cookie("myCookie", "true");
				newCookie.setMaxAge(-1);
				response.addCookie(newCookie);
				response.sendRedirect("EditOrder.jsp");
			}

		} catch (Exception e) {

			Cookie newCookie = new Cookie("myCookie", "true");
			newCookie.setMaxAge(-1);
			response.addCookie(newCookie);

			response.sendRedirect("EditOrder.jsp");

		}

	}

}
