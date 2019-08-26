package com.demo.common.module.DTO;

import com.demo.common.module.DO.ChannelTechnicanExcelModelDTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ChannelTechnicanBatchInsertDTO {
    List<ChannelTechnicanExcelModelDTO> channelTechnicanExcelModelDTOS;
    @NotNull
    String companyName;
    @NotNull
    String companyId;

    public ChannelTechnicanBatchInsertDTO(List<ChannelTechnicanExcelModelDTO> channelTechnicanExcelModelDTOS, @NotNull String companyName, @NotNull String companyId) {
        this.channelTechnicanExcelModelDTOS = channelTechnicanExcelModelDTOS;
        this.companyName = companyName;
        this.companyId = companyId;
    }
}
