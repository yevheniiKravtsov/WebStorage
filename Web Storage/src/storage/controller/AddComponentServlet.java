package storage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import storage.DBmanger.ComponentDB;
import storage.DBmanger.ManufacturerDB;
import storage.DBmanger.SupplierDB;
import storage.entity.Component;
import storage.entity.Manufacturer;
import storage.entity.Supplier;

/**
 * Servlet implementation class AddComponentServlet
 */
@WebServlet("/addComponent")
public class AddComponentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
			ArrayList<Manufacturer> manufacturerList = ManufacturerDB.select();
			ArrayList<Supplier> supplierList = SupplierDB.select();
			request.setAttribute("manufacturerList", manufacturerList);
			request.setAttribute("supplierList", supplierList);
			getServletContext().getRequestDispatcher("/addComponent.jsp").forward(request, response);    
	    }
	     
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        try {
        	int supplierId = Integer.valueOf(request.getParameter("supplierId"));
        	int manufacturerId = Integer.valueOf(request.getParameter("manufacturerId"));
            String partNumber = request.getParameter("partNumber");
            Manufacturer manufacturer=ManufacturerDB.selectOne(manufacturerId);
            Supplier supplier=SupplierDB.selectOne(supplierId);
//            Manufacturer manufacturer = (Manufacturer) request.getAttribute("manufacturerId");
//            Supplier supplier = (Supplier) request.getAttribute("supplierId");
//            System.out.println(supplier.getSupplierName());
            String description = request.getParameter("description");
            Component component = new Component (partNumber, manufacturer, supplier, description);
            ComponentDB.insert(component);
            response.sendRedirect(request.getContextPath()+"/components");
        }
        catch(Exception ex) {
             
            getServletContext().getRequestDispatcher("/addComponent.jsp").forward(request, response); 
        }
    }

}
