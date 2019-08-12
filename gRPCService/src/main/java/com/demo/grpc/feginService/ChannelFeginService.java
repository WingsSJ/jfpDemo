package com.demo.grpc.feginService;

import com.demo.common.module.DTO.ChannelTechnicanListQueryByConditionDTO;
import com.demo.common.module.VO.ChannelTechnicanVO;
import com.demo.common.module.VO.ChannelVO;
import com.demo.common.module.VO.JsonObject;
import com.demo.common.module.VO.PageVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 */
@Component
@FeignClient(value = "channelService",fallback = ChannelFeginServiceImpl.class,configuration = FeignConfig.class)
public interface ChannelFeginService {
    @PostMapping("/channel/condition/query/technicans")
    JsonObject<PageVO<ChannelTechnicanVO>> conditionQueryTechnicans(@RequestBody ChannelTechnicanListQueryByConditionDTO channelTechnicanListQueryByConditionDTO);
    @PostMapping("/channel/condition/query/companys")
    JsonObject<PageVO<ChannelVO>> conditionQueryCompanys(@RequestBody ChannelTechnicanListQueryByConditionDTO channelTechnicanListQueryByConditionDTO);
}
