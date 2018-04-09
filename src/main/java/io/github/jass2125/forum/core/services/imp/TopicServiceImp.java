/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.forum.core.services.imp;

import io.github.jass2125.forum.core.entity.Topic;
import javax.ejb.Stateless;
import io.github.jass2125.forum.core.services.client.TopicService;
import io.github.jass2125.forum.core.dao.client.TopicDao;

/**
 * @author Anderson Souza <jair_anderson_bs@hotmail.com>
 * @since Apr 8, 2018 10:35:02 PM
 */
@Stateless
public class TopicServiceImp implements TopicService {

    private TopicDao topicDao;

    @Override
    public Topic save(Topic topic) {
        try {
            return topicDao.persist(topic);
        } catch (RuntimeException e) {
            throw e;
        }
    }
}
