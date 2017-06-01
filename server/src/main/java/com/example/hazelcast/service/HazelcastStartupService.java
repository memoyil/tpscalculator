package com.example.hazelcast.service;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IAtomicReference;
import com.hazelcast.core.ILock;
import com.hazelcast.core.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by mehyil on 27.05.2017.
 */
@Service
public class HazelcastStartupService implements StartupService {
    @Autowired
    private HazelcastInstance instance;

    public void startup() {
        IMap<Object, Object> exampleMap = instance.getMap("exampleMap");
        exampleMap.put("exampleKey","exampleEntry");
    }
}