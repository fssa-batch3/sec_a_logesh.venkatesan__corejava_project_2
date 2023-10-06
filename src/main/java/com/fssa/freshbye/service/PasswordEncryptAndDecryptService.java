package com.fssa.freshbye.service;


import com.fssa.freshbye.dao.EncryptionDAO;

public class PasswordEncryptAndDecryptService {
	public String Encrypt(String password) {
		   String encryptedpassword = null;
			try {
				encryptedpassword = EncryptionDAO.encrypt(password);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return encryptedpassword;
		   
	   }
	
	
	public String Decrypt(String password) {
		   String encryptedpassword = null;
			try {
				encryptedpassword = EncryptionDAO.decrypt(password);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return encryptedpassword;
		   
	   }
}
