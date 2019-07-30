package com.demo.common.module.VO;

import lombok.Data;

import java.util.List;

@Data
public class PageVO<T>{
    /**
     * 当前页数
     */
    private Integer currPage;
    /**
     * 每页的数量
     */
    private Integer pageSize;
    /**
     * 总记录数
     */
    private Integer totalCount;
    /**
     *当前页中数据
     */
    private List<T> list;

    public PageVO(Integer currPage, Integer pageSize, Integer totalCount, List<T> list) {
        this.currPage = currPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.list = list;
    }
}
