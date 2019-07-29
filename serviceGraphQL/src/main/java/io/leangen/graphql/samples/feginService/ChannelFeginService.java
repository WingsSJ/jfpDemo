package io.leangen.graphql.samples.feginService;

import com.demo.common.module.DO.ChannelTechnicanExcelModelDO;
import com.demo.common.module.DTO.*;
import io.leangen.graphql.samples.model.ChannelTechnicanVO;
import com.demo.common.module.VO.PageVO;
import io.leangen.graphql.samples.utils.JsonObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(value = "channelService",fallback = ChannelFeginServiceImpl.class,configuration = FeignConfig.class)
public interface ChannelFeginService {
    @PostMapping("/channel/import/technican")
    JsonObject importTechnican(@RequestBody ChannelTechnicanAddDTO channelTechnicanAddDTO);
    @PostMapping("/channel/query/check/pending/technicans")
    PageVO<ChannelTechnicanVO> queryCheckPendingTechnicans(@RequestBody ChannelTechnicanListQueryDTO channelTechnicanListQueryDTO);
    @PostMapping("/channel/query/have/check/technicans")
    PageVO<ChannelTechnicanVO> queryHaveCheckTechnicans(@RequestBody ChannelTechnicanListQueryDTO channelTechnicanListQueryDTO);
    @RequestMapping("/channel/preview/technican/info")
    ChannelTechnicanVO previewTechnicanInfo(@RequestParam(name = "personId") String personId);
    @PostMapping("/channel/review/technican")
    JsonObject reviewOperation(@RequestBody ChannelTechnicanCheckDTO channelTechnicanCheckDTO);
    @PostMapping("/channel/update/technican")
    JsonObject updateTechnicanInfo(@RequestBody ChannelTechnicanUpdateDTO channelTechnicanUpdateDTO);
    @RequestMapping("/channel/delete/technican")
    JsonObject deleteTechnican(@RequestParam("personId") String personId);
    @PostMapping("/channel/batch/check")
    PageVO<ChannelTechnicanExcelModelDO> batchCheckTechnicans(@RequestBody ChannelTechnicanBatchCheckDTO channelTechnicanBatchCheckDTO);
    @PostMapping("/channel/batch/insert")
    JsonObject batchInsertTechnicans(@RequestBody List<ChannelTechnicanExcelModelDO> channelTechnicanExcelModelDOS);
}
