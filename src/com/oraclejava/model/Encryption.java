package com.oraclejava.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {
	
	private MessageDigest md = null;
	
	public static void main(String[] args) {
		final String algorithmName = "SHA-256";
		final String password = "p12345";
		
		Encryption e = new Encryption(algorithmName);
		byte[] bytes = e.toHashValue(password);
		String result = e.toEncryptedString(bytes);
		System.out.println(result);
	}
	
	// MD2, MD5, SHA, SHA-256, SHA-384, SHA-512
	public Encryption(String algorithmName) {
		try {
			md = MessageDigest.getInstance(algorithmName);
		}
		catch (NoSuchAlgorithmException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public byte[] toHashValue(String password) {
		md.update(password.getBytes());
		
		return md.digest();
	}
	
	public String toEncryptedString(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for(byte b : bytes) {
			String hex = String.format("%02x", b);
			sb.append(hex);
		}
		
		return sb.toString();
	}

}
