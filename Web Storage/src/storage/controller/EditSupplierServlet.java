package storage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import storage.DBmanger.StorageDB;
import storage.DBmanger.SupplierDB;
import storage.entity.Storage;
import storage.entity.Supplier;

/**
 * Servlet implementation class EditSupplierServlet
 */
@WebServlet("/editSupplier")
public class EditSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
            int id = Integer.parseInt(request.getParameter("id"));
            Supplier supplier = SupplierDB.selectOne(id);
            request.setAttribute("supplier", supplier);
            getServletContext().getRequestDispatcher("/editSupplier.jsp").forward(request, response);
            
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
            Supplier supplier = new Supplier(id, name, phone);
            SupplierDB.update(supplier);
            response.sendRedirect(request.getContextPath() + "/suppliers");
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
	}

}
