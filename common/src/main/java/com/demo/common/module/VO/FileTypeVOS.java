package com.demo.common.module.VO;

import lombok.Data;

import java.util.List;

/**
 * 文件分类最终显示页面
 */
@Data
public class FileTypeVOS {
    /**
     * 文件目录列表
     */
    List<FileTypeVO> fileTypeVOS;
    /**
     * 文件列表
     */
    PageVO<FileVO> fileVOPageVO;

    public FileTypeVOS(List<FileTypeVO> fileTypeVOS, PageVO<FileVO> fileVOPageVO) {
        this.fileTypeVOS = fileTypeVOS;
        this.fileVOPageVO = fileVOPageVO;
    }
}
