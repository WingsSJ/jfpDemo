package com.demo.common.module.DTO;

import com.demo.common.module.DO.ChannelTechnicanExcelModelDO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ChannelTechnicanBatchInsertDTO {
    List<ChannelTechnicanExcelModelDO> channelTechnicanExcelModelDOS;
    @NotNull
    String companyName;
    @NotNull
    String companyId;

    public ChannelTechnicanBatchInsertDTO(List<ChannelTechnicanExcelModelDO> channelTechnicanExcelModelDOS, @NotNull String companyName, @NotNull String companyId) {
        this.channelTechnicanExcelModelDOS = channelTechnicanExcelModelDOS;
        this.companyName = companyName;
        this.companyId = companyId;
    }
}
