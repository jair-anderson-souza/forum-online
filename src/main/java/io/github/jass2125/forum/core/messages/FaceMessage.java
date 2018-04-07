package io.github.jass2125.forum.core.messages;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author Anderson Souza <jair_anderson_bs@hotmail.com>
 * @since Apr 7, 2018 5:09:35 PM
 */
public class FaceMessage implements Serializable {

    @Inject
    private FacesContext context;
    @Inject
    private ExternalContext externalContext;

    public void addMessage(String message) {
        FacesMessage faceMessage = new FacesMessage(message);
        externalContext.getFlash().setKeepMessages(true);
        context.addMessage(null, faceMessage);
    }
}
