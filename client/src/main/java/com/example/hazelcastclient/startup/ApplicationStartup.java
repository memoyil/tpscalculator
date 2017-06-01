package com.example.hazelcastclient.startup;

import com.example.hazelcastclient.service.HazelcastTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by mehyil on 27.05.2017.
 */
@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private HazelcastTestService hazelcastTestService;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        hazelcastTestService.test();
    }

}
