package pl.RafalWorkshop;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.Dao.VegicleDao;

@WebServlet("/VehiclePanel")
public class VehiclePanel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		VegicleDao vehicleDao = VegicleDao.getInstance();
		
		List<Vehicle> vehicles = vehicleDao.getAll();

		request.setAttribute("vehicles", vehicles);

		getServletContext().getRequestDispatcher("/WEB-INF/VehiclePanel.jsp").forward(request, response);
	}


}
