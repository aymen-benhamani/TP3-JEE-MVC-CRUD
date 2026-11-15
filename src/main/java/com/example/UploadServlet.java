
package com.example;

import java.io.IOException;
import java.io.File;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        Part filePart = req.getPart("file");

        String fileName = new File(
            filePart.getSubmittedFileName()
        ).getName();

        String uploadPath = getServletContext().getRealPath("/uploads");

        File uploadDir = new File(uploadPath);

        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        filePart.write(uploadPath + File.separator + fileName);

        resp.setContentType("text/html;charset=UTF-8");

        resp.getWriter().println("<h1>Fichier uploadé avec succès !</h1>");
        resp.getWriter().println("<p>Nom du fichier : " + fileName + "</p>");
        resp.getWriter().println("<a href='upload.html'>Retour</a>");
    }
}
