package io.github.jass2125.forum.core.exceptions;


import java.io.UnsupportedEncodingException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author Anderson Souza <jair_anderson_bs@hotmail.com>
 * @since Apr 6, 2018 11:12:59 PM
 */
public class EncodingException extends RuntimeException {

    public EncodingException(UnsupportedEncodingException e, String msg) {
        super(msg, e);
    }

}
