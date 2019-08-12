package com.demo.common.module.DTO;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FileInfoQueryDTO {
    @NotNull
    int pageSize;
    @NotNull
    int currPage;
    String searchCondition;
    /**
     * 时间  0 一周内 1 一个月内 2 半年内
     */
    int times;
    String typeId;

    public FileInfoQueryDTO(@NotNull int pageSize, @NotNull int currPage, String searchCondition, int times) {
        this.pageSize = pageSize;
        this.currPage = currPage;
        this.searchCondition = searchCondition;
        this.times = times;
    }

    public FileInfoQueryDTO(@NotNull int pageSize, @NotNull int currPage, String typeId) {
        this.pageSize = pageSize;
        this.currPage = currPage;
        this.typeId = typeId;
    }
}
