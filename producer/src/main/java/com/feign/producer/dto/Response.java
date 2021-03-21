package com.feign.producer.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(content = JsonInclude.Include.NON_EMPTY)
public class Response<T> {

    private T data;
    private Boolean isErrorred;
    private ResponseStatus status;

    public static <U> Response<U> build(U u) {
        return Response.<U>builder().status(new ResponseStatus(HttpStatus.OK))
                .data(u).build();
    }

    public static <U> Response<U> build(U u, HttpStatus status) {
        return Response.<U>builder().status(new ResponseStatus(status))
                .data(u).build();
    }

    public static <U> Response<U> buildError(U u) {
        return Response.<U>builder().status(new ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR))
                .isErrorred(true).data(u)
                .build();
    }

    public static <U> Response<U> buildError(U u, HttpStatus status) {
        return Response.<U>builder().status(new ResponseStatus(status))
                .isErrorred(true).data(u)
                .build();
    }
}
