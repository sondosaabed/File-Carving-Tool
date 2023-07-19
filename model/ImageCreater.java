package model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
/*
 * In this class I created the image creater class which makes an image of a directory
 * and save it in a specific directory
 */
public class ImageCreater {
	/*
	 * In this method the forensic image is created
	 */
    /**
     * @param file2
     * @param savingPath
     * @return
     */
    public static boolean createForensicImage(File file2, File savingPath) {
        try {
            /*
             * Create the image where the user chose to save it
             */
            savingPath.mkdirs();

            /*
             * Copy the directory files to the new directory
             */
            copyDirectory(file2, savingPath);

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    /*
     * This method copies the directory
     */
    /**
     * @param source
     * @param destination
     * @throws IOException
     */
    private static void copyDirectory(File source, File destination) throws IOException {
    	/*
    	 * For each file 
    	 */
    	File[] files = source.listFiles();
        if (files != null) {
            for (File file : files) {
                File destinationFile = new File(destination, file.getName());

                if (file.isDirectory()) {
                    destinationFile.mkdirs();
                    copyDirectory(file, destinationFile);
                } else {
                    /*
                     * This is bit by bit level copying of the directory
                     * I used the Copy-Attributes to also keep the same attributes of the file
                     * 
                     */
                    Files.copy(file.toPath(), destinationFile.toPath(), StandardCopyOption.COPY_ATTRIBUTES);
                }
            }
        }
    }
}
