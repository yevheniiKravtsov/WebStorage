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
 * Servlet implementation class EditComponentServlet
 */
@WebServlet("/editComponent")
public class EditComponentServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
            int id = Integer.parseInt(request.getParameter("id"));
            Component component = ComponentDB.selectOne(id);
            ArrayList<Manufacturer> manufacturerList = ManufacturerDB.select();
            ArrayList<Supplier> supplierList = SupplierDB.select();   
            request.setAttribute("component", component);
            request.setAttribute("manufacturerList", manufacturerList);
            request.setAttribute("supplierList", supplierList);
            getServletContext().getRequestDispatcher("/editComponent.jsp").forward(request, response);
            
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int manufacturerId = Integer.valueOf(request.getParameter("manufacturerId"));
			int supplierId = Integer.valueOf(request.getParameter("supplierId"));
            Manufacturer manufacturer = ManufacturerDB.selectOne(manufacturerId);
            Supplier supplier = SupplierDB.selectOne(supplierId);
			int id = Integer.parseInt(request.getParameter("id"));
            String partNumber = request.getParameter("partNumber");
//            Manufacturer manufacturer = (Manufacturer) request.getAttribute("manufacturer");
//            Supplier supplier = (Supplier) request.getAttribute("supplier");
            String description = request.getParameter("description");
//            String manufacturerName = request.getParameter("manufacturerName");
//            String supplierName = request.getParameter("supplierName");
            Component component = new Component(id,partNumber, manufacturer,supplier,description);
            ComponentDB.update(component);
            response.sendRedirect(request.getContextPath() + "/components");
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
	}

}
