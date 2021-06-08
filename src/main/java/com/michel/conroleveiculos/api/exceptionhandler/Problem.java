package com.michel.conroleveiculos.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Builder
public class Problem {

    private Integer status;
    private OffsetDateTime timestamp;
    private String type;
    private String title;
    private String datail;
    private String userMessage;
    private List<Object> objects;

    @Builder
    @Getter
    public static class Object {
        private String name;
        private String userMessage;
    }
}
