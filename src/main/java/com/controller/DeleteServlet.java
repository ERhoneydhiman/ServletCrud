package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;


public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao dao;
       
    public DeleteServlet() {
        super();
        dao = new UserDao();
}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession(false); 
	        if (session == null || session.getAttribute("user") == null) {
	            response.sendRedirect("login.html");
	            return;
	        }
		String userId = request.getParameter("userId");
		
		  
        if (userId != null && !userId.isEmpty()) {
            try {
                boolean success = dao.deleteUserById(userId);
                
                if (success) {
                    response.setStatus(HttpServletResponse.SC_OK);  // 200 OK
                } else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);  // 404 Not Found
                }
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);  // 400 Bad Request
            }
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);  // 400 Bad Request
        }
		
	
	}

}
