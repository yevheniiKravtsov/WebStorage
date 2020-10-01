package storage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import storage.DBmanger.ManufacturerDB;
import storage.entity.Manufacturer;

/**
 * Servlet implementation class AddManufacturerServlet
 */
@WebServlet("/addManufacturer")
public class AddManufacturerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	 
	        getServletContext().getRequestDispatcher("/addManufacturer.jsp").forward(request, response);
	    }
	     
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        try {
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            Manufacturer manufacturer = new Manufacturer (name,phone);
            ManufacturerDB.insert(manufacturer);
            response.sendRedirect(request.getContextPath()+"/manufacturers");
        }
        catch(Exception ex) {
             
            getServletContext().getRequestDispatcher("/addManufacturer.jsp").forward(request, response); 
        }
    }
}
