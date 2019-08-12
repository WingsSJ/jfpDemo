package com.demo.common.module.DTO;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class ChannelCompanyListQueryByConditionDTO implements Serializable,Cloneable{
    @NotNull
    int pageSize;
    @NotNull
    int currPage;
    /**
     * 服务星级 1到5级
     */
    int starLevel;
    /**
     * 搜索条件
     */
    String searchCondition;
}
