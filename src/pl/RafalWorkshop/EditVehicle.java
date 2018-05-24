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

import pl.Dao.VegicleDao;

@WebServlet("/EditVehicle")
public class EditVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		try {
			Integer vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
			String model = request.getParameter("model");
			String tradeMark = request.getParameter("trademark");
			Integer productionYear = Integer.parseInt(request.getParameter("produtionYear"));
			String registrationNumber = request.getParameter("registrationNumber");
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date")); 
			Integer ownerId = Integer.parseInt(request.getParameter("ownerId"));

			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			
			Vehicle vehicle;
			
			
			if(!model.equals("") && !tradeMark.equals("") && productionYear!=null && productionYear!=null && date!=null) 
			{
				VegicleDao vehicleDao = VegicleDao.getInstance();
				
				vehicle = new Vehicle(model, tradeMark, productionYear, registrationNumber, sqlDate);
				vehicle.setId(vehicleId);
				vehicle.setCustomerID(ownerId);
				
				
				vehicleDao.update(vehicle);

				
				response.sendRedirect("VehiclePanel.jsp");
				
			}
			else 
			{
				
				Cookie newCookie = new Cookie("myCookie", "true");
				newCookie.setMaxAge(-1);
				response.addCookie(newCookie);
				response.sendRedirect("EditVehicle.jsp");
			}
			

			
		} 
		catch (Exception e) {
			
			Cookie newCookie = new Cookie("myCookie", "true");
			newCookie.setMaxAge(-1);
			response.addCookie(newCookie);

			response.sendRedirect("EditVehicle.jsp");

		}
		
		
		
		

	}

}