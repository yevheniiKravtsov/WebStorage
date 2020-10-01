package storage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import storage.DBmanger.SupplierDB;
import storage.entity.Supplier;

/**
 * Servlet implementation class AddSupplierServlet
 */
@WebServlet("/addSupplier")
public class AddSupplierServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	 
	        getServletContext().getRequestDispatcher("/addSupplier.jsp").forward(request, response);
	    }
	     
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        try {
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            Supplier supplier = new Supplier (name,phone);
            SupplierDB.insert(supplier);
            response.sendRedirect(request.getContextPath()+"/suppliers");
        }
        catch(Exception ex) {
             
            getServletContext().getRequestDispatcher("/addSupplier.jsp").forward(request, response); 
        }
    }

}
