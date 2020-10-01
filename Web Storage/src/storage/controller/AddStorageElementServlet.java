package storage.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import storage.DBmanger.ComponentDB;
import storage.DBmanger.StorageDB;
import storage.DBmanger.StorageElementDB;
import storage.entity.Component;
import storage.entity.Storage;
import storage.entity.StorageElement;

/**
 * Servlet implementation class AddStorageElementServlet
 */
@WebServlet("/addStorageElement")
public class AddStorageElementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
		ArrayList<Storage> storageList = StorageDB.select();
		ArrayList<Component> componentList = ComponentDB.select();
		request.setAttribute("storageList", storageList);
		request.setAttribute("componentList", componentList);
		getServletContext().getRequestDispatcher("/addStorageElement.jsp").forward(request, response);    
    }
	     
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        try {
            Timestamp time = Timestamp.valueOf(LocalDateTime.now());
            int numberOfComponents=Integer.valueOf(request.getParameter("numberOfComponents"));
            double price = Double.valueOf(request.getParameter("price"));
            int componentId = Integer.valueOf(request.getParameter("componentId"));
            Component component = ComponentDB.selectOne(componentId);
            int storageId=Integer.valueOf(request.getParameter("storageId"));
            Storage storage = StorageDB.selectOne(storageId);
            StorageElement storageElement= new StorageElement(time, numberOfComponents, price, component, storage);
            StorageElementDB.insert(storageElement);
            response.sendRedirect(request.getContextPath()+"/main");
        }
        catch(Exception ex) {
             
            getServletContext().getRequestDispatcher("/addStorageElement.jsp").forward(request, response); 
        }
    }


}
