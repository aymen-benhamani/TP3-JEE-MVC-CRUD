
package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/formulaire")
public class FormulaireServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String nom = req.getParameter("nom");
        String email = req.getParameter("email");

        resp.getWriter().println("<html>");
        resp.getWriter().println("<body>");

        resp.getWriter().println("<h1>Informations reçues</h1>");
        resp.getWriter().println("<p>Nom : " + nom + "</p>");
        resp.getWriter().println("<p>Email : " + email + "</p>");

        resp.getWriter().println("</body>");
        resp.getWriter().println("</html>");
    }
}
