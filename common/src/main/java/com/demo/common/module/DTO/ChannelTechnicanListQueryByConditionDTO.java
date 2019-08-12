package com.demo.common.module.DTO;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 给APP使用
 */
@Data
public class ChannelTechnicanListQueryByConditionDTO implements Serializable,Cloneable {
    @NotNull
    int pageSize;
    @NotNull
    int currPage;
    String searchCondition;

    public ChannelTechnicanListQueryByConditionDTO(int pageSize,int currPage, String searchCondition) {
        this.pageSize = pageSize;
        this.currPage = currPage;
        this.searchCondition = searchCondition;
    }
}
