package com.demo.api.feginService;



import com.demo.api.model.VO.ChannelTechnicanVO;
import com.demo.common.module.DTO.ChannelTechnicanListQueryByConditionDTO;

import com.demo.common.module.VO.ChannelVO;
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
    public JsonObject<PageVO<ChannelVO>> conditionQueryCompanys(ChannelTechnicanListQueryByConditionDTO channelTechnicanListQueryByConditionDTO) {
        log.error("fall back");
        return null;
    }
}
