package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information in such a way
	 * that only authorized parties can access it and those who are not authorized
	 * cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message down based
	 * on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user. Use the key to
	 * shift each letter in the users input and save the final result to a file.
	 */
	public static void main(String[] args) {
		String message = JOptionPane.showInputDialog("Write your message");
		String key = JOptionPane.showInputDialog("Write your key");
		int shift = key.length();
		String secret = "";
		char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		char[] cap = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		ArrayList<Character> newAlpha = new ArrayList<Character>();
		ArrayList<Character> newCap = new ArrayList<Character>();
		for (int i = 0; i < alphabet.length; i++) {
			if (i <= 25 - shift) {
				newAlpha.add(alphabet[i + shift]);
				newCap.add(cap[i + shift]);
			} else {
				newAlpha.add(alphabet[i + shift - 26]);
				newCap.add(cap[i + shift - 26]);
			}
		}
		System.out.println(newCap);
		for (int i = 0; i < message.length(); i++) {
			System.out.println(message.charAt(i));
			if (message.charAt(i) == ' ') {
				secret += " ";
			}

			else if (Character.isUpperCase(message.charAt(i)) == true) {
				for (int j = 0; j < 26; j++) {
					if (message.charAt(i) == cap[j]) {
						secret += newCap.get(j);
					}
				}
			} else {
				for (int j = 0; j < 26; j++) {
					if (message.charAt(i) == alphabet[j]) {
						secret += newAlpha.get(j);
					}
				}
			}
		}
		try {
			FileWriter fw = new FileWriter("Encrypted");
			fw.write(secret);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
