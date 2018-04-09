/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.forum.core.produces;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javax.enterprise.inject.Produces;
import org.bson.Document;

/**
 * @author Anderson Souza <jair_anderson_bs@hotmail.com>
 * @since Apr 9, 2018 2:48:01 PM
 */
public class MongoProducer {

    @Produces
    private MongoClient MongoClient = new MongoClient("localhost", 27017);
    @Produces
    private MongoDatabase mongoDatabase = MongoClient.getDatabase("test");
    @Produces
    private MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("forum");
}
