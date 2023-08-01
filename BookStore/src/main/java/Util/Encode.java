package Util;

import java.security.MessageDigest;

import org.apache.tomcat.util.codec.binary.Base64;

public class Encode {
	// Encode MD5
	// Encode SHA-1 (often used)
	
	public static String toSHA1 (String str) {
		String salt = "asidasdazxb@#$%!@^@*()./QREWPALqwensad;GigicutekhongaiBANG;<[1]2312;";
		String result = null;
		
		str += salt;
		try {
			byte[] dataBytes = str.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			result = Base64.encodeBase64String(md.digest(dataBytes));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	
}
