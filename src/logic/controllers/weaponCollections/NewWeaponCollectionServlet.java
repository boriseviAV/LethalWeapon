package logic.controllers.weaponCollections;

import logic.DAO.CollectionsDAO;
import logic.models.WeaponCollection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 25,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 50
)
@WebServlet(value = "/new_weapon_collection")
public class NewWeaponCollectionServlet extends HttpServlet {

    private static final String imagesFolder = "resources/images/";

    private String getFileName(final Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    private String loadFile(HttpServletRequest request) throws ServletException, IOException {
        final Part filePart = request.getPart("picture");
        final String fileName = getFileName(filePart);

        OutputStream out = null;
        InputStream filecontent = null;

        String pictureURL = imagesFolder + fileName;

        String fullPictureURL = getServletContext().getRealPath("") + pictureURL;

        try {
            out = new FileOutputStream(new File(fullPictureURL));

            filecontent = filePart.getInputStream();

            int read;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

        } catch (FileNotFoundException fne) {
            System.err.println("Image not found!");
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (filecontent != null) {
                    filecontent.close();
                }
            }
            catch (IOException e) {
                System.err.println("Streams closing error!");
            }
        }

        return pictureURL;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        String pathToImage = "";
        try {
            pathToImage = loadFile(request);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }

        WeaponCollection weaponCollection = new WeaponCollection(name, pathToImage);

        CollectionsDAO collectionsDAO = new CollectionsDAO();
        int id = collectionsDAO.insert(weaponCollection);

        if (id == 0)
            request.setAttribute("fail", "Ошибка при добавлении оружия!");

        response.sendRedirect("/weapon_collections");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageName", "pages/weapon_collections/new.jsp");

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
