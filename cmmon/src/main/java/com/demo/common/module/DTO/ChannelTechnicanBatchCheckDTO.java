package com.demo.common.module.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ChannelTechnicanBatchCheckDTO {
    @NotBlank
    String fileUrl;
    @NotBlank
    String companyName;
    @NotBlank
    String companyId;
}
