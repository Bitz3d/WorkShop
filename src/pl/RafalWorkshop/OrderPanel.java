package pl.RafalWorkshop;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.Dao.OrderDao;
import pl.Dao.VegicleDao;


@WebServlet("/OrderPanel")
public class OrderPanel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDao orderDao = OrderDao.getInstance();
		
		List<Order> orders = orderDao.getAll();

		request.setAttribute("orders", orders);

		getServletContext().getRequestDispatcher("/WEB-INF/OrderPanel.jsp").forward(request, response);
	}



}
