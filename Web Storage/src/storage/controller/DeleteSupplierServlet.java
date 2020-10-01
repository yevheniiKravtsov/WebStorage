package storage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import storage.DBmanger.SupplierDB;

/**
 * Servlet implementation class DeleteSupplierServlet
 */
@WebServlet("/deleteSupplier")
public class DeleteSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            int id = Integer.parseInt(request.getParameter("id"));
            SupplierDB.delete(id);
            response.sendRedirect(request.getContextPath() + "/suppliers");
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
	}

}
