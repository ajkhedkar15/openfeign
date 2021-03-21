package com.feign.consumer.feign;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

public class UserServiceFactory {

    public static UserClient create(String targetUrl) {
        return Feign.builder().encoder(new JacksonEncoder()).decoder(new JacksonDecoder())
                .target(UserClient.class, targetUrl);
    }
}
