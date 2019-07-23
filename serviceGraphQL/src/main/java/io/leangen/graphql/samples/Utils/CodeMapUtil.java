package io.leangen.graphql.samples.Utils;

import io.leangen.graphql.samples.mapper.CasAreaMapper;
import io.leangen.graphql.samples.model.DTO.CasAreaMapDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class CodeMapUtil  implements ApplicationRunner {
    public static ConcurrentHashMap<String,String> CODE_MAP = new ConcurrentHashMap<>();
    @Resource
    CasAreaMapper casAreaMapper;
    @Override
    public void run(ApplicationArguments args){
        List<CasAreaMapDTO> casAreaMapDTOS = casAreaMapper.queryAll();
        for (CasAreaMapDTO casAreaMapDTO:casAreaMapDTOS){
            CODE_MAP.put(casAreaMapDTO.getAreaName(),casAreaMapDTO.getCode());
        }
        log.info("init success casAreaMap:{} Size: {}",CODE_MAP,CODE_MAP.size());
    }

    public static String getAreaCodeByAreaName(String areaName){
        String areaCode = CODE_MAP.get(areaName);
        if(StringUtils.isBlank(areaCode)){
            return "未能查询到区域";
        }
        return areaCode;
    }
}
