package pl.RafalWorkshop;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.Dao.CustomerDao;


@WebServlet("/EditCustomer")
public class EditCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		try {
			Integer customerId = Integer.parseInt( request.getParameter("customerId"));
			String name = request.getParameter("name");
			String lastname = request.getParameter("lastname");
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date")); 
			java.sql.Date sd = new java.sql.Date(date.getTime());
			
			Customer customer;
			CustomerDao customerDao = CustomerDao.getInstance();
			
			if(!name.equals("") && !lastname.equals("") && sd!=null) 
			{
				
				customer = new Customer(name, lastname, sd);
				customer.setId(customerId);
				
				customerDao.update(customer);

				
				response.sendRedirect("CustomerPanel");
				
			}
			else 
			{
				
				Cookie newCookie = new Cookie("myCookie", "true");
				newCookie.setMaxAge(-1);
				response.addCookie(newCookie);
				response.sendRedirect("CustomerPanel.jsp");
			}
			

			
		} 
		catch (Exception e) {
			
			Cookie newCookie = new Cookie("myCookie", "true");
			newCookie.setMaxAge(-1);
			response.addCookie(newCookie);

			response.sendRedirect("CustomerPanel.jsp");

		}
		
		
	}

}