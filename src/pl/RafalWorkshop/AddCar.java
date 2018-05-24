package pl.RafalWorkshop;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.Dao.CustomerDao;
import pl.Dao.VegicleDao;

@WebServlet("/AddCar")
public class AddCar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		try {
			
			String model = request.getParameter("model");
			String tradeMark = request.getParameter("trademark");
			Integer productionYear = Integer.parseInt(request.getParameter("produtionYear"));
			String registrationNumber = request.getParameter("registrationNumber");
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date")); 
			Integer ownerId = Integer.parseInt(request.getParameter("ownerId"));

			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			
			
			
			
			if(!model.equals("") && !tradeMark.equals("") && productionYear!=null && productionYear!=null && date!=null && ownerId!=null) 
			{
				
				VegicleDao vehicleDao = VegicleDao.getInstance();
				
				vehicleDao.save(model, tradeMark, productionYear, registrationNumber,  sqlDate, ownerId);

				
				response.sendRedirect("VehiclePanel");
				
			}
			else 
			{
				
				Cookie newCookie = new Cookie("myCookie", "true");
				newCookie.setMaxAge(-1);
				response.addCookie(newCookie);
				response.sendRedirect("addVehicle.jsp");
			}
			

			
		} 
		catch (Exception e) {
			
			Cookie newCookie = new Cookie("myCookie", "true");
			newCookie.setMaxAge(-1);
			response.addCookie(newCookie);

			response.sendRedirect("addVehicle.jsp");

		}
		
		
		
		

	}

}
