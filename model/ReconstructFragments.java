package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileInputStream;

public class ReconstructFragments {
	/*
	 * In this class I create the method where I reconstruct the file fragmentes
	 * That are fuond and matched by the hash in a specific directory
	 */
    public static boolean reconstructFile(ArrayList<File> originalFileFragments, ArrayList<File> searchResultFragments,
                                           File directory) throws IOException {
       /*
        * For each file found in the search that has the same signiture 
        */
        if (canReconstruct(originalFileFragments, searchResultFragments)) {
            File outputFile = new File(directory, "reconstructed_file.docx");

            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
            	/*
            	 * For each file in the original file fragments
            	 */
            	for (File originalFragment : originalFileFragments) {
                    for (File searchFragment : searchResultFragments) {
                        String originalFragmentHash = CalculateCompareHash.calculateHash(originalFragment);
                        String searchFragmentHash = CalculateCompareHash.calculateHash(searchFragment);

                        if (originalFragmentHash.equals(searchFragmentHash)) {
                            // Read the contents of the matching fragment and write them to the output file
                            byte[] buffer = new byte[1024];
                            int bytesRead;
                            FileInputStream fis = new FileInputStream(searchFragment);
                            while ((bytesRead = fis.read(buffer)) != -1) {
                                fos.write(buffer, 0, bytesRead);
                            }
                            fis.close();
                            break;
                        }
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
    /*
     * This method I create to check if there is a match for each fragment of the original target file
     */
    private static boolean canReconstruct(ArrayList<File> originalFileFragments, ArrayList<File> searchResultFragments) {
        for (File originalFragment : originalFileFragments) {
            boolean match = false;
            for (File searchFragment : searchResultFragments) {
            	
            	String ans  = CalculateCompareHash.compareHashs(originalFragment, searchFragment);
                
                if (ans.equals("Match")) {
                    match = true;
                    break;
                }
            }
            
            if (!match) {
                return false;
            }
        }
        return true;
    }
}