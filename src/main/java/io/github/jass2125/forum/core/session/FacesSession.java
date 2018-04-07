package io.github.jass2125.forum.core.session;

import io.github.jass2125.forum.core.entity.UserPrincipal;
import java.io.Serializable;
import java.util.Map;
import javax.inject.Inject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author Anderson Souza <jair_anderson_bs@hotmail.com>
 * @since Apr 7, 2018 5:10:33 PM
 */
public class FacesSession implements Serializable {

    @Inject
    private Map<String, Object> session;

    public void addUserToSession(UserPrincipal user) {
        session.put("user", user);
    }
}
