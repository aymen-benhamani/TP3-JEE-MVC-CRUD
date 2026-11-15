
package com.example.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.example.model.Produit;
import com.example.model.ProduitDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/produits")
public class ProduitServlet extends HttpServlet {

    private ProduitDAO dao;

    @Override
    public void init() throws ServletException {
        dao = (ProduitDAO) getServletContext().getAttribute("produitDAO");

        if (dao == null) {
            throw new ServletException("ProduitDAO introuvable !");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if (action == null || action.isEmpty()) {
            req.setAttribute("produits", dao.findAll());
            req.getRequestDispatcher("/WEB-INF/views/produits/list.jsp")
                    .forward(req, resp);
        }

        else if ("new".equals(action)) {
            req.setAttribute("produit", new Produit());
            req.getRequestDispatcher("/WEB-INF/views/produits/form.jsp")
                    .forward(req, resp);
        }

        else if ("edit".equals(action)) {
            try {
                Long id = Long.parseLong(req.getParameter("id"));
                Produit produit = dao.findById(id);

                if (produit == null) {
                    resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                    return;
                }

                req.setAttribute("produit", produit);
                req.getRequestDispatcher("/WEB-INF/views/produits/form.jsp")
                        .forward(req, resp);

            } catch (NumberFormatException e) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        }

        else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String action = req.getParameter("action");

        if ("delete".equals(action)) {
            try {
                Long id = Long.parseLong(req.getParameter("id"));
                dao.delete(id);

                HttpSession session = req.getSession();
                session.setAttribute("flash", "Produit supprimé avec succès.");

                resp.sendRedirect(req.getContextPath() + "/produits");

            } catch (NumberFormatException e) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            }

            return;
        }

        String idParam = req.getParameter("id");
        String nom = req.getParameter("nom");
        String description = req.getParameter("description");
        String prixSaisi = req.getParameter("prix");
        String stockSaisi = req.getParameter("stock");

        Map<String, String> erreurs = new HashMap<>();

        Long id = null;

        if (idParam != null && !idParam.isEmpty()) {
            try {
                id = Long.parseLong(idParam);
            } catch (NumberFormatException e) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
            }

            if (dao.findById(id) == null) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
        }

        if (nom == null || nom.trim().length() < 2 || nom.trim().length() > 50) {
            erreurs.put("nom", "Le nom doit contenir entre 2 et 50 caractères.");
        }

        if (description != null && description.length() > 255) {
            erreurs.put("description", "La description ne doit pas dépasser 255 caractères.");
        }

        BigDecimal prix = null;

        try {
        	 if (prixSaisi == null || prixSaisi.trim().isEmpty()) {
        	        throw new NumberFormatException();
        	    }
            prix = new BigDecimal(prixSaisi);

            if (prix.compareTo(BigDecimal.ZERO) <= 0) {
                erreurs.put("prix", "Le prix doit être strictement positif.");
            }

        } catch (NumberFormatException e) {
            erreurs.put("prix", "Veuillez saisir un prix valide.");
        }

        int stock = 0;

        if (stockSaisi != null && !stockSaisi.trim().isEmpty()) {
            try {
                stock = Integer.parseInt(stockSaisi);

                if (stock < 0) {
                    erreurs.put("stock", "Le stock doit être supérieur ou égal à 0.");
                }

            } catch (NumberFormatException e) {
                erreurs.put("stock", "Le stock doit être un entier valide.");
            }
        }

        Produit produit = new Produit(
                id,
                nom == null ? "" : nom.trim(),
                description == null ? "" : description.trim(),
                prix,
                stock
        );

        if (!erreurs.isEmpty()) {
            req.setAttribute("erreurs", erreurs);
            req.setAttribute("produit", produit);
            req.setAttribute("prixSaisi", prixSaisi);
            req.setAttribute("stockSaisi", stockSaisi);

            req.getRequestDispatcher("/WEB-INF/views/produits/form.jsp")
                    .forward(req, resp);

            return;
        }

        dao.save(produit);

        HttpSession session = req.getSession();
        session.setAttribute("flash",
                "Produit « " + produit.getNom() + " » enregistré avec succès.");

        resp.sendRedirect(req.getContextPath() + "/produits");
    }
}
