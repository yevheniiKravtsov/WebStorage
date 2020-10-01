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
 * Servlet implementation class EditStorage
 */
@WebServlet("/editStorage")
public class EditStorage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
            int id = Integer.parseInt(request.getParameter("id"));
            Storage storage = StorageDB.selectOne(id);
            request.setAttribute("storage", storage);
            getServletContext().getRequestDispatcher("/editStorage.jsp").forward(request, response);
            
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
            String adres = request.getParameter("adres");
            Storage storage = new Storage(id, adres);
            StorageDB.update(storage);
            response.sendRedirect(request.getContextPath() + "/storages");
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
	}

}
