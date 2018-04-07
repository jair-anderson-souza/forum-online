/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.forum.core.produces;

import java.io.Serializable;
import javax.enterprise.inject.Produces;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * @author Anderson Souza <jair_anderson_bs@hotmail.com>
 * @since Apr 7, 2018 5:22:21 PM
 */
public class FacesContextProducer implements Serializable {

    @Produces
    private FacesContext context = FacesContext.getCurrentInstance();
    @Produces
    private ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    
}
