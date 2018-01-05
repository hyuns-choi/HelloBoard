package com.oraclejava.model;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public class SimpleExample {
	public static void main (String[] args)
			throws Exception
	{
		/*
		if (args.length != 1) {
			System.err.println("Usage: java SimpleExample text");
			System.exit(1);
		}
		String text = args[0];
		*/
		String text = "192102";
		

		System.out.println("Generating a TripleDES key...");

		// Create a TripleDES key
		KeyGenerator keyGenerator = KeyGenerator.getInstance("TripleDES");
		keyGenerator.init(168);        // need to initialize with the keysize
		Key key = keyGenerator.generateKey();

		System.out.println("Done generating the key.");

		// Create a cipher using that key to initialize it
		Cipher cipher = Cipher.getInstance("TripleDES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key);

		byte[] plaintext = text.getBytes("UTF8");

		// Print out the bytes of the plaintext
		System.out.println("\nPlaintext: ");
		for (int i=0;i<plaintext.length;i++) {
			System.out.print(plaintext[i]+" ");
		}

		// Perform the actual encryption
		byte[] ciphertext = cipher.doFinal(plaintext);

		// Print out the ciphertext
		System.out.println("\n\nCiphertext: ");
		for (int i=0;i<ciphertext.length;i++) {
			System.out.print(ciphertext[i]+" ");
		}

		// Re-initialize the cipher to decrypt mode
		cipher.init(Cipher.DECRYPT_MODE, key);

		// Perform the decryption
		byte[] decryptedText = cipher.doFinal(ciphertext);

		String output = new String(decryptedText,"UTF8");

		System.out.println("\n\nDecrypted text: "+output);


	}
}
