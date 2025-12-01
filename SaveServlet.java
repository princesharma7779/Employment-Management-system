package com.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SaveServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        // Debug output
        System.out.println("Received Data:");
        System.out.println("Name: " + name);
        System.out.println("Password: " + password);
        System.out.println("Email: " + email);
        System.out.println("Country: " + country);

        Emp e = new Emp();
        e.setName(name);
        e.setPassword(password);
        e.setEmail(email);
        e.setCountry(country);

        int status = EmpDao.save(e);
        if (status > 0) {
            response.sendRedirect("ViewServlet");
        } else {
            response.setContentType("text/html");
            out.println("Sorry! Unable to save record.");
        }


        out.close();
    }
}
