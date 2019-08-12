package com.demo.common.module.DTO;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FilePreViewQueryDTO {
    /**
     * 文件id
     */
    @NotNull
    private String fileId;

    public FilePreViewQueryDTO(String fileId) {
        this.fileId = fileId;
    }
}
