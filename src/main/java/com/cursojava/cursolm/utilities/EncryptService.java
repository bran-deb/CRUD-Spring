package com.cursojava.cursolm.utilities;

public interface EncryptService {

    String encryptPassword(String password);

    String verifyPassword(String password, String hashPassword);
}
