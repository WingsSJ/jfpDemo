package com.demo.common.module.VO;


import lombok.Data;

import java.util.List;

/**
 * 文件资料列表
 */
@Data
public class FileInfomationVO {
    /**
     *
     */
    List<FileTypeVO> fileTypeVOS;
    /**
     *
     */
    PageVO<FileVO> fileVOPageVO;
}
