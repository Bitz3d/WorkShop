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


@WebServlet("/AddCustomer")
public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		try {
			String name = request.getParameter("name");
			String lastname = request.getParameter("lastname");
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date")); 
			java.sql.Date sd = new java.sql.Date(date.getTime());
			
			
			if(!name.equals("") && !lastname.equals("") && date!=null) 
			{
				
				CustomerDao customerDao = CustomerDao.getInstance();
				
				customerDao.save(name, lastname, sd);

				
				response.sendRedirect("index.jsp");
				
			}
			else 
			{
				
				Cookie newCookie = new Cookie("myCookie", "true");
				newCookie.setMaxAge(-1);
				response.addCookie(newCookie);
				response.sendRedirect("AddCustomer.jsp");
			}
			

			
		} 
		catch (Exception e) {
			
			Cookie newCookie = new Cookie("myCookie", "true");
			newCookie.setMaxAge(-1);
			response.addCookie(newCookie);

			response.sendRedirect("AddCustomer.jsp");

		}
		
		
	}

}
