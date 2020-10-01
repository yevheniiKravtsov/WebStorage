package storage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import storage.DBmanger.ComponentDB;

/**
 * Servlet implementation class DeleteComponentServlet
 */
@WebServlet("/deleteComponent")
public class DeleteComponentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            int id = Integer.parseInt(request.getParameter("id"));
            ComponentDB.delete(id);
            response.sendRedirect(request.getContextPath() + "/components");
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
	}
}
