package com.example.hazelcastclient.service;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by mehyil on 6/1/2017.
 */
@Service
public class HazelcastTestService {

    @Value("${threadSize:200}")
    private int threadSize;

    public void test() {
        AtomicLong amountRequest = new AtomicLong(0);
        HazelcastInstance hazelcastClient = getHazelcastClient();
        for (int i = 0; i < threadSize; i++) {
            new Thread(new HazelcastGetTestTask(hazelcastClient, amountRequest)).start();
        }
        new Thread(new HazelcastCalculateTask(amountRequest)).start();
    }

    private HazelcastInstance getHazelcastClient() {
        ClientConfig clientConfig = new ClientConfig();
        ClientNetworkConfig clientNetworkConfig = new ClientNetworkConfig();
        clientNetworkConfig.addAddress("127.0.0.1:5701");
        clientConfig.setNetworkConfig(clientNetworkConfig);
        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        return client;
    }
}
