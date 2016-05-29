package logic.controllers;

import logic.upload.FileCopying;
import logic.upload.FileWork;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class InitServlet extends HttpServlet {

    protected static String cacheDir = null;

    @Override
    public void init() throws ServletException {
        super.init();
        if (cacheDir == null) {
            cacheDir = getServletContext().getRealPath("/") + FileWork.cacheDir;
            FileCopying.createCacheDirectory(cacheDir);
        }
    }
}
