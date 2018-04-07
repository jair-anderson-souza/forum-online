/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.forum.core.dao.client;

import io.github.jass2125.forum.core.entity.UserPrincipal;

/**
 * @author Anderson Souza <jair_anderson_bs@hotmail.com>
 * @since Apr 6, 2018 11:56:04 PM
 */
public interface UserPrincipalDao {

    public UserPrincipal searchByEmailAndPassword(UserPrincipal user);

    public UserPrincipal persist(UserPrincipal newUser);
}
