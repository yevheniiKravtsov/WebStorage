 package storage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import storage.DBmanger.ManufacturerDB;
import storage.DBmanger.StorageElementDB;
import storage.entity.Manufacturer;
import storage.entity.StorageElement;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/main")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<StorageElement> storageElementsList = StorageElementDB.select();
        request.setAttribute("storageElementsList", storageElementsList);
        System.out.println(storageElementsList.get(0).getElementAddingTime());
        getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);
	}
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Timestamp dateFrom = Timestamp.valueOf(request.getParameter("dateFrom").toString()+" 00:00:00.0");
            Timestamp dateTo = Timestamp.valueOf(request.getParameter("dateTo").toString()+" 00:00:00.0");
            System.out.println(dateFrom+" "+dateTo);
            ArrayList<StorageElement> storageElementsList = StorageElementDB.selectBetween(dateFrom,dateTo);
            request.setAttribute("storageElementsList", storageElementsList);
            getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);
        }
        catch(Exception ex) {
             
            System.out.println(ex); 
        }
    }
}
