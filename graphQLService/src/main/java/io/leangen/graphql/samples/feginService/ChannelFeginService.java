package io.leangen.graphql.samples.feginService;

import com.demo.common.module.DO.ChannelTechnicanExcelModelDO;
import com.demo.common.module.DTO.*;
import com.demo.common.module.VO.ChannelTechnicanVO;
import com.demo.common.module.VO.JsonObject;
import com.demo.common.module.VO.PageVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@FeignClient(value = "channelService",fallback = ChannelFeginServiceImpl.class,configuration = FeignConfig.class)
public interface ChannelFeginService {
    @PostMapping("/channel/import/technican")
    JsonObject importTechnican(@RequestBody ChannelTechnicanAddDTO channelTechnicanAddDTO);
    @PostMapping("/channel/query/all/technicans")
    PageVO<ChannelTechnicanVO> queryAllTechnicans(@RequestBody ChannelTechnicanListQueryDTO channelTechnicanListQueryDTO);
    @RequestMapping("/channel/preview/technican/info/{personId}")
    ChannelTechnicanVO previewTechnicanInfo(@PathVariable(name = "personId") String personId);
    @PostMapping("/channel/review/technican")
    JsonObject reviewOperation(@RequestBody ChannelTechnicanCheckDTO channelTechnicanCheckDTO);
    @PostMapping("/channel/update/technican")
    JsonObject updateTechnicanInfo(@RequestBody ChannelTechnicanUpdateDTO channelTechnicanUpdateDTO);
    @RequestMapping("/channel/delete/technican/{personId}")
    JsonObject deleteTechnican(@PathVariable(name = "personId") String personId);
    @PostMapping("/channel/batch/check")
    List<ChannelTechnicanExcelModelDO> batchCheckTechnicans(@RequestBody ChannelTechnicanBatchCheckDTO channelTechnicanBatchCheckDTO);
    @PostMapping("/channel/batch/insert")
    JsonObject batchInsertTechnicans(@RequestBody ChannelTechnicanBatchInsertDTO channelTechnicanBatchInsertDTO);
}
