package com.feign.consumer.service;

import com.feign.consumer.dto.Response;
import com.feign.consumer.dto.User;
import com.feign.consumer.feign.UserClient;
import com.feign.consumer.feign.UserServiceFactory;

public class UserService {

    private static final String USER_SERVICE_HOST = "http://localhost:8081/v1/";

    public static void main(String[] args) {
        UserClient userClient = UserServiceFactory.create(USER_SERVICE_HOST);
        User newUser = User.builder().firstName("ajinkya").lastName("khedkar")
                .email("ajinkya.khedkar@gmail.com").mobileNo("1234567890").build();
        User addedUser = userClient.addUser(newUser);
        System.out.println("Created new user = " + addedUser);
        User user = userClient.getUser(addedUser.getUserId().toString());
        System.out.println("User = " + user);

        Response<String> extractedPath = userClient.getExtractedPath("abc.pdf");
        System.out.println(extractedPath.getData());
    }
}
