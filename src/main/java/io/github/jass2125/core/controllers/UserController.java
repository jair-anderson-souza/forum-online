/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.core.controllers;

import io.github.jass2125.core.services.imp.UserService;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * @author Anderson Souza <jair_anderson_bs@hotmail.com>
 * @since Mar 19, 2018 9:20:39 PM
 */
@Named
@RequestScoped
public class UserController implements Serializable {

    @EJB
    private UserService userService;
    
    public void login(){
        System.out.println("Entrou");
    }
}
