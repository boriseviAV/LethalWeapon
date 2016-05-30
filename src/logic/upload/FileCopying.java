package logic.upload;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileCopying implements FileWork {
    private static boolean isCacheCreated = false;
    private static String toDir;

    public static void createCacheDirectory(String path) {
        if (!isCacheCreated) {
            File file = new File(path);

            if (!file.exists()) {
                if (file.mkdir())
                    toDir = file.getAbsolutePath() + File.separator;
            }
            else
                if (toDir == null)
                    toDir = file.getAbsolutePath() + File.separator;
            isCacheCreated = true;
        }
    }

    public static void cache(String fileName) {
        File fileFrom = new File(sourceDir + fileName);
        File fileTo = new File(toDir + fileName);

        try {
            if (!fileTo.exists())
                Files.copy(fileFrom.toPath(), fileTo.toPath());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
