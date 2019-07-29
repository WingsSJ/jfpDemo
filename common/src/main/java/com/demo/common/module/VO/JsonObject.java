package com.demo.common.module.VO;

import lombok.Data;

import java.io.Serializable;

@Data
public class JsonObject<T> implements Serializable {
    private Integer result;
    private String message;
    private T objEntity;
    public JsonObject(){

    }

    public JsonObject(Integer result, String message) {
        this.result = result;
        this.message = message;
    }

    public JsonObject(Integer result, String message, T objEntity) {
        this.result = result;
        this.message = message;
        this.objEntity = objEntity;
    }
}
