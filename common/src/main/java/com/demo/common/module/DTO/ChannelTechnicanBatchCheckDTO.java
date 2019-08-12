package com.demo.common.module.DTO;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

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
    MultipartFile file;
}
