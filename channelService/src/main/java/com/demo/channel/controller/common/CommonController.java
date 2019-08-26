package com.demo.channel.controller.common;

import com.demo.channel.util.CodeMapUtil;
import com.demo.common.module.DTO.QueryPlatFormDTO;
import com.demo.common.module.VO.JsonObject;
import com.demo.common.module.VO.PlatformVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {
    /**
     * @author Wings
     * @apiNote 通用方法 根据code查询省市区信息
     */
    @PostMapping("/query/platform/info")
    public JsonObject<PlatformVO> queryPlatformInfoById(@RequestBody QueryPlatFormDTO queryPlatFormDTO) {
        List<PlatformVO> platformVOList = CodeMapUtil.getPlatformVOList(queryPlatFormDTO.getCode());
        return new JsonObject(0,"query success",platformVOList);
    }
    /**
     * @author Wings
     * @apiNote 通用方法 省市区三名字查询出对应地区的code
     */
    @PostMapping("/query/platform/code")
    public JsonObject<Map> queryPlatformCodeByName(@RequestBody QueryPlatFormDTO queryPlatFormDTO) {
        if(StringUtils.isAnyBlank(queryPlatFormDTO.getCityName(),queryPlatFormDTO.getProvinceName(),queryPlatFormDTO.getCountyName())){
            return new JsonObject(1,"please check param provinceName  cityName countyName");
        }
        Map result = CodeMapUtil.getAreaCodeByAreaName(queryPlatFormDTO.getProvinceName(),
                queryPlatFormDTO.getCityName(),queryPlatFormDTO.getCountyName());
        return new JsonObject(0,"query success",result);
    }
    /**
     * @author Wings
     * @apiNote 通用方法 根据code值查询对应平台名字
     */
    @PostMapping("/query/platform/name")
    public JsonObject<String> queryPlatformNameByCode(@RequestBody QueryPlatFormDTO queryPlatFormDTO) {
        String areaName = CodeMapUtil.getAreaNameByAreaCode(queryPlatFormDTO.getPid());
        return new JsonObject(0,"query success",areaName);
    }
}
