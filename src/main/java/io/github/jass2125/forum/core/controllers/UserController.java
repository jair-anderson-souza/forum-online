/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.forum.core.controllers;

import io.github.jass2125.forum.core.entity.UserPrincipal;
import io.github.jass2125.forum.core.services.client.UserService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
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
    @Inject
    private UserPrincipal user;

    @PostConstruct
    public void init() {
    }

    public UserPrincipal getUser() {
        return user;
    }

    public void setUser(UserPrincipal user) {
        this.user = user;
    }

    public String login() {
        UserPrincipal user = retriveUser();
        if (user != null) {
            addToSession(user);
            return "/user/home.xhtml?faces-redirect=true";
        }
        FacesMessage message = new FacesMessage("Dados inválidos, tente novamente!!");
        FacesContext.getCurrentInstance().addMessage(null, message);
        return "index.xhtml";
    }

    public UserPrincipal retriveUser() {
        try {
            return userService.login(user);
        } catch (RuntimeException e) {
            
            return null;
        }
    }

    public void addToSession(UserPrincipal user) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);
    }

}
