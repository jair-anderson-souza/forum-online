package io.github.jass2125.forum.core.session;

import io.github.jass2125.forum.core.entity.UserPrincipal;
import java.io.Serializable;
import javax.inject.Inject;
import redis.clients.jedis.Jedis;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author Anderson Souza <jair_anderson_bs@hotmail.com>
 * @since Apr 7, 2018 5:10:33 PM
 */
public class Session implements Serializable {

    @Inject
    private Jedis jedis;

    public void addUserToSession(UserPrincipal user) {
        jedis.set("user", String.valueOf(user.getId()));
    }

    public String getUserFromSession() {
        return jedis.get("user");
    }
}
