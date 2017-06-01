package com.example.hazelcastclient.service;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by mehyil on 6/1/2017.
 */
public class HazelcastCalculateTask implements Runnable {

    private AtomicLong amountRequest;

    public HazelcastCalculateTask(AtomicLong amountRequest) {
        this.amountRequest = amountRequest;
    }

    @Override
    public void run() {
        Long lastAmountOfRequest = 0L;
        while (true) {
            System.out.println("==========================");
            Long tps = amountRequest.get() - lastAmountOfRequest;
            System.out.println("TPS : " + tps);
            lastAmountOfRequest = amountRequest.get();
            System.out.println("==========================");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
