package com.shares.rest.api.utils;

public class HashCode {
    public static String md5(String input) throws java.security.NoSuchAlgorithmException {
        String result = input;
        if(input != null) {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5"); //or "SHA-1"
            md.update(input.getBytes());
            java.math.BigInteger hash = new java.math.BigInteger(1, md.digest());
            result = hash.toString(16);
            while(result.length() < 32) { //40 for SHA-1
                result = "0" + result;
            }
        }
        return result;
    }
    
    public static boolean isValidMD5(String sMd5) {
        return sMd5.matches("^[a-fA-F0-9]{32}$");
    }
}
