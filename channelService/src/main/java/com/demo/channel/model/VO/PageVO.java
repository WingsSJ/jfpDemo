package com.demo.channel.model.VO;

import lombok.Data;

import java.util.List;

@Data
public class PageVO<T>{
    /**
     * 当前页数
     */
    private Integer currentPageNum;
    /**
     * 每页的数量
     */
    private Integer perPageSize;
    /**
     * 总记录数
     */
    private Integer totalCount;
    /**
     *当前页中数据
     */
    private List<T> entityList;

    private Integer result;

    private String message;

    public PageVO(Integer currentPageNum, Integer perPageSize, Integer totalCount, List<T> entityList) {
        this.currentPageNum = currentPageNum;
        this.perPageSize = perPageSize;
        this.totalCount = totalCount;
        this.entityList = entityList;
        this.message = "query success";
        this.result = 0;
    }
}
