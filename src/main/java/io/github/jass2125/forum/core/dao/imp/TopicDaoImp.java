/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.forum.core.dao.imp;

import io.github.jass2125.forum.core.entity.Topic;
import io.github.jass2125.forum.core.exceptions.Persistexception;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import io.github.jass2125.forum.core.dao.client.TopicDao;

/**
 * @author Anderson Souza <jair_anderson_bs@hotmail.com>
 * @since Apr 8, 2018 10:39:38 PM
 */
@Stateless
public class TopicDaoImp implements TopicDao {

    @PostConstruct
    public void init() {

    }

    @Override
    public Topic persist(Topic topic) {
        try {

            return topic;
        } catch (Exception e) {
            throw new Persistexception("Não foi possível realizar o cadastro!!!", e);
        }
    }

}
