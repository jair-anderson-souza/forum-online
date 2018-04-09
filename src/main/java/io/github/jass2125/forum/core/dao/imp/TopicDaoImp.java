/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.forum.core.dao.imp;

import com.mongodb.client.MongoCollection;
import io.github.jass2125.forum.core.exceptions.Persistexception;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import io.github.jass2125.forum.core.dao.client.TopicDao;
import javax.inject.Inject;
import org.bson.Document;

/**
 * @author Anderson Souza <jair_anderson_bs@hotmail.com>
 * @since Apr 8, 2018 10:39:38 PM
 */
@Stateless
public class TopicDaoImp implements TopicDao {

    @Inject
    private MongoCollection<Document> colletion;

    @PostConstruct
    public void init() {
    }

    @Override
    public void persist(Document document) {
        try {
            colletion.insertOne(document);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Persistexception("Não foi possível realizar o cadastro!!!", e);
        }
    }
}
