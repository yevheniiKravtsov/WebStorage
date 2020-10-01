package storage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import storage.DBmanger.ComponentDB;
import storage.entity.Component;

/**
 * Servlet implementation class ComponentServlet
 */
@WebServlet("/components")
public class ComponentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Component> componentList = ComponentDB.select();
		request.setAttribute("componentList",componentList);
		getServletContext().getRequestDispatcher("/components.jsp").forward(request, response);
	}

}
