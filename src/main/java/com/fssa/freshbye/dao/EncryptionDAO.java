package com.fssa.freshbye.dao;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public class EncryptionDAO {
	public static SecretKey generateAES256Key(String hexKey) {

		byte[] keyBytes = hexStringToByteArray(hexKey);
		return new SecretKeySpec(keyBytes, "AES");
	}

	public static byte[] hexStringToByteArray(String hex) {
		int len = hex.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4) + Character.digit(hex.charAt(i + 1), 16));
		}
		return data;
	}

	public static String encrypt(String plainText) throws Exception {
		SecretKey key = generateAES256Key("2b7e151628aed2a6abf7158809cf4f3c2b7e151628aed2a6");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
		return Base64.getEncoder().encodeToString(encryptedBytes);
	}

	public static String decrypt(String encryptedText) throws Exception {
		SecretKey key = generateAES256Key("2b7e151628aed2a6abf7158809cf4f3c2b7e151628aed2a6");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
		byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
		return new String(decryptedBytes);
	}
	
	
}
