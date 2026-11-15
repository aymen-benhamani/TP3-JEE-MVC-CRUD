
package com.example;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/html;charset=UTF-8");

        resp.getWriter().println("""
            <!DOCTYPE html>
            <html>
            <head>
                <meta charset="UTF-8">
                <title>Inscription</title>
            </head>
            <body>
                <h1>Inscription</h1>

                <form method="post" action="inscription">
                    <input type="text" name="nom"
                           placeholder="Nom" >
                    <br><br>

                    <input type="email" name="email"
                           placeholder="Email" required>
                    <br><br>

                    <input type="number" name="age"
                           placeholder="Age" min="18" max="120"
                           required>
                    <br><br>

                    <button type="submit">S'inscrire</button>
                </form>
            </body>
            </html>
            """);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        req.setCharacterEncoding("UTF-8");

        String nom = req.getParameter("nom");
        String email = req.getParameter("email");
        String ageStr = req.getParameter("age");

        if (nom == null || nom.trim().isEmpty()) {
            resp.sendError(400, "Le nom est obligatoire");
            return;
        }

        if (email == null || !email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
            resp.sendError(400, "Email invalide");
            return;
        }

        int age;

        try {
            age = Integer.parseInt(ageStr);

            if (age < 18 || age > 120) {
                resp.sendError(400, "L'âge doit être entre 18 et 120");
                return;
            }

        } catch (NumberFormatException e) {
            resp.sendError(400, "Âge invalide");
            return;
        }

        HttpSession session = req.getSession();
        session.setAttribute("utilisateur", nom);
        resp.sendRedirect(req.getContextPath() + "/succes");
    }
}
