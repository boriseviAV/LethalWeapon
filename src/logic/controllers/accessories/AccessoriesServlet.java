package logic.controllers.accessories;

import logic.DAO.AccessoriesDAO;
import logic.models.Accessory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.List;

@WebServlet(value = "/accessories")
public class AccessoriesServlet extends HttpServlet {

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
        String description = request.getParameter("description");

        String pathToImage = "";
        try {
            pathToImage = loadFile(request);
            System.out.println(pathToImage);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }

        Accessory accessory = new Accessory(name, description, pathToImage);

        AccessoriesDAO accessoriesDAO = new AccessoriesDAO();
        int id = accessoriesDAO.insert(accessory);

        if (id == 0)
            request.setAttribute("fail", "Ошибка при добавлении оружия!");

        response.sendRedirect("/weapon_collections");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int itemsInPortion = 6;

        AccessoriesDAO accessoriesDAO = new AccessoriesDAO();
        List<Accessory> accessoriesList = accessoriesDAO.getAllAccessories();

        request.setAttribute("accessoriesList", accessoriesList);
        request.setAttribute("accessoriesListSize", accessoriesList.size());
        request.setAttribute("accessoriesListPortionsNumber", accessoriesList.size() / itemsInPortion);
        request.setAttribute("accessoriesListRestNumber", accessoriesList.size() % itemsInPortion);
        request.setAttribute("itemsInPortion", itemsInPortion);
        request.setAttribute("pageName", "pages/accessories/index.jsp");

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

}
