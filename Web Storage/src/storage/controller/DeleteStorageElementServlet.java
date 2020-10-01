package storage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import storage.DBmanger.StorageElementDB;

/**
 * Servlet implementation class DeleteStorageElementServlet
 */
@WebServlet("/deleteStorageElement")
public class DeleteStorageElementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
	    	int id=Integer.valueOf(request.getParameter("id"));
	    	StorageElementDB.delete(id);
	    	response.sendRedirect(request.getContextPath() + "/main");
    	}
        catch(Exception ex) {
            System.out.println(ex);
        }
	}

}
