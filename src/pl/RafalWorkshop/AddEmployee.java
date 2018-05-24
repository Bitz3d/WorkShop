package pl.RafalWorkshop;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.Dao.EmployeeDao;


@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		try {
			String name = request.getParameter("name");
			String lastname = request.getParameter("lastname");
			String adress = request.getParameter("adress");
			Integer telephoneNumber = Integer.parseInt(request.getParameter("telephoneNumber"));
			String text = request.getParameter("comment");
			Double pricePerhoure = Double.parseDouble(request.getParameter("pricePerHouer"));
			
			if(!name.equals("") && !lastname.equals("") && !adress.equals("") && telephoneNumber!=null  && pricePerhoure!=null) 
			{
				
				EmployeeDao employeeDao = EmployeeDao.getInstance();
				
				employeeDao.save(name, lastname, adress,telephoneNumber,text,pricePerhoure);

				
				response.sendRedirect("EmployeePanel");
				
			}
			else 
			{
				
				Cookie newCookie = new Cookie("myCookie", "true");
				newCookie.setMaxAge(-1);
				response.addCookie(newCookie);
				response.sendRedirect("AddEmployee.jsp");
			}
			

			
		} 
		catch (Exception e) {
			
			Cookie newCookie = new Cookie("myCookie", "true");
			newCookie.setMaxAge(-1);
			response.addCookie(newCookie);

			response.sendRedirect("AddEmployee.jsp");

		}
		
		
	}

}
