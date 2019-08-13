package com.demo.api.feginService;


import com.demo.common.module.DTO.ChannelCompanyListQueryByConditionDTO;
import com.demo.common.module.DTO.ChannelTechnicanListQueryByConditionDTO;
import com.demo.common.module.VO.ChannelCompanyVO;
import com.demo.common.module.VO.ChannelTechnicanVO;
import com.demo.common.module.VO.JsonObject;
import com.demo.common.module.VO.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ChannelFeginServiceImpl implements ChannelFeginService {

    @Override
    public JsonObject<PageVO<ChannelTechnicanVO>> conditionQueryTechnicans(ChannelTechnicanListQueryByConditionDTO channelTechnicanListQueryByConditionDTO) {
        log.error("fall back");
        return null;
    }

    @Override
    public JsonObject<PageVO<ChannelCompanyVO>> conditionQueryCompanys(ChannelCompanyListQueryByConditionDTO channelCompanyListQueryByConditionDTO) {
        log.error("fall back");
        return null;
    }
}
