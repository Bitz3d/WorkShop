package pl.RafalWorkshop;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.Dao.CustomerDao;
import pl.Dao.VegicleDao;

@WebServlet("/DeleteVehicle")
public class DeleteVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Integer vehicleId = Integer.parseInt(request.getParameter("vehicleId"));

			VegicleDao vehicleDao = VegicleDao.getInstance();

			vehicleDao.delete(vehicleId);

			response.sendRedirect("VehiclePanel");

		} catch (Exception e) {

			response.sendRedirect("VehiclePanel");

		}
	}

}
