/**
 * 
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * In this class I perform the search by Signiture where the signiture is passed
 * and the arraylist of files found by tehe same signiture is returned
 */
public class SearchBySigniture {
	/*
	 * In this method for each file in the directory passed I search if it is
	 * matched with the passed signiture
	 */
	/**
	 * @param directory
	 * @param targetSignature
	 * @return
	 */
	public static ArrayList<File> searchBySignature(File directory, String targetSignature) {
		ArrayList<File> matchingFiles = new ArrayList<>();

		File[] files = directory.listFiles();
		if (files != null) {
			for (File file : files) {
				if (isSignatureMatch(file, targetSignature)) {
					matchingFiles.add(file);
				}
			}
		}
		/*
		 * Returns all the fiels that has the signiture
		 */
		return matchingFiles;
	}

	/*
	 * This method takes a file and a signiture and returns teh answer
	 */
	/**
	 * @param file
	 * @param targetSignature
	 * @return
	 */
	private static boolean isSignatureMatch(File file, String targetSignature) {
		try (FileInputStream inputStream = new FileInputStream(file)) {
			/*
			 * I divide by two because the signature is in hexadecimal so each two digit is one
			 * byte
			 */
			byte[] fileBytes = new byte[targetSignature.length() / 2];

			/**
			 * Now let's find if the the bytes from the file that match the length of the
			 * target signature
			 */
			if (inputStream.read(fileBytes) == fileBytes.length) {
				String fileSignature = bytesToHex(fileBytes);
				/*
				 * Here I compare the target signature with the file's signature and returns the
				 * answer
				 */
				return fileSignature.equalsIgnoreCase(targetSignature);
			} else {
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	/*
	 * in this method I take the array of bytes and convert it into Hexa
	 */
	private static String bytesToHex(byte[] bytes) {
		StringBuilder hexString = new StringBuilder();
		for (byte b : bytes) {
			String hex = Integer.toHexString(0xFF & b);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString().toUpperCase();
	}
}
