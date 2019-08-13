package com.demo.common.module.VO.app;

import com.demo.common.module.VO.PageVO;
import lombok.Data;

import java.util.List;

/**
 * 文件分类最终显示页面
 */
@Data
public class FileInfoTypeAppVO {
    /**
     * 文件目录列表
     */
    List<FileTypeAppVO> fileTypeVOS;
    /**
     * 文件列表
     */
    PageVO<FileAppVO> fileVOPageVO;

    public FileInfoTypeAppVO(List<FileTypeAppVO> fileTypeVOS, PageVO<FileAppVO> fileVOPageVO) {
        this.fileTypeVOS = fileTypeVOS;
        this.fileVOPageVO = fileVOPageVO;
    }
}
