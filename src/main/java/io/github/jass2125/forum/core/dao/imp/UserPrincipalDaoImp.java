/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.forum.core.dao.imp;

import io.github.jass2125.forum.core.exceptions.UserNotFound;
import io.github.jass2125.forum.core.dao.client.UserPrincipalDao;
import io.github.jass2125.forum.core.entity.UserPrincipal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 * @author Anderson Souza <jair_anderson_bs@hotmail.com>
 * @since Apr 6, 2018 11:55:33 PM
 */
@Stateless
public class UserPrincipalDaoImp implements UserPrincipalDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public UserPrincipal searchByEmailAndPassword(UserPrincipal user) {
        try {
            return em.createQuery("SELECT U FROM UserPrincipal U WHERE U.email = :email AND U.password = :password", UserPrincipal.class).
                    setParameter("email", user.getEmail()).
                    setParameter("password", user.getPassword()).
                    getSingleResult();
        } catch (NoResultException e) {
            throw new UserNotFound("Dados inválidos", e);
        }
    }
}
