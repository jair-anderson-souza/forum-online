/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.forum.core.util;

import java.security.MessageDigest;

/**
 * @author Anderson Souza <jair_anderson_bs@hotmail.com>
 * @since Apr 6, 2018 11:57:25 PM
 */
public interface Cryptography {

    public MessageDigest createEncryptionAlgorithm();

    public String encryptPassword(String password);

    public byte[] encodingInSequenceOfBytes(String password);

    public String formatBytesInUTF8(byte[] dig);
}
