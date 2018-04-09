/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.forum.core.controllers;

import io.github.jass2125.forum.core.entity.UserPrincipal;
import io.github.jass2125.forum.core.messages.FaceMessage;
import io.github.jass2125.forum.core.services.client.UserService;
import io.github.jass2125.forum.core.session.Session;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
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
    @Inject
    private UserPrincipal newUser;
    @Inject
    private Session session;
    @Inject
    private FaceMessage faceMessage;

    @PostConstruct
    public void init() {
    }

    public UserPrincipal getUser() {
        return user;
    }

    public void setUser(UserPrincipal user) {
        this.user = user;
    }

    public UserPrincipal getNewUser() {
        return newUser;
    }

    public void setNewUser(UserPrincipal newUser) {
        this.newUser = newUser;
    }

    public String login() {
        UserPrincipal user = retriveUser();
        if (user != null) {
            this.faceMessage.addMessage("Seja Bem Vindo " + user.getName());
            addToSession(user);
            return "/user/home.xhtml?faces-redirect=true";
        }
        this.faceMessage.addMessage("Dados inválidos, tente novamente!!");
        return "signin.xhtml?faces-redirect=true";
    }

    public UserPrincipal retriveUser() {
        try {
            return userService.login(user);
        } catch (RuntimeException e) {
            return null;
        }
    }

    public void addToSession(UserPrincipal user) {
        this.session.addUserToSession(user);
    }

    public String createAccount() {
        UserPrincipal user = persist();
        if (user != null) {
            this.faceMessage.addMessage("Seja Bem Vindo!!");
            return "/user/home.xhtml?faces-redirect=true";
        }
        this.faceMessage.addMessage("erro no cadastro, tente novamente");
        return "index.xhtml";
    }

    public UserPrincipal persist() {
        try {
            return userService.save(newUser);
        } catch (RuntimeException e) {
            return null;
        }
    }
}
