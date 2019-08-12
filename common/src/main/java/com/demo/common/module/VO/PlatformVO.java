package com.demo.common.module.VO;

import com.demo.common.module.DTO.CasAreaMapDTO;
import lombok.Data;

@Data
public class PlatformVO {
    /**
     * 省级id
     */
    String id;
    /**
     * 父id
     */
    String pid;
    /**
     * 对应平台码
     */
    String code;
    /**
     * 对应平台名称
     */
    String name;

    PlatformVO(){

    }

    public PlatformVO(CasAreaMapDTO casAreaMapDTO){
        pid = casAreaMapDTO.getPid();
        code = casAreaMapDTO.getCode();
        name = casAreaMapDTO.getAreaName();
        id = casAreaMapDTO.getUuid();
    }
}
