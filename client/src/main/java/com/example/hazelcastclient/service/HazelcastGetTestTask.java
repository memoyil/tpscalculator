package com.example.hazelcastclient.service;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by mehyil on 6/1/2017.
 */
public class HazelcastGetTestTask implements Runnable {

    private HazelcastInstance hazelcastInstance;

    private AtomicLong amountRequest;

    public HazelcastGetTestTask(HazelcastInstance hazelcastClient, AtomicLong amountRequest) {
        this.hazelcastInstance = hazelcastClient;
        this.amountRequest = amountRequest;
    }

    @Override
    public void run() {
        while (true) {
            IMap map = hazelcastInstance.getMap("exampleMap");
            String key = (String) map.get("exampleKey");
            if (key.equals("exampleEntry")) {
                amountRequest.incrementAndGet();
            }
        }
    }
}
