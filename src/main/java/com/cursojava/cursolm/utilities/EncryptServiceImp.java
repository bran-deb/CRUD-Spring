package com.cursojava.cursolm.utilities;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;


@Service
public class EncryptServiceImp implements EncryptService {

    @Override
    public String encryptPassword(String password) {

        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public String verifyPassword(String password, String hashPassword) {

        return null;
    }
}
