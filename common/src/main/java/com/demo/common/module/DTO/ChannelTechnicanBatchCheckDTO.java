package com.demo.common.module.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.File;

@Data
public class ChannelTechnicanBatchCheckDTO {
    String fileUrl;
    @NotBlank
    String companyName;
    @NotBlank
    String companyId;
    @NotNull
    File file;
}
