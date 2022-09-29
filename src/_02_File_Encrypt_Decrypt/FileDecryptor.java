package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and
	 * understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up, at
	 * the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is
	 * decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	public static void main(String[] args) {
		String key = JOptionPane.showInputDialog("Please enter the decryption key");
		int shift = key.length();
		String unsecret = "";
		String secret = "";
		char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		char[] cap = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		try {
			BufferedReader br = new BufferedReader(new FileReader("Encrypted"));

			String line = br.readLine();
			secret = line;
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == ' ') {
				unsecret += " ";
			} else if (Character.isUpperCase(secret.charAt(i)) == true) {
				for (int j = 0; j < 26; j++) {
					if (secret.charAt(i) == cap[j]) {
						if (j < shift) {
							unsecret += cap[j + 26 - shift];
						} else {
							unsecret += cap[j - shift];
						}
					}
				}
			} else {
				for (int j = 0; j < 26; j++) {
					if (secret.charAt(i) == alphabet[j]) {
						if (j < shift) {
							unsecret += alphabet[j + 26 - shift];
						} else {
							unsecret += alphabet[j - shift];
						}
					}
				}
			}
		}
		JOptionPane.showMessageDialog(null, unsecret);
	}
}
