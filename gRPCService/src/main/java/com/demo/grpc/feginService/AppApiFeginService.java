package com.demo.grpc.feginService;

import com.demo.common.module.DTO.ChannelCompanyListQueryByConditionDTO;
import com.demo.common.module.DTO.ChannelTechnicanListQueryByConditionDTO;
import com.demo.common.module.DTO.FileInfoQueryDTO;
import com.demo.common.module.DTO.FileTypeListQueryDTO;
import com.demo.common.module.VO.JsonObject;
import com.demo.common.module.VO.PageVO;
import com.demo.common.module.VO.app.ChannelCompanyAppVO;
import com.demo.common.module.VO.app.ChannelTechnicanAppVO;
import com.demo.common.module.VO.app.FileAppVO;
import com.demo.common.module.VO.app.FileInfoTypeAppVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 *
 */
@Component
@FeignClient(value = "appApiService",fallback = AppApiFeginServiceImpl.class,configuration = FeignConfig.class)
public interface AppApiFeginService {
    /**
     * @author Wings
     * @apiNote 根据条件查询出所有渠道服务商的信息
     */
    @PostMapping("/query/channel/company/info/list")
    JsonObject<PageVO<ChannelCompanyAppVO>> queryChannelCompanyInfoList(@RequestBody @Valid ChannelCompanyListQueryByConditionDTO channelCompanyListQueryByConditionDTO);


    /**
     * @author Wings
     * @apiNote 根据条件查询出所有技术人员的信息
     */
    @PostMapping("/query/channel/technican/info/list")
    JsonObject<PageVO<ChannelTechnicanAppVO>> queryChannelTechnicanInfoList(@RequestBody @Valid ChannelTechnicanListQueryByConditionDTO channelTechnicanListQueryByConditionDTO);


    /**
     * @author Wings
     * @apiNote 根据条件查询出所有 文件+目录 列表 信息
     */
    @PostMapping("/query/file/info/list")
    JsonObject<FileInfoTypeAppVO> queryFileInfoList(@RequestBody @Valid FileTypeListQueryDTO fileInfoQueryDTO);

    /**
     * @author Wings
     * @apiNote 根据条件查询出所有文件列表
     */
    @PostMapping("/query/category/info/list")
    JsonObject<PageVO<FileAppVO>> queryCategoryInfoList(@RequestBody @Valid FileInfoQueryDTO fileInfoQueryDTO);

    /**
     * @author Wings
     * @apiNote 文件资料预览地址
     */
    @PostMapping("/file/pre/view")
    JsonObject<String> filePreView(@RequestParam("fid")@NotNull String fid);
}
