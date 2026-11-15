
package com.example.listner;

import com.example.model.ProduitDAO;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppInitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ProduitDAO dao = new ProduitDAO();

        sce.getServletContext().setAttribute("produitDAO", dao);

        System.out.println("ProduitDAO initialise avec succes !");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println("Application arretee !");
    }
}

