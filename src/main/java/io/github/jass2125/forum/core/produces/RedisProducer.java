/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.forum.core.produces;

import java.io.Serializable;
import javax.enterprise.inject.Produces;
import redis.clients.jedis.Jedis;

/**
 * @author Anderson Souza <jair_anderson_bs@hotmail.com>
 * @since Apr 9, 2018 12:51:35 AM
 */
public class RedisProducer implements Serializable {

    @Produces
    private Jedis redis = new Jedis("localhost", 6379);
}
