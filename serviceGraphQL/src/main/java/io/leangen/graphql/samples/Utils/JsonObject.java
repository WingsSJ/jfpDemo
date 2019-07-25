package io.leangen.graphql.samples.Utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class JsonObject implements Serializable {
    private Integer result;
    private String message;

    protected JsonObject(){

    }

    public JsonObject(Integer result, String message) {
        this.result = result;
        this.message = message;
    }
}
