package io.leangen.graphql.samples.model.VO;

import lombok.Data;

@Data
public class HttpBaseVO {
    /**
     * 返回状态码
     */
    private Integer code;
    /**
     * 返回描述
     */
    private String description;

    public HttpBaseVO(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
