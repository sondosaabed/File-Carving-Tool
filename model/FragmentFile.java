package model;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/*
 * In this class I create the solution for fragmenting the file passed on a specific number of fragments
 */
public class FragmentFile {
	/*
	 * Constructor
	 */
    /**
     * @param new File(filePath)
     * @param numFragments
     * @return
     * @throws IOException
     */
	
	/*
	 * This method I created To fragment the original File using it's path so that it could consider updtaing it
	 */
    public static ArrayList<File> fragmentFile(String filePath, int numFragments) throws IOException {
        ArrayList<File> fragments = new ArrayList<>();
        File file2 = new File(filePath);
        long fileSize = file2.length();
        /*
         * Divide the file size into equal sized fragmenations
         */
        long fragmentSize = fileSize / numFragments;

        try (var inputStream = new FileInputStream(file2)) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            for (int fragmentIndex = 0; fragmentIndex < numFragments; fragmentIndex++) {
                String fragmentName = file2.getName() + "_fragment_" + fragmentIndex;
                File fragmentFile = new File(fragmentName);

                try (var outputStream = new FileOutputStream(fragmentFile)) {
                    long bytesRemaining = fragmentSize;
                    while (bytesRemaining > 0 && (bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                        bytesRemaining -= bytesRead;
                    }
                }

                fragments.add(fragmentFile);
            }
        }
        /*
         * Returns teh arraylist of fragmented fiels
         */
        return fragments;
    }
    
    public static ArrayList<File> fragmentFile(File file2, int numFragments) throws IOException {
        ArrayList<File> fragments = new ArrayList<>();

        long fileSize = file2.length();
        /*
         * Divide the file size into equal sized fragmenations
         */
        long fragmentSize = fileSize / numFragments;

        try (var inputStream = new FileInputStream(file2)) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            for (int fragmentIndex = 0; fragmentIndex < numFragments; fragmentIndex++) {
                String fragmentName = file2.getName() + "_fragment_" + fragmentIndex;
                File fragmentFile = new File(fragmentName);

                try (var outputStream = new FileOutputStream(fragmentFile)) {
                    long bytesRemaining = fragmentSize;
                    while (bytesRemaining > 0 && (bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                        bytesRemaining -= bytesRead;
                    }
                }

                fragments.add(fragmentFile);
            }
        }
        /*
         * Returns teh arraylist of fragmented fiels
         */
        return fragments;
    }
}