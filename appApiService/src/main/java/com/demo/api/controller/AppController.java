package com.demo.api.controller;

import com.demo.api.service.AppService;
import com.demo.common.module.DTO.ChannelCompanyListQueryByConditionDTO;
import com.demo.common.module.DTO.ChannelTechnicanListQueryByConditionDTO;
import com.demo.common.module.DTO.FileInfoQueryDTO;
import com.demo.common.module.DTO.FileTypeListQueryDTO;
import com.demo.common.module.VO.ChannelCompanyVO;
import com.demo.common.module.VO.JsonObject;
import com.demo.common.module.VO.PageVO;
import com.demo.common.module.VO.app.ChannelCompanyAppVO;
import com.demo.common.module.VO.app.ChannelTechnicanAppVO;
import com.demo.common.module.VO.app.FileAppVO;
import com.demo.common.module.VO.app.FileInfoTypeAppVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 渠道相关接口
 */
@RestController
@RequestMapping("/app")
@Slf4j
public class AppController {
    private final AppService appService;
    @Autowired
    AppController(AppService appService) {
        this.appService = appService;
    }
    /**
     * @author Wings
     * @apiNote 根据条件查询出所有渠道服务商的信息
     */
    @PostMapping("/query/channel/company/info/list")
    public JsonObject<PageVO<ChannelCompanyAppVO>> queryChannelCompanyInfoList(@RequestBody @Valid ChannelCompanyListQueryByConditionDTO channelCompanyListQueryByConditionDTO) {
        JsonObject<PageVO<ChannelCompanyVO>> pageVOJsonObject = appService.queryChannelCompanyInfoList(channelCompanyListQueryByConditionDTO);
        //TODO 将VO转APPVO
        return new JsonObject(0,"query success",pageVOJsonObject);
    }

    /**
     * @author Wings
     * @apiNote 根据条件查询出所有技术人员的信息
     */
    @PostMapping("/query/channel/technican/info/list")
    public JsonObject<PageVO<ChannelTechnicanAppVO>> queryChannelTechnicanInfoList(@RequestBody @Valid ChannelTechnicanListQueryByConditionDTO channelTechnicanListQueryByConditionDTO) {
        JsonObject<PageVO<ChannelTechnicanAppVO>> channelTechnicanInfoList = appService.queryChannelTechnicanInfoList(channelTechnicanListQueryByConditionDTO);
        return new JsonObject(0,"query success",channelTechnicanInfoList);
    }

    /**
     * @author Wings
     * @apiNote 根据条件查询出所有 文件+目录 列表 信息
     */
    @PostMapping("/query/file/info/list")
    public JsonObject<FileInfoTypeAppVO> queryFileInfoList(@RequestBody @Valid FileTypeListQueryDTO fileInfoQueryDTO) {
        JsonObject<FileInfoTypeAppVO> pageVOJsonObject = appService.getFileInfoAndCategoryList(fileInfoQueryDTO);
        return new JsonObject(0,"query success",pageVOJsonObject);
    }

    /**
     * @author Wings
     * @apiNote 根据条件查询出所有文件列表
     */
    @PostMapping("/query/category/info/list")
    public JsonObject<PageVO<FileAppVO>> queryCategoryInfoList(@RequestBody @Valid FileInfoQueryDTO fileInfoQueryDTO) {
        JsonObject<PageVO<FileAppVO>> categoryInfoList = appService.getFileInfoList(fileInfoQueryDTO);
        return new JsonObject(0,"query success",categoryInfoList);
    }

    /**
     * @author Wings
     * @apiNote 文件资料预览地址
     */
    @PostMapping("/file/pre/view")
    public JsonObject<String> filePreView(@RequestParam("fid")@NotNull String fid) {
        JsonObject<String> stringJsonObject = appService.preViewFile(fid);
        return new JsonObject(0,"query success",stringJsonObject);
    }
}
