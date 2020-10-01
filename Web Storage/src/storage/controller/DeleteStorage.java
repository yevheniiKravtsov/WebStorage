package storage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import storage.DBmanger.StorageDB;

/**
 * Servlet implementation class DeleteStorage
 */
@WebServlet("/deleteStorage")
public class DeleteStorage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            int id = Integer.parseInt(request.getParameter("id"));
            StorageDB.delete(id);
            response.sendRedirect(request.getContextPath() + "/storages");
        }
        catch(Exception ex) {
        	
            System.out.println(ex);
        }
	}

}
