package com.demo.grpc.feginService;

import com.demo.common.module.DTO.FileInfoQueryDTO;
import com.demo.common.module.DTO.FilePreViewQueryDTO;
import com.demo.common.module.VO.JsonObject;
import com.demo.common.module.VO.PageVO;
import com.demo.common.module.VO.TssFsmCategory;
import com.demo.common.module.VO.TssFsmDoc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FileManageFeginServiceImpl implements FileManageFeginService {


    @Override
    public JsonObject<PageVO<TssFsmDoc>> getFileInfoList(FileInfoQueryDTO fileInfoQueryDTO) {
        log.error("fall back");
        return null;
    }

    @Override
    public JsonObject<TssFsmCategory> getFileTypeList(FilePreViewQueryDTO filePreViewQueryDTO) {
        log.error("fall back");
        return null;
    }
}
