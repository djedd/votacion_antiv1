package com.votacion_antiv1.votacion_anti.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAHashing {

	public SHAHashing() {
	}

	public String encode(String password) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
			byte byteData[] = md.digest();
			// convert the byte to hex format method 1
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}

}
