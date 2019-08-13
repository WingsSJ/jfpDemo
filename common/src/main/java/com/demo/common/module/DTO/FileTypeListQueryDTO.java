package com.demo.common.module.DTO;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 资料目录列表
 */
@Data
public class FileTypeListQueryDTO {
    /**
     * 文件目录 id 默认为 0
     */
    private Integer typeId =0;
    @NotNull
    int pageSize;
    @NotNull
    int currPage;
    /**
     * 时间  0 一周内 1 一个月内 2 半年内
     */
    private Integer times;

    public FileTypeListQueryDTO(Integer typeId, @NotNull int pageSize, @NotNull int currPage) {
        this.typeId = typeId;
        this.pageSize = pageSize;
        this.currPage = currPage;
    }

    public FileTypeListQueryDTO(Integer typeId) {
        this.typeId = typeId;
    }
}
