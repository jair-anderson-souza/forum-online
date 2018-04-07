package io.github.jass2125.forum.core.util;

import com.sun.javafx.scene.traversal.Algorithm;
import io.github.jass2125.forum.core.exceptions.CryptographyException;
import io.github.jass2125.forum.core.exceptions.EncodingException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.ejb.Stateless;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author Anderson Souza <jair_anderson_bs@hotmail.com>
 * @since Apr 6, 2018 11:12:18 PM
 */
@Stateless
public class CryptographyImp implements Cryptography {

    private MessageDigest instance;

    public CryptographyImp() {
    }

    @Override
    public String encryptPassword(String password) {
        this.instance = createEncryptionAlgorithm();
        byte[] dig = this.instance.digest(encodingInSequenceOfBytes(password));
        return formatBytesInUTF8(dig);
    }

    @Override
    public MessageDigest createEncryptionAlgorithm() {
        try {
            return MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new CryptographyException(e, "Não foi possível criar o algoritmo de criptografia especificado");
        }
    }

    @Override
    public byte[] encodingInSequenceOfBytes(String password) {
        try {
            return password.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new EncodingException(e, "Não foi possível realizar a codificação da senha!");
        }
    }

    @Override
    public String formatBytesInUTF8(byte[] dig) {
        StringBuilder builder = new StringBuilder();
        for (byte b : dig) {
            builder.append(String.format("%02X", 0xFF & b));
        }
        return builder.toString();
    }
}
