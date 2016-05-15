package logic.controllers.weapons;

import logic.DAO.WeaponsDAO;
import logic.models.Weapon;

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
@WebServlet(value = "/new_weapon")
public class NewWeaponServlet extends HttpServlet {

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
        String modelName = request.getParameter("model_name");
        String holdingWay = request.getParameter("holding_way");
        String country = request.getParameter("country");
        String range = request.getParameter("range");
        String caliber = request.getParameter("caliber");

        int categoryId = Integer.parseInt(request.getParameter("to"));

        int ammoNumber = 0;
        String ammoString = request.getParameter("ammo_number");
        try {
            if (!ammoString.equals(""))
                ammoNumber = Integer.parseInt(ammoString);
        }
        catch (NumberFormatException e) {
            ammoNumber = 0;
        }

        Boolean optics = Boolean.parseBoolean(request.getParameter("optics"));
        String stuff = request.getParameter("stuff");

        String pathToImage = "";
        try {
            pathToImage = loadFile(request);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }

        Weapon weapon = new Weapon(modelName, holdingWay, country, range, caliber, ammoNumber, optics, stuff, pathToImage);
        weapon.setCategoryId(categoryId);

        WeaponsDAO weaponsDAO = new WeaponsDAO();
        int id = weaponsDAO.insert(weapon);

        if (id == 0)
            request.setAttribute("fail", "Ошибка при добавлении оружия!");

        response.sendRedirect("/show_category?id=" + categoryId);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageName", "pages/weapons/new.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
