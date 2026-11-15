package com.example;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;

@WebServlet("/database")
public class DatabaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/html;charset=UTF-8");

        try {

            InitialContext context = new InitialContext();

            DataSource ds = (DataSource)
                    context.lookup("java:comp/env/jdbc/gestionjee");

            try (Connection con = ds.getConnection()) {

                DatabaseMetaData meta = con.getMetaData();

                resp.getWriter().println("<html><body>");
                resp.getWriter().println("<h1>Connexion réussie !</h1>");
                resp.getWriter().println("<p>Base : " + con.getCatalog() + "</p>");
                resp.getWriter().println("<p>Produit : " + meta.getDatabaseProductName() + "</p>");
                resp.getWriter().println("<p>Version : " + meta.getDatabaseProductVersion() + "</p>");
                resp.getWriter().println("</body></html>");
            }

        } catch (Exception e) {

            resp.getWriter().println("<html><body>");
            resp.getWriter().println("<h1>Erreur de connexion</h1>");
            resp.getWriter().println("<pre>" + e.getMessage() + "</pre>");
            resp.getWriter().println("</body></html>");
        }
    }
}