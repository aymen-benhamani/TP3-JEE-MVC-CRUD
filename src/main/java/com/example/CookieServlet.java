
package com.example;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookies")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/html;charset=UTF-8");

        String action = req.getParameter("action");

 
        if ("set".equals(action)) {

            Cookie cookie = new Cookie("theme", "dark");

            cookie.setMaxAge(30 * 24 * 60 * 60);

            cookie.setPath(req.getContextPath() + "/");

            resp.addCookie(cookie);

            resp.getWriter().println("<p>Cookie créé avec succès !</p>");
        }

        else if ("delete".equals(action)) {

            Cookie cookie = new Cookie("theme", "");

            cookie.setMaxAge(0);

            cookie.setPath(req.getContextPath() + "/");

            resp.addCookie(cookie);

            resp.getWriter().println("<p>Cookie supprimé !</p>");
        }

        resp.getWriter().println("<h1>Gestion des cookies</h1>");

        Cookie[] cookies = req.getCookies();

        if (cookies != null) {

            for (Cookie c : cookies) {

                resp.getWriter().println(
                    "<p>" + c.getName() + " : " + c.getValue() + "</p>"
                );
            }

        } else {

            resp.getWriter().println("<p>Aucun cookie trouvé.</p>");
        }

        resp.getWriter().println(
            "<a href='?action=set'>Créer le cookie</a><br>"
        );

        resp.getWriter().println(
            "<a href='?action=delete'>Supprimer le cookie</a>"
        );
    }
}
