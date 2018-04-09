/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.forum.core.dao.client;

import org.bson.Document;

/**
 * @author Anderson Souza <jair_anderson_bs@hotmail.com>
 * @since Apr 8, 2018 10:38:36 PM
 */
public interface TopicDao {

    public void persist(Document document);

}
