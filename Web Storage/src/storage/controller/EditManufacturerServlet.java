 package storage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import storage.DBmanger.ManufacturerDB;
import storage.DBmanger.SupplierDB;
import storage.entity.Manufacturer;
import storage.entity.Supplier;

/**
 * Servlet implementation class EditManufacturerServlet
 */
@WebServlet("/editManufacturer")
public class EditManufacturerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
            int id = Integer.parseInt(request.getParameter("id"));
            Manufacturer manufacturer = ManufacturerDB.selectOne(id);
            request.setAttribute("manufacturer", manufacturer);
            getServletContext().getRequestDispatcher("/editManufacturer.jsp").forward(request, response);
            
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
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            Manufacturer manufacturer = new Manufacturer(id, name, phone);
            ManufacturerDB.update(manufacturer);
            response.sendRedirect(request.getContextPath() + "/manufacturers");
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
	}
}
