package storage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import storage.DBmanger.SupplierDB;
import storage.entity.Supplier;

/**
 * Servlet implementation class Supplier
 */
@WebServlet("/suppliers")
public class SupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	ArrayList<Supplier> supplierList = SupplierDB.select();	
    	request.setAttribute("supplierList", supplierList);
    	getServletContext().getRequestDispatcher("/suppliers.jsp").forward(request,response);
    	
    }

	
}
