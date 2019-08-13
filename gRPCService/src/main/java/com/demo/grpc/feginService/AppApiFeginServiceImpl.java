package com.demo.grpc.feginService;


import com.demo.common.module.DTO.ChannelCompanyListQueryByConditionDTO;
import com.demo.common.module.DTO.ChannelTechnicanListQueryByConditionDTO;
import com.demo.common.module.DTO.FileInfoQueryDTO;
import com.demo.common.module.DTO.FileTypeListQueryDTO;
import com.demo.common.module.VO.JsonObject;
import com.demo.common.module.VO.PageVO;
import com.demo.common.module.VO.app.ChannelCompanyAppVO;
import com.demo.common.module.VO.app.ChannelTechnicanAppVO;
import com.demo.common.module.VO.app.FileAppVO;
import com.demo.common.module.VO.app.FileInfoTypeAppVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Component
@Slf4j
public class AppApiFeginServiceImpl implements AppApiFeginService {

    @Override
    public JsonObject<PageVO<ChannelCompanyAppVO>> queryChannelCompanyInfoList(@Valid ChannelCompanyListQueryByConditionDTO channelCompanyListQueryByConditionDTO) {
        log.error("fall back");
        return null;
    }

    @Override
    public JsonObject<PageVO<ChannelTechnicanAppVO>> queryChannelTechnicanInfoList(@Valid ChannelTechnicanListQueryByConditionDTO channelTechnicanListQueryByConditionDTO) {
        log.error("fall back");
        return null;
    }

    @Override
    public JsonObject<FileInfoTypeAppVO> queryFileInfoList(@Valid FileTypeListQueryDTO fileInfoQueryDTO) {
        log.error("fall back");
        return null;
    }

    @Override
    public JsonObject<PageVO<FileAppVO>> queryCategoryInfoList(@Valid FileInfoQueryDTO fileInfoQueryDTO) {
        log.error("fall back");
        return null;
    }

    @Override
    public JsonObject<String> filePreView(@NotNull String fid) {
        log.error("fall back");
        return null;
    }
}
