package com.example.hazelcastclient.config;

import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mehyil on 6/1/2017.
 */
@Configuration
public class HazelcastConfiguration {
    @Bean
    public ClientConfig config() {
        return new ClientConfig();
    }
}