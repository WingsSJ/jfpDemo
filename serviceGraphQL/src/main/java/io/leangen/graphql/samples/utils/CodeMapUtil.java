package io.leangen.graphql.samples.utils;

import io.leangen.graphql.samples.mapper.CasAreaMapper;
import io.leangen.graphql.samples.model.DTO.CasAreaMapDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class CodeMapUtil  implements ApplicationRunner {
    private static ConcurrentHashMap<String,Object> CODE_MAP = new ConcurrentHashMap<>();
    @Resource
    CasAreaMapper casAreaMapper;
    @Override
    public void run(ApplicationArguments args){
        List<CasAreaMapDTO> casAreaMapDTOS = casAreaMapper.queryAll();
        for (CasAreaMapDTO casAreaMapDTO:casAreaMapDTOS){
            CODE_MAP.put(casAreaMapDTO.getCode(),casAreaMapDTO);
        }
        log.info("casAreaMap init success size: {}",CODE_MAP.size());
    }

    public static Map<String,String> getAreaCodeByAreaName(String provinceName, String cityName, String countyName){
        Map<String,String> map = new HashMap<>();
        String provinceId = "";
        String cityId = "";
        /**
         * 获取省级信息
         */
        for(String code:CODE_MAP.keySet()){
            if(CODE_MAP.get(code) != null){
                CasAreaMapDTO casAreaMapDTO = (CasAreaMapDTO)CODE_MAP.get(code);
                if(casAreaMapDTO.getAreaName().equals(provinceName) && StringUtils.isBlank(casAreaMapDTO.getPid())){
                    map.put("province",code);
                    provinceId = casAreaMapDTO.getUuid();
                }
            }
        }
        /**
         * 获取市级信息
         */
        for(String code:CODE_MAP.keySet()){
            if(CODE_MAP.get(code) != null){
                CasAreaMapDTO casAreaMapDTO = (CasAreaMapDTO)CODE_MAP.get(code);
                if(StringUtils.isNotBlank(provinceId) && casAreaMapDTO.getAreaName().equals(cityName) && casAreaMapDTO.getPid().equals(provinceId)){
                    map.put("city",code);
                    cityId = casAreaMapDTO.getUuid();
                }
            }
        }
        /**
         * 获取区县信息
         */
        for(String code:CODE_MAP.keySet()){
            if(CODE_MAP.get(code) != null){
                CasAreaMapDTO casAreaMapDTO = (CasAreaMapDTO)CODE_MAP.get(code);
                if(StringUtils.isNotBlank(cityId) && casAreaMapDTO.getAreaName().equals(countyName) && casAreaMapDTO.getPid().equals(cityId)){
                    map.put("county",code);
                }
            }
        }
        return map;
    }

    public static String getAreaNameByAreaCode(String areaCode){
        if(CODE_MAP.get(areaCode)!= null){
            CasAreaMapDTO casAreaMapDTO = (CasAreaMapDTO)CODE_MAP.get(areaCode);
            return casAreaMapDTO.getAreaName();
        }else {
            return "not exist areaCode:"+areaCode;
        }
    }
}
