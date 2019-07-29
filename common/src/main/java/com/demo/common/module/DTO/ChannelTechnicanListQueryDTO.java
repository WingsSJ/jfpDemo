package com.demo.common.module.DTO;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Data
public class ChannelTechnicanListQueryDTO {
    @NotNull
    @Range(min = 1 , max = 20)
    int pageSize;
    @NotNull
    @Range(min = 0)
    int pageNum;
    String companyName;
    String personName;
}
