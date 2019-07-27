package com.demo.channel.model.DTO;

import lombok.Data;

@Data
public class CasAreaMapDTO {
    /**
     * 主键id
     */
    private String uuid;
    /**
     * 父id(上级id,省级别上级id为null 而且自身code值以0000结尾)
     */
    private String pid;
    /**
     * 地区名
     */
    private String areaName;
    /**
     * 地区编码
     */
    private String code;
}
