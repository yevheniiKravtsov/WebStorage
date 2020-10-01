package storage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import storage.DBmanger.StorageDB;
import storage.entity.Storage;

/**
 * Servlet implementation class AddStorageServlet
 */
@WebServlet("/addStorage")
public class AddStorageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	 
	        getServletContext().getRequestDispatcher("/addStorage.jsp").forward(request, response);
	    }
	     
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        try {
            String adres = request.getParameter("adres");
            
            Storage storage = new Storage(adres);
            StorageDB.insert(storage);
            response.sendRedirect(request.getContextPath()+"/storages");
        }
        catch(Exception ex) {
             
            getServletContext().getRequestDispatcher("/addStorage.jsp").forward(request, response); 
        }
    }


}
