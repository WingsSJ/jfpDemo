package com.demo.common.module.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ChannelTechnicanCheckDTO {
    @NotBlank
    String personId;
    /**
     * 审核状态 0待审核 1审核通过 2审核不通过
     */
    @NotNull
    int review;
    /**
     * 没有审核通过的原因 如果没有通过 则为必填项
     */
    String notPassCause;
}
