/**
 * 
 */
package model;

/**
 * 
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.ObservableList;

public class ReportGenerate {
	/*
	 * In this method I generate the report of the fragmentation process
	 * Where the report is genterated in the specific directory
	 */
    public static boolean generateReport(File directory, ArrayList<File> originalFileFragments,ObservableList<FragmentMatchInfo> fragmentMatchData) {
        /*
         * Craete the report file
         */
        File reportFile = new File(directory.getPath() + "/report.txt");
        StringBuilder reportContent = new StringBuilder();
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportFile))) {
            /*
             * Start writing the info
             */
        	reportContent.append("File Carving Information:\n");
            
            reportContent.append("Original File Fragments:\n");
        	for (File file : originalFileFragments) {
            	reportContent.append("- Fragment: ").append(file.getName()).append("\n");
			}
            
            reportContent.append("***************************************\n");

            /*
             * For each fragment appened to the file
             */
            reportContent.append("Fragment Match Data:\n");
            for (FragmentMatchInfo fragmentMatchInfo : fragmentMatchData) {
                reportContent.append("- Fragment Number: ").append(fragmentMatchInfo.getFragmentNumber()).append("\n");
                reportContent.append("  Original File Hash: ").append(fragmentMatchInfo.getOriginalFileHash()).append("\n");
                reportContent.append("  Search Result File Hash: ").append(fragmentMatchInfo.getSearchResultFileHash()).append("\n");
                reportContent.append("  Match or not: ").append(fragmentMatchInfo.isMatch()).append("\n");
                reportContent.append("\n");
            }
            writer.write(reportContent.toString());
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}