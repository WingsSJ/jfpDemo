package io.leangen.graphql.samples.service;

import com.alibaba.fastjson.JSON;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLNonNull;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.samples.model.DTO.*;
import io.leangen.graphql.samples.model.VO.ChannelTechnicanVO;
import io.leangen.graphql.samples.model.VO.HttpBaseVO;
import io.leangen.graphql.samples.model.VO.PageVO;
import io.leangen.graphql.samples.repo.ChannelTechnicanRepo;
import io.leangen.graphql.samples.repo.TechnicanCertificateRepo;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.leangen.graphql.samples.model.VO.ChannelTechnicanVO.transToChannelTechnicanVO;
import static io.leangen.graphql.samples.model.VO.ChannelTechnicanVO.transToChannelTechnicanVOList;

/**
 * 渠道技术人员服务
 */
@GraphQLApi
@Service
public class TechnicanService {
    @Autowired
    private ChannelTechnicanRepo channelTechnicanRepo;
    @Autowired
    private TechnicanCertificateRepo technicanCertificateRepo;

    //TODO 1.需要添加插入判断 如果已经存在未删除记录 则无法录入 2.还未做接口测试
    @GraphQLMutation
    public HttpBaseVO createOneChannelTechnicanRecord(@Valid ChannelTechnicanAddDTO channelTechnicanAddDTO){
        //是否存在未处理记录
        boolean haveRecord = channelTechnicanRepo.queryOneChannelTechnicanHaveRecord(channelTechnicanAddDTO);
        if(haveRecord){
            return new HttpBaseVO(HttpStatus.BAD_REQUEST.value(),"this person have record");
        }
        boolean success = channelTechnicanRepo.createOneChannelTechnicanRecord(channelTechnicanAddDTO);
        if(success){
            return new HttpBaseVO(HttpStatus.OK.value(),"add channelTechnican successful");
        }
        return new HttpBaseVO(HttpStatus.BAD_REQUEST.value(),"add channelTechnican fail");
    }

    /****** 查询接口 ******/
    //TODO 渠道技术人员查询 （待审核的人员）还未做接口测试 1
    @GraphQLQuery
    public PageVO<ChannelTechnicanVO> queryCheckPendingTechnicans(@GraphQLNonNull int pageSize, @GraphQLNonNull int pageNum,String companyName,String personName){
        List<ChannelTechnicanVO> channelTechnicanVOList = new ArrayList<>();
        int totalNum = 0;
        List<ChannelTechnicanQueryDTO> channelTechnicanQueryDTOList =  channelTechnicanRepo.queryCheckPendingTechnicans(pageSize, pageNum,companyName,personName);
        if(CollectionUtils.isNotEmpty(channelTechnicanQueryDTOList)){
            //查询出所有的证书信息
            List<String> personIdList = channelTechnicanQueryDTOList.stream().map(ChannelTechnicanQueryDTO::getPersonId).collect(Collectors.toList());
            if(CollectionUtils.isNotEmpty(personIdList)){
                List<TechnicanCertificateQueryDTO> technicanCertificateQueryDTOList = technicanCertificateRepo.findTechnicanCertificateByPersonIdList(personIdList);
                //重新组装为VO
                channelTechnicanVOList = transToChannelTechnicanVOList(channelTechnicanQueryDTOList, technicanCertificateQueryDTOList);
            }
            //查询出所有记录
            totalNum = channelTechnicanRepo.queryCheckPendingTechnicansTotal(companyName,personName);
        }
        return new PageVO(pageNum,pageSize,totalNum,channelTechnicanVOList);
    }

    //TODO 渠道技术人员查询 （通过或者不通过的人员 ） 3
    public PageVO<ChannelTechnicanVO> queryHaveCheckTechnicans(@GraphQLNonNull int pageSize, @GraphQLNonNull int pageNum,String companyName,String personName){
        List<ChannelTechnicanVO> channelTechnicanVOList = new ArrayList<>();
        int totalNum = 0;
        List<ChannelTechnicanQueryDTO> channelTechnicanQueryDTOList =  channelTechnicanRepo.queryHaveCheckTechnicans(pageSize, pageNum,companyName,personName);
        if(CollectionUtils.isNotEmpty(channelTechnicanQueryDTOList)){
            //查询出所有的证书信息
            List<String> personIdList = channelTechnicanQueryDTOList.stream().map(ChannelTechnicanQueryDTO::getPersonId).collect(Collectors.toList());
            if(CollectionUtils.isNotEmpty(personIdList)){
                List<TechnicanCertificateQueryDTO> technicanCertificateQueryDTOList = technicanCertificateRepo.findTechnicanCertificateByPersonIdList(personIdList);
                //重新组装为VO
                channelTechnicanVOList = transToChannelTechnicanVOList(channelTechnicanQueryDTOList, technicanCertificateQueryDTOList);
            }
            //查询出所有记录
            totalNum = channelTechnicanRepo.queryHaveCheckTechnicansTotal(companyName,personName);
        }
        return new PageVO(pageNum,pageSize,totalNum,channelTechnicanVOList);
    }


    //TODO 渠道技术人员管理页面 预览操作 （基本信息和认证信息展示 没有头像 账号 密码）
    @GraphQLQuery
    public ChannelTechnicanVO previewTechnicanInfo(@GraphQLNonNull String personId){
        ChannelTechnicanQueryDTO channelTechnicanQueryDTO = channelTechnicanRepo.previewTechnicanInfo(personId);
        if(channelTechnicanQueryDTO != null) {
            List<TechnicanCertificateQueryDTO> technicanCertificateQueryDTOList = technicanCertificateRepo.findTechnicanCertificateByPersonId(personId);
            //重新组装为VO
            HttpBaseVO httpBaseVO = new HttpBaseVO(HttpStatus.OK.value(),"query success");
            return transToChannelTechnicanVO(channelTechnicanQueryDTO, technicanCertificateQueryDTOList,httpBaseVO);
        }else {
            HttpBaseVO httpBaseVO = new HttpBaseVO(HttpStatus.BAD_REQUEST.value(),"check personId");
            ChannelTechnicanVO channelTechnicanVO = new ChannelTechnicanVO();
            channelTechnicanVO.setHttpBaseVO(httpBaseVO);
            return channelTechnicanVO;
        }
    }


    /****** 修改接口 ******/
    //TODO 待审核渠道技术人员列表页面 审核通过操作（状态改变为审核通过或者未通过） 2 传1代表审核通过 传0代表未通过
    @GraphQLMutation
    public HttpBaseVO reviewOperation(@GraphQLNonNull String personId ,@GraphQLNonNull int review){
        if(1 == review || 0 == review){
            boolean operate = channelTechnicanRepo.reviewOperation(personId,review);
            if(operate){
                return new HttpBaseVO(HttpStatus.OK.value(),"operate success");
            }else {
                return new HttpBaseVO(HttpStatus.BAD_REQUEST.value(),"check param personId:"+personId+" review:"+review);
            }
        }else {
            return new HttpBaseVO(HttpStatus.BAD_REQUEST.value(),"check param review: "+ review);
        }
    }

    //TODO 渠道技术人员管理页面 修改操作 （可以修改人员信息 或者给技术人员添加认证信息 并且该条状态重新进入待审核状态）
    @GraphQLMutation
    public HttpBaseVO updateTechnicanInfo(ChannelTechnicanUpdateDTO channelTechnicanUpdateDTO){
        boolean operate = channelTechnicanRepo.updateTechnicanInfo(channelTechnicanUpdateDTO);
        if(operate){
            return new HttpBaseVO(HttpStatus.OK.value(),"update success");
        }else {
            return new HttpBaseVO(HttpStatus.BAD_REQUEST.value(),"check param: "+ JSON.toJSONString(channelTechnicanUpdateDTO));
        }
    }

    //TODO 测试 （删除人员信息和相关证书信息）
    @GraphQLMutation
    public HttpBaseVO deleteTechnican(String personId){
        boolean operate = channelTechnicanRepo.deleteTechnican(personId);
        if(operate){
            return new HttpBaseVO(HttpStatus.OK.value(),"delete success");
        }else {
            return new HttpBaseVO(HttpStatus.BAD_REQUEST.value(),"check param: "+ personId);
        }
    }


    //TODO 批量导入功能（导入为xls文件 要做数据录入校验） 参考 https://hutool.cn/docs/#/  https://gitee.com/lemur/easypoi
    @GraphQLMutation
    public HttpBaseVO batchImportTechnicans(String fileUrl){
        if(StringUtils.isNotBlank(fileUrl)){

        }
        return null;
    }


    //TODO 下载模板
}
