package storage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import storage.DBmanger.StorageElementDB;
import storage.entity.StorageElement;

/**
 * Servlet implementation class InfoStorageElementServlet
 */
@WebServlet("/infoStorageElement")
public class InfoStorageElementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    		int id= Integer.valueOf(request.getParameter("id"));
    		StorageElement storageElement = StorageElementDB.selectOne(id);
    		request.setAttribute("storageElement", storageElement);
    		getServletContext().getRequestDispatcher("/infoStorageElement.jsp").forward(request, response);  
	}

	
}
