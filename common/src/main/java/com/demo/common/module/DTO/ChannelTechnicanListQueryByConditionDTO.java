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
    @Range(min = 1 , max = 20)
    int pageSize;
    @NotNull
    @Range(min = 0)
    int pageNum;
    String searchCondition;

    public ChannelTechnicanListQueryByConditionDTO(int pageSize,int pageNum, String searchCondition) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.searchCondition = searchCondition;
    }
}
