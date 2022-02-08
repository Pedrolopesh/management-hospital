package com.management.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptPassword {
    /* Plain-text password initialization. */
    String password = "myPassword";
    String encryptedpassword = null;

    public String encrypt(String password) throws NoSuchAlgorithmException {
        try {
            /* MessageDigest instance for MD5. */
            MessageDigest m = MessageDigest.getInstance("MD5");

            /* Add plain-text password bytes to digest using MD5 update() method. */
            m.update(this.password.getBytes());

            /* Convert the hash value into bytes */
            byte[] bytes = m.digest();

            /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            /* Complete hashed password in hexadecimal format */
            this.encryptedpassword = s.toString();

            return this.encryptedpassword;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        /* Display the unencrypted and encrypted passwords. */
        System.out.println("Plain-text password: " + this.password);
        System.out.println("Encrypted password using MD5: " + encryptedpassword);
        return null;
    }
}
