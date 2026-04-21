package com.example.myempty.activity.sub;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import android.util.Base64;
import java.nio.charset.StandardCharsets;

public class esing {
 
   private static final String ALGORITHM = "AES/CBC/PKCS5Padding";

   public static String encryptAES256(String plainText, String key) throws Exception {
    // Pastikan key berukuran 32 karakter untuk AES-256
    byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
    SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

    // Menggunakan IV statis (16 byte). 
    // Untuk keamanan lebih tinggi, gunakan SecureRandom untuk IV.
    byte[] iv = new byte[16]; 
    IvParameterSpec ivSpec = new IvParameterSpec(iv);

    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivSpec);

    byte[] encrypted = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
    
    // Kembalikan dalam bentuk Base64 agar bisa dibaca sebagai String
    return Base64.encodeToString(encrypted, Base64.DEFAULT);
        
    }    

    public static String decryptAES256(String encryptedText, String key) throws Exception {
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

        byte[] iv = new byte[16];
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        // Decode dari Base64 ke Byte sebelum didekripsi
        byte[] encryptedBytes = Base64.decode(encryptedText, Base64.DEFAULT);

        // Konfigurasi Cipher untuk DECRYPT_MODE
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivSpec);

        byte[] decrypted = cipher.doFinal(encryptedBytes);
        
        return new String(decrypted, StandardCharsets.UTF_8);
    }
    
    public static long long256(long datas1, long datas2) throws Exception {
        
        
        return datas1 + datas2;
        
        
        
        
    }

}
