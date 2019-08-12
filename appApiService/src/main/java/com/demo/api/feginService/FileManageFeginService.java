package com.demo.api.feginService;

import com.demo.common.module.DTO.FileInfoQueryDTO;
import com.demo.common.module.DTO.FilePreViewQueryDTO;
import com.demo.common.module.VO.JsonObject;
import com.demo.common.module.VO.PageVO;
import com.demo.common.module.VO.TssFsmCategory;
import com.demo.common.module.VO.TssFsmDoc;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 文件管理
 */
@Component
@FeignClient(value = "FileManageService",fallback = ChannelFeginServiceImpl.class,configuration = FeignConfig.class)
public interface FileManageFeginService {
    /**
     *
     */
    @PostMapping("/file/condition/query/info")
    JsonObject<PageVO<TssFsmDoc>> getFileInfoList(@RequestBody FileInfoQueryDTO fileInfoQueryDTO);

    /**
     *
     */
    @PostMapping("/file/condition/query/category")
    JsonObject<TssFsmCategory> getFileTypeList(@RequestBody FilePreViewQueryDTO filePreViewQueryDTO);
}
