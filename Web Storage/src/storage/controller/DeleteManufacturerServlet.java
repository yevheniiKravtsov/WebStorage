package storage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import storage.DBmanger.ManufacturerDB;

/**
 * Servlet implementation class DeleteManufacturerServlet
 */
@WebServlet("/deleteManufacturer")
public class DeleteManufacturerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            int id = Integer.parseInt(request.getParameter("id"));
            ManufacturerDB.delete(id);
            response.sendRedirect(request.getContextPath() + "/manufacturers");
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
	}

}
