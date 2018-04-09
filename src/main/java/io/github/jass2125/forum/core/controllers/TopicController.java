/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.forum.core.controllers;

import io.github.jass2125.forum.core.entity.Topic;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import io.github.jass2125.forum.core.services.client.TopicService;
import java.util.Date;

/**
 *
 * @author Anderson Souza <jair_anderson_bs@hotmail.com>
 */
@Named
@RequestScoped
public class TopicController implements Serializable {

    @Inject
    private Topic topic;
    @EJB
    private TopicService topicService;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public void persist() {
        Date date = new Date();
        topic.setDate(date);
        System.out.println(topic);
        topicService.save(topic);
    }

}
