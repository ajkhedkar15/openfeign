package com.feign.producer.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
public class ResponseStatus {

    private Integer value;
    private String phrase;

    public ResponseStatus(HttpStatus status) {
        this.value = status.value();
        this.phrase = status.getReasonPhrase();
    }

}
