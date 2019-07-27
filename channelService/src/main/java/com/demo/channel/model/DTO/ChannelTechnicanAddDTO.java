package com.demo.channel.model.DTO;

import com.alibaba.fastjson.annotation.JSONField;
import com.demo.channel.model.DO.ChannelTechnicanExcelModelDO;
import com.demo.channel.model.DO.TechnicanCertificateExcelModelDO;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 技术人员模型
 */
@Data
public class ChannelTechnicanAddDTO implements Serializable,Cloneable{
    /**
     * 技术人员Id （唯一属性）
     */
    private String personId;
    /**
     * 公司Id
     */
    @NotBlank
    private String companyId;
    /**
     *  公司名
     */
    @NotBlank
    private String companyName;
    /**
     * 技术人员姓名
     */
    @NotBlank
    private String personName;
    /**
     * 人员性别
     */
    @NotNull
    private Integer personGender;
    /**
     * 人员身份证Id (唯一属性)
     */
    @NotBlank
    private String identityCard;
    /**
     * 技术人员生日（yyyy-MM-dd）
     */
    @JSONField(name = "birthday",format = "yyyy-MM-dd")
    @NotNull
    private String birthday;
    /**
     * 联系电话
     */
    @NotBlank
    private String phone;
    /**
     * 人员公司所在省
     */
    @NotBlank
    private String province;
    /**
     * 人员公司所在市
     */
    @NotBlank
    private String city;
    /**
     * 人员公司所在镇
     */
    @NotBlank
    private String county;
    /**
     * 居住地址
     */
    @NotBlank
    private String address;
    /**
     * 人员职务
     */
    @NotBlank
    private String job;
    /**
     * 邮箱地址
     */
    private String email;
    /**
     * 入职日期 (yyyy-MM-dd)
     */
    @JSONField(name = "hireDate",format = "yyyy-MM-dd")
    @NotNull
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
     * 人员相关证书
     */
    private List<TechnicanCertificateAddDTO> technicanCertificateAddDTOS;
    /**
     *审核状态 （0代表为未通过） （1 代表通过）（2代表待审核）
     */
    private Integer reviewStatus;

    public boolean checkNull(){
        return StringUtils.isAnyBlank(this.companyId,this.companyName,this.personName,
                this.personGender.toString(),this.identityCard,this.birthday,this.phone,this.province,this.city,this.county,this.address,this.job,this.hireDate);
    }

    //将ModelDTO转未AddDTO
    public static List<ChannelTechnicanAddDTO> transExcelModelDTOStoAddDTOS(List<ChannelTechnicanExcelModelDO> channelTechnicanExcelModelDOList){
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        List<ChannelTechnicanAddDTO> channelTechnicanAddDTOS = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(channelTechnicanExcelModelDOList)){
            for(ChannelTechnicanExcelModelDO channelTechnicanExcelModelDO:channelTechnicanExcelModelDOList){
                ChannelTechnicanAddDTO channelTechnicanAddDTO = new ChannelTechnicanAddDTO();
                channelTechnicanAddDTO.setCounty(channelTechnicanExcelModelDO.getCounty());
                channelTechnicanAddDTO.setCity(channelTechnicanExcelModelDO.getCity());
                channelTechnicanAddDTO.setProvince(channelTechnicanExcelModelDO.getProvince());
                channelTechnicanAddDTO.setPersonId(channelTechnicanExcelModelDO.getPersonId());
                channelTechnicanAddDTO.setPersonName(channelTechnicanExcelModelDO.getPersonName());
                channelTechnicanAddDTO.setAddress(channelTechnicanExcelModelDO.getAddress());
                //处理异常
                String brithday = format.format(channelTechnicanExcelModelDO.getBirthday());
                channelTechnicanAddDTO.setBirthday(brithday);
                channelTechnicanAddDTO.setCompanyId(channelTechnicanExcelModelDO.getCompanyId());
                channelTechnicanAddDTO.setCompanyName(channelTechnicanExcelModelDO.getCompanyName());
                channelTechnicanAddDTO.setEmail(channelTechnicanExcelModelDO.getEmail());
                //处理异常
                String hireDate = format.format(channelTechnicanExcelModelDO.getHireDate());
                channelTechnicanAddDTO.setHireDate(hireDate);
                channelTechnicanAddDTO.setIdentityCard(channelTechnicanExcelModelDO.getIdentityCard());
                channelTechnicanAddDTO.setJob(channelTechnicanExcelModelDO.getJob());
                //男0 女1
                if("男".equals(channelTechnicanExcelModelDO.getPersonGender().trim())) {
                    channelTechnicanAddDTO.setPersonGender(0);
                }else {
                    channelTechnicanAddDTO.setPersonGender(1);
                }
                channelTechnicanAddDTO.setTelephone(channelTechnicanExcelModelDO.getTelephone());
                channelTechnicanAddDTO.setPhone(channelTechnicanExcelModelDO.getPhone());
                //审核状态 （0代表为未通过） （1 代表通过）（2代表待审核）
                channelTechnicanAddDTO.setReviewStatus(2);
                channelTechnicanAddDTO.setQqNum(channelTechnicanExcelModelDO.getQqNum());
                if(CollectionUtils.isNotEmpty(channelTechnicanExcelModelDO.getTechnicanCertificateExcelModelDOS())){
                    List<TechnicanCertificateExcelModelDO> technicanCertificateExcelModelDOS = channelTechnicanExcelModelDO.getTechnicanCertificateExcelModelDOS();
                    List<TechnicanCertificateAddDTO> technicanCertificateAddDTOList = new ArrayList<>();
                    //转换
                    for(TechnicanCertificateExcelModelDO technicanCertificateExcelModelDO:technicanCertificateExcelModelDOS){
                        TechnicanCertificateAddDTO technicanCertificateAddDTO = new TechnicanCertificateAddDTO();
                        technicanCertificateAddDTO.setPersonId(technicanCertificateExcelModelDO.getPersonId());
                        technicanCertificateAddDTO.setCertificateDirection(technicanCertificateExcelModelDO.getCertificateDirection());
                        technicanCertificateAddDTO.setCertificateId(technicanCertificateExcelModelDO.getCertificateId());
                        technicanCertificateAddDTO.setCertificateLevel(technicanCertificateExcelModelDO.getCertificateLevel());
                        String invalidCertificateTime = format.format(technicanCertificateExcelModelDO.getInvalidCertificateTime());
                        technicanCertificateAddDTO.setInvalidCertificateTime(invalidCertificateTime);
                        technicanCertificateAddDTOList.add(technicanCertificateAddDTO);
                    }
                    channelTechnicanAddDTO.setTechnicanCertificateAddDTOS(technicanCertificateAddDTOList);
                }
                channelTechnicanAddDTOS.add(channelTechnicanAddDTO);
            }
        }
        return channelTechnicanAddDTOS;
    }
}
