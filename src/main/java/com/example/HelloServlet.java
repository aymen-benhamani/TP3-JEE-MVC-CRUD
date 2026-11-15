package com.example;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.net.InetAddress;
import java.time.LocalDateTime;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/html;charset=UTF-8");

        String nomMachine = InetAddress.getLocalHost().getHostName();

        LocalDateTime dateHeure = LocalDateTime.now();

        String navigateur = req.getHeader("User-Agent");

        resp.getWriter().println("<html>");
        resp.getWriter().println("<head><title>Informations système</title></head>");
        resp.getWriter().println("<body>");

        resp.getWriter().println("<h1>Informations de la Servlet</h1>");
        resp.getWriter().println("<p>Nom de la machine : " + nomMachine + "</p>");
        resp.getWriter().println("<p>Date et heure : " + dateHeure + "</p>");
        resp.getWriter().println("<p>User-Agent : " + navigateur + "</p>");

        resp.getWriter().println("</body>");
        resp.getWriter().println("</html>");
    }
}