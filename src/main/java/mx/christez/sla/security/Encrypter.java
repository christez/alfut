package mx.christez.sla.security;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class Encrypter {
	private String iv;
	private String secretKeySpec;
	
	public String decrypt(String code) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
    	IvParameterSpec iv = new IvParameterSpec(getIv().getBytes("UTF-8"));
        SecretKeySpec secretKeySpec = new SecretKeySpec(getSecretKeySpec().getBytes("UTF-8"), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, iv);

        return new String(cipher.doFinal(Base64.decodeBase64(code.getBytes())));
    }
	
	public String encrypt(String code) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		IvParameterSpec iv = new IvParameterSpec(getIv().getBytes("UTF-8"));
        SecretKeySpec secretKeySpec = new SecretKeySpec(getSecretKeySpec().getBytes("UTF-8"), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, iv);

        return new String(Base64.encodeBase64(cipher.doFinal(code.getBytes())));
    }

	public String getIv() {
		return iv;
	}

	public void setIv(String iv) {
		this.iv = iv;
	}

	public String getSecretKeySpec() {
		return secretKeySpec;
	}

	public void setSecretKeySpec(String secretKeySpec) {
		this.secretKeySpec = secretKeySpec;
	}
}
