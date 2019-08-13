package com.demo.api.feginService;

import com.demo.common.module.VO.JsonObject;
import com.demo.common.module.VO.PageVO;
import com.demo.common.module.VO.TssFsmCategoryVO;
import com.demo.common.module.VO.TssFsmDocVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 文件管理
 */
@Component
@FeignClient(value = "FileManageService",fallback = ChannelFeginServiceImpl.class,configuration = FeignConfig.class)
public interface FileManageFeginService {
    /**
     * 获取到文件列表 文件信息
     */
    @PostMapping("/fsmdoc/condition/query/info")
    JsonObject<PageVO<TssFsmDocVO>> getFileInfoList(@RequestBody Map map);

    /**
     * 获取到目录列表
     */
    @PostMapping("/fsmdoc/condition/query/category")
    JsonObject<List<TssFsmCategoryVO>> getFileTypeList(@RequestBody Map map);
    /**
     * 获取文件预览地址
     */
    @GetMapping("/fsmdoc/pdfFile")
    JsonObject<String> preViewFile(@RequestParam("docId") String docId);
}
