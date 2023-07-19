/**
 * 
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 	In this class I created the solution for calcuatling and comparing a SHA-256 hash string
 */
public class CalculateCompareHash {
	/*
	 * This method I created to return the hash value using the MessageGigest class SHA-256
	 */
	/**
	 * @param file
	 * @return the hash 
	 */
	public static String calculateHash(File file) {
        try (var fileInputStream = new FileInputStream(file)) {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytesBuffer = new byte[1024];
            int bytesRead;
            
            while ((bytesRead = fileInputStream.read(bytesBuffer)) != -1) {
                digest.update(bytesBuffer, 0, bytesRead);
            }
            
            byte[] hashedBytes = digest.digest();

            StringBuilder stringBuilder = new StringBuilder();
            
            for (byte hashedByte : hashedBytes) {
                stringBuilder.append(Integer.toString((hashedByte & 0xff) + 0x100, 16).substring(1));
            }
            
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
	
	/*
	 * In this method two files hashes are compared if they matched or not is returned 
	 */
	/**
	 * @param originalFragment
	 * @param retrievedFragment
	 * @return
	 */
	public static String compareHashs(File originalFragment, File retrievedFragment) {
		String originalHash = calculateHash(originalFragment);
		String retrievedHash = calculateHash(retrievedFragment);

		// Compare the hash values
		if (originalHash.equals(retrievedHash)) {
		    return "Match";
		} else {
		    return "Mismatch";
		}
	}
}