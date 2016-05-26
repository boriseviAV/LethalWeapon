package logic.upload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.*;

public class FileUploading {

    private static final String imagesFolder = "resources/images/";

    private static String getFileName(final Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    public static String loadFile(HttpServletRequest request) throws ServletException, IOException {
        final Part filePart = request.getPart("picture");
        final String fileName = getFileName(filePart);

        OutputStream out = null;
        InputStream filecontent = null;

        String pictureURL = imagesFolder + fileName;

        String fullPictureURL = request.getServletContext().getRealPath("") + pictureURL;

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
}
