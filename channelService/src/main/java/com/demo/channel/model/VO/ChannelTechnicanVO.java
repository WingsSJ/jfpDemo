package com.demo.channel.model.VO;

import com.demo.channel.utils.CodeMapUtil;
import com.demo.common.module.DTO.ChannelTechnicanQueryDTO;
import com.demo.common.module.DTO.TechnicanCertificateQueryDTO;
import com.demo.common.module.VO.TechnicanCertificateVO;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 技术人员
 */
@Data
public class ChannelTechnicanVO{
    /**
     * 技术人员Id （唯一属性）
     */
    private String personId;
    /**
     * 公司Id
     */
    private String companyId;
    /**
     *
     */
    private String companyName;
    /**
     * 技术人员姓名
     */
    private String personName;
    /**
     * 人员性别
     */
    private String personGender;
    /**
     * 人员身份证Id
     */
    private String identityCard;
    /**
     * 技术人员生日（yyyy-MM-dd）
     */
    private String birthday;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 镇
     */
    private String county;
    /**
     * 居住地址
     */
    private String address;
    /**
     * 人员职务
     */
    private String job;
    /**
     * 邮箱地址
     */
    private String email;
    /**
     * 入职日期 (yyyy-MM-dd)
     */
    private String hireDate;
    /**
     * qq号
     */
    private String qqNum;
    /**
     * 座机电话（固话）
     */
    private String telephone;
    /**
     *审核状态 （0代表为未通过） （1 代表通过）（2代表待审核）
     */
    private String reviewStatus;
    /**
     * 审核未通过的原因
     */
    private String notPassCause;
    /**
     * 渠道技术人员证书信息
     */
    private List<TechnicanCertificateVO> technicanCertificateVOList;

    private Integer result = 0;

    private String message = "query success";


    public static ChannelTechnicanVO transToChannelTechnicanVO(ChannelTechnicanQueryDTO channelTechnicanQueryDTO, List<TechnicanCertificateQueryDTO> technicanCertificateQueryDTOList){
        ChannelTechnicanVO channelTechnicanVO = transDTOToVO(channelTechnicanQueryDTO);
        List<TechnicanCertificateVO> technicanCertificateVOList = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(technicanCertificateQueryDTOList)) {
            for (TechnicanCertificateQueryDTO technicanCertificateQueryDTO : technicanCertificateQueryDTOList) {
                TechnicanCertificateVO technicanCertificateVO = new TechnicanCertificateVO(technicanCertificateQueryDTO.getCertificateId(),
                        technicanCertificateQueryDTO.getCertificateDirection(),
                        technicanCertificateQueryDTO.getCertificateLevel(),
                        technicanCertificateQueryDTO.getInvalidCertificateTime());
                technicanCertificateVOList.add(technicanCertificateVO);
            }
            channelTechnicanVO.setTechnicanCertificateVOList(technicanCertificateVOList);
        }
        return channelTechnicanVO;
    }


    public static List<ChannelTechnicanVO> transToChannelTechnicanVOList( List<ChannelTechnicanQueryDTO> channelTechnicanQueryDTOList,
                                                                          List<TechnicanCertificateQueryDTO> technicanCertificateQueryDTOList){

        Map<String,List<TechnicanCertificateVO>> result = new HashMap<>();
        List<ChannelTechnicanVO> channelTechnicanVOList = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(technicanCertificateQueryDTOList)){
            //将证书信息整理为 Map<personId,List<TechnicanCertificateVO>>
            technicanCertificateQueryDTOList.stream().collect(Collectors.groupingBy(TechnicanCertificateQueryDTO::getPersonId)).forEach((personId, technicanCertificateDTOS) -> {
                List<TechnicanCertificateVO> technicanCertificateVOList = new ArrayList<>();
                for(TechnicanCertificateQueryDTO technicanCertificateQueryDTO :technicanCertificateDTOS){
                    TechnicanCertificateVO technicanCertificateVO = new TechnicanCertificateVO(technicanCertificateQueryDTO.getCertificateId(),
                            technicanCertificateQueryDTO.getCertificateDirection(),
                            technicanCertificateQueryDTO.getCertificateLevel(),
                            technicanCertificateQueryDTO.getInvalidCertificateTime());
                    technicanCertificateVOList.add(technicanCertificateVO);
                }
                result.put(personId,technicanCertificateVOList);
            });
        }
        //重新构造 ChannelTechnicanVO
        for(ChannelTechnicanQueryDTO channelTechnicanQueryDTO:channelTechnicanQueryDTOList){
            ChannelTechnicanVO channelTechnicanVO = transDTOToVO(channelTechnicanQueryDTO);
            //如果有证书信息
            if(result.containsKey(channelTechnicanQueryDTO.getPersonId())){
                channelTechnicanVO.setTechnicanCertificateVOList(result.get(channelTechnicanQueryDTO.getPersonId()));
            }
            channelTechnicanVOList.add(channelTechnicanVO);
        }
        return channelTechnicanVOList;
    }

    private static ChannelTechnicanVO transDTOToVO(ChannelTechnicanQueryDTO channelTechnicanQueryDTO){
        ChannelTechnicanVO channelTechnicanVO = new ChannelTechnicanVO();
        channelTechnicanVO.setPersonId(channelTechnicanQueryDTO.getPersonId());
        channelTechnicanVO.setAddress(channelTechnicanQueryDTO.getAddress());
        channelTechnicanVO.setBirthday(channelTechnicanQueryDTO.getBirthday());
        channelTechnicanVO.setCompanyId(channelTechnicanQueryDTO.getCompanyId());
        channelTechnicanVO.setCompanyName(channelTechnicanQueryDTO.getCompanyName());
        channelTechnicanVO.setEmail(channelTechnicanQueryDTO.getEmail());
        channelTechnicanVO.setHireDate(channelTechnicanQueryDTO.getHireDate());
        channelTechnicanVO.setIdentityCard(channelTechnicanQueryDTO.getIdentityCard());
        channelTechnicanVO.setJob(channelTechnicanQueryDTO.getJob());
        channelTechnicanVO.setNotPassCause(channelTechnicanQueryDTO.getNotPassCause());
        channelTechnicanVO.setPersonGender(Integer.valueOf(0).equals(channelTechnicanQueryDTO.getPersonGender())? "男":"女");
        channelTechnicanVO.setPersonName(channelTechnicanQueryDTO.getPersonName());
        channelTechnicanVO.setPhone(channelTechnicanQueryDTO.getPhone());
        channelTechnicanVO.setQqNum(channelTechnicanQueryDTO.getQqNum());
        //code 转化为实际的名字
        channelTechnicanVO.setCounty(CodeMapUtil.getAreaNameByAreaCode(channelTechnicanQueryDTO.getCounty()));
        channelTechnicanVO.setCity(CodeMapUtil.getAreaNameByAreaCode(channelTechnicanQueryDTO.getCity()));
        channelTechnicanVO.setProvince(CodeMapUtil.getAreaNameByAreaCode(channelTechnicanQueryDTO.getProvince()));
        //转成实际需要显示值
        if(Integer.valueOf(2).equals(channelTechnicanQueryDTO.getReviewStatus())){
            channelTechnicanVO.setReviewStatus("审核未通过");
        }else if (Integer.valueOf(1).equals(channelTechnicanQueryDTO.getReviewStatus())){
            channelTechnicanVO.setReviewStatus("通过");
        }else {
            channelTechnicanVO.setReviewStatus("待审核");
        }
        channelTechnicanVO.setTelephone(channelTechnicanQueryDTO.getTelephone());
        return channelTechnicanVO;
    }
}
