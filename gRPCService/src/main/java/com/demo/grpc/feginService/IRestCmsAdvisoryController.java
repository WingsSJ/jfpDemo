package com.demo.grpc.feginService;

import com.topsec.util.JsonObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 安全资讯接口
 *
 * @author 谢昀育
 * @create 2017-02-21 11:42
 */
//@FeignClient(name = "getwayserver", url = "http://getwayserver:8765",path = "cmsdata")
@FeignClient(name = "${feign.cms.name}", url = "${feign.cms.url}",path = "${feign.cms.path}")
public interface IRestCmsAdvisoryController {
    @RequestMapping(value="/restCms/restSaveCmsAdvisory",method = RequestMethod.POST)
    @ResponseBody
    String  restSaveCmsAdvisory(@RequestParam("advisoryJsonData") String advisoryJsonData) ;

    @RequestMapping(value="/restCms/restDeleteCmsAdvisory",method = RequestMethod.POST)
    @ResponseBody
    String restDeleteCmsAdvisory(@RequestParam("advisoryJsonData") String advisoryJsonData);

    @RequestMapping(value = "/restCms/restQueryCmsAdvisory",method = RequestMethod.POST)
    @ResponseBody
    String restQueryCmsAdvisory(@RequestParam("typepathStr") String typepathStr,
                                @RequestParam(value = "pageNo", required = false) Integer pageNo,
                                @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                @RequestParam(value = "version", required = false) Integer version,
                                @RequestParam(value = "versType", required = false) Integer versType);
    @RequestMapping(value="/restCms/restQueryCmsStringAdvisoryByUrl",method = RequestMethod.POST)
    @ResponseBody
    JsonObject restQueryCmsStringAdvisoryByUrl(@RequestParam("filePath") String filePath) ;

    @RequestMapping(value="/restCms/restQueryCmsByteAdvisoryByUrl",method = RequestMethod.POST)
    @ResponseBody
    byte[] restQueryCmsByteAdvisoryByUrl(@RequestParam("filePath") String filePath) ;
}
