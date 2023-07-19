package model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

/*
 * In this class I write the solution for storing the files into some specific directory 
 * it is used to save the search results
 */
public class StoreFileintoDirectory {
	/**
	 * @param files
	 * @param savingDirectory
	 * @return
	 */
	public static boolean saveFiles(ArrayList<File> files, File savingDirectory) {
		try {
			/*
			 * Create the saving directory if it doesn't exist
			 */
			Files.createDirectories(savingDirectory.toPath());

			/*
			 * For each file copy them to the directory for saving it
			 */
			for (File file : files) {
				try {
					String fileName = file.getName();
					File destination = new File(savingDirectory, fileName);
					Files.copy(file.toPath(), destination.toPath(), StandardCopyOption.COPY_ATTRIBUTES);
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
			}
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
