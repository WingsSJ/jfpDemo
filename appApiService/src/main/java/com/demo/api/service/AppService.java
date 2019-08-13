package com.demo.api.service;

import com.demo.api.feginService.ChannelFeginService;
import com.demo.api.feginService.FileManageFeginService;
import com.demo.common.module.DTO.ChannelCompanyListQueryByConditionDTO;
import com.demo.common.module.DTO.ChannelTechnicanListQueryByConditionDTO;
import com.demo.common.module.DTO.FileInfoQueryDTO;
import com.demo.common.module.DTO.FileTypeListQueryDTO;
import com.demo.common.module.VO.*;
import com.demo.common.module.VO.app.ChannelTechnicanAppVO;
import com.demo.common.module.VO.app.FileAppVO;
import com.demo.common.module.VO.app.FileInfoTypeAppVO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppService {
    private final ChannelFeginService channelFeginService;
    private final FileManageFeginService fileManageFeginService;
    @Autowired
    AppService(ChannelFeginService channelFeginService,FileManageFeginService fileManageFeginService){
        this.channelFeginService = channelFeginService;
        this.fileManageFeginService = fileManageFeginService;
    }

    /**
     * 条件查询所有技术人员
     */
    public JsonObject<PageVO<ChannelTechnicanAppVO>> queryChannelTechnicanInfoList(ChannelTechnicanListQueryByConditionDTO channelTechnicanListQueryByConditionDTO){
        JsonObject<PageVO<ChannelTechnicanVO>> pageVOJsonObject = channelFeginService.conditionQueryTechnicans(channelTechnicanListQueryByConditionDTO);
        //VO转APP VO
        List<ChannelTechnicanVO> channelTechnicanVOList = pageVOJsonObject.getObjEntity().getList();
        List<ChannelTechnicanAppVO> channelTechnicanAppVOS = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(channelTechnicanVOList)){
            for(ChannelTechnicanVO channelTechnicanVO:channelTechnicanVOList){
                ChannelTechnicanAppVO channelTechnicanAppVO = ChannelTechnicanAppVO.transVO(channelTechnicanVO);
                channelTechnicanAppVOS.add(channelTechnicanAppVO);
            }
        }
        PageVO<ChannelTechnicanAppVO> pageVO = new PageVO(pageVOJsonObject.getObjEntity().getCurrPage(),
                pageVOJsonObject.getObjEntity().getPageSize(),
                pageVOJsonObject.getObjEntity().getTotalCount(),
                channelTechnicanAppVOS);
        return new JsonObject(0,"query success",pageVO);
    }

    /**
     * //TODO 条件查询所有渠道技术商 测试
     */
    public JsonObject<PageVO<ChannelCompanyVO>> queryChannelCompanyInfoList(ChannelCompanyListQueryByConditionDTO channelCompanyListQueryByConditionDTO){
        JsonObject<PageVO<ChannelCompanyVO>> pageVOJsonObject = channelFeginService.conditionQueryCompanys(channelCompanyListQueryByConditionDTO);
        return pageVOJsonObject;
    }

    /**
     * 资料查询接口
     */
    public JsonObject<PageVO<FileAppVO>> getFileInfoList(FileInfoQueryDTO fileInfoQueryDTO){
        Map param = new HashMap(4);
        param.put("currPage",fileInfoQueryDTO.getCurrPage());
        param.put("pageSize",fileInfoQueryDTO.getPageSize());
        param.put("searchCondition",fileInfoQueryDTO.getSearchCondition());
        param.put("times",fileInfoQueryDTO.getTimes());
        JsonObject<PageVO<TssFsmDocVO>> fileInfoList = fileManageFeginService.getFileInfoList(param);
        //TODO 将文件和目录列表转为需要的数据
        return null;
    }

    /**
     *  文件+目录接口
     */
    public JsonObject<FileInfoTypeAppVO> getFileInfoAndCategoryList(FileTypeListQueryDTO fileTypeListQueryDTO){
        Map param = new HashMap(2);
        param.put("typeId",fileTypeListQueryDTO.getTypeId());
        param.put("currPage",fileTypeListQueryDTO.getCurrPage());
        param.put("pageSize",fileTypeListQueryDTO.getPageSize());
        JsonObject<List<TssFsmCategoryVO>> categoryInfoList = fileManageFeginService.getFileTypeList(param);
        JsonObject<List<TssFsmCategoryVO>> fileTypeList = fileManageFeginService.getFileTypeList(param);
        //TODO 拼接 将文件和目录列表转为需要的数据 测试
        return null;
    }

    /**
     * 文件预览
     */
    public JsonObject<String> preViewFile(String docId){
        //TODO 测试
        JsonObject<String> stringJsonObject = fileManageFeginService.preViewFile(docId);
        return stringJsonObject;
    }
}
