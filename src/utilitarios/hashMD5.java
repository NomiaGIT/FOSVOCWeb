package utilitarios;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class hashMD5 {
/**
 * retorna el string codificado a MD5, a partir de un String comun
 * @param input el String comun
 * @return
 */
	public String md5(String input) {	    
	    String md5 = null;	     
	    if(null == input) return null;	     
	    try {	         
	    //Create MessageDigest object for MD5
	    MessageDigest digest = MessageDigest.getInstance("MD5");	     
	    //Update input string in message digest
	    digest.update(input.getBytes(), 0, input.length());
	    //Converts message digest value in base 16 (hex) 
	    md5 = new BigInteger(1, digest.digest()).toString(16);
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    }
	    return md5;
	}
	
		
}
