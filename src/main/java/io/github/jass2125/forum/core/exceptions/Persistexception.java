/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.forum.core.exceptions;

/**
 * @author Anderson Souza <jair_anderson_bs@hotmail.com>
 * @since Apr 7, 2018 4:39:28 PM
 */
public class Persistexception extends RuntimeException {

    public Persistexception(String msg, Exception e) {
        super(msg, e);
    }

}
