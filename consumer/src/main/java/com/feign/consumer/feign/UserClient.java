package com.feign.consumer.feign;

import com.feign.consumer.dto.Response;
import com.feign.consumer.dto.User;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers("Content-Type: application/json")
public interface UserClient {

    @RequestLine("POST /user")
    User addUser(User user);

    @RequestLine("GET /user/{id}")
    User getUser(@Param("id") String id);

    @RequestLine("GET /extracted-content/{filePath}")
    Response<String> getExtractedPath(@Param("filePath") String filePath);
}
