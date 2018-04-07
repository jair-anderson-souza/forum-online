/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.forum.core.produces;

import java.util.Map;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

/**
 * @author Anderson Souza <jair_anderson_bs@hotmail.com>
 * @since Apr 7, 2018 5:25:39 PM
 */
public class FacesMessageProducer {

    @Produces
    private Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

}
