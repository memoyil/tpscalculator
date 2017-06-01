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
        while (true) {
            System.out.println("==========================");
            System.out.println("TPS : " + amountRequest.get());
            System.out.println("==========================");
            amountRequest.set(0);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
