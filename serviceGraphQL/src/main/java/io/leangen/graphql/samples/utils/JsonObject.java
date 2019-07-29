package io.leangen.graphql.samples.utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class JsonObject implements Serializable {
    private Integer result;
    private String message;

    public JsonObject(){

    }

    public JsonObject(Integer result, String message) {
        this.result = result;
        this.message = message;
    }
}
