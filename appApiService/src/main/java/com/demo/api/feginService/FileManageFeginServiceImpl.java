package com.demo.api.feginService;

import com.demo.common.module.VO.JsonObject;
import com.demo.common.module.VO.PageVO;
import com.demo.common.module.VO.TssFsmCategoryVO;
import com.demo.common.module.VO.TssFsmDocVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class FileManageFeginServiceImpl implements FileManageFeginService {

    @Override
    public JsonObject<PageVO<TssFsmDocVO>> getFileInfoList(Map map) {
        log.error("fall back");
        return null;
    }

    @Override
    public JsonObject<List<TssFsmCategoryVO>> getFileTypeList(Map map) {
        log.error("fall back");
        return null;
    }

    @Override
    public JsonObject<String> preViewFile(String docId) {
        log.error("fall back");
        return null;
    }
}
