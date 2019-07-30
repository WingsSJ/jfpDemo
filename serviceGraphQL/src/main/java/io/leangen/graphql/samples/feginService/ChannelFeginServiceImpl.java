package io.leangen.graphql.samples.feginService;

import com.demo.common.module.DO.ChannelTechnicanExcelModelDO;
import com.demo.common.module.DTO.*;
import io.leangen.graphql.samples.model.ChannelTechnicanVO;
import com.demo.common.module.VO.PageVO;
import com.demo.common.module.VO.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class ChannelFeginServiceImpl implements ChannelFeginService {
    @Override
    public JsonObject importTechnican(ChannelTechnicanAddDTO channelTechnicanAddDTO) {
        log.error("fall back");
        return new JsonObject();
    }

    @Override
    public PageVO<ChannelTechnicanVO> queryAllTechnicans(ChannelTechnicanListQueryDTO channelTechnicanListQueryDTO) {
        log.error("fall back");
        return null;
    }

    @Override
    public ChannelTechnicanVO previewTechnicanInfo(String personId) {
        log.error("fall back");
        return new ChannelTechnicanVO();
    }

    @Override
    public JsonObject reviewOperation(ChannelTechnicanCheckDTO channelTechnicanCheckDTO) {
        log.error("fall back");
        return new JsonObject();
    }

    @Override
    public JsonObject updateTechnicanInfo(ChannelTechnicanUpdateDTO channelTechnicanUpdateDTO) {
        log.error("fall back");
        return new JsonObject();
    }

    @Override
    public JsonObject deleteTechnican(String personId) {
        log.error("fall back");
        return new JsonObject();
    }

    @Override
    public List<ChannelTechnicanExcelModelDO> batchCheckTechnicans(ChannelTechnicanBatchCheckDTO channelTechnicanBatchCheckDTO) {
        log.error("fall back");
        return null;
    }

    @Override
    public JsonObject batchInsertTechnicans(List<ChannelTechnicanExcelModelDO> channelTechnicanExcelModelDOS) {
        log.error("fall back");
        return new JsonObject();
    }
}
