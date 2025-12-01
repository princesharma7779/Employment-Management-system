package com.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		{
			String sid = request.getParameter("id");
	    int id = Integer.parseInt(sid);
	    EmpDao.delete(id);
	    response.sendRedirect("ViewServlet");
	}

	}

}
