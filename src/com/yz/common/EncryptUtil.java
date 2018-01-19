package com.yz.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class EncryptUtil {
	
	public static final String MD5 = "md5";
	
	public static String encrypt(String str) {
		try {
			MessageDigest digest = MessageDigest.getInstance(MD5); 
			byte[] bytes = digest.digest(str.getBytes()); 
			BASE64Encoder encoder = new BASE64Encoder(); 
			return encoder.encode(bytes); 
		} catch (NoSuchAlgorithmException e) { 
			e.printStackTrace();
		} 
		return null;
	}
}
