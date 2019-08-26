package com.demo.common.module.DTO;

import com.alibaba.fastjson.annotation.JSONField;
import com.demo.common.module.DO.ChannelTechnicanExcelModelDTO;
import com.demo.common.module.DO.TechnicanCertificateExcelModelDTO;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
    public static List<ChannelTechnicanAddDTO> transExcelModelDTOStoAddDTOS(List<ChannelTechnicanExcelModelDTO> channelTechnicanExcelModelDTOList){

        List<ChannelTechnicanAddDTO> channelTechnicanAddDTOS = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(channelTechnicanExcelModelDTOList)){
            for(ChannelTechnicanExcelModelDTO channelTechnicanExcelModelDTO : channelTechnicanExcelModelDTOList){
                ChannelTechnicanAddDTO channelTechnicanAddDTO = new ChannelTechnicanAddDTO();
                channelTechnicanAddDTO.setCounty(channelTechnicanExcelModelDTO.getCounty());
                channelTechnicanAddDTO.setCity(channelTechnicanExcelModelDTO.getCity());
                channelTechnicanAddDTO.setProvince(channelTechnicanExcelModelDTO.getProvince());
                channelTechnicanAddDTO.setPersonId(channelTechnicanExcelModelDTO.getPersonId());
                channelTechnicanAddDTO.setPersonName(channelTechnicanExcelModelDTO.getPersonName());
                channelTechnicanAddDTO.setAddress(channelTechnicanExcelModelDTO.getAddress());
                //处理异常 字符串时间戳转化为yyyy/MM/dd
                try {
                    //考虑到SimpleDateFormat线程安全的问题 后面改为工具类
                    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US);
                    Date birthday = sdf.parse(channelTechnicanExcelModelDTO.getBirthday());
                    sdf=new SimpleDateFormat("yyyy/MM/dd");
                    channelTechnicanAddDTO.setBirthday(sdf.format(birthday));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                channelTechnicanAddDTO.setCompanyId(channelTechnicanExcelModelDTO.getCompanyId());
                channelTechnicanAddDTO.setCompanyName(channelTechnicanExcelModelDTO.getCompanyName());
                channelTechnicanAddDTO.setEmail(channelTechnicanExcelModelDTO.getEmail());
                //处理异常
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US);
                    Date hireday = sdf.parse(channelTechnicanExcelModelDTO.getBirthday());
                    sdf=new SimpleDateFormat("yyyy/MM/dd");
                    channelTechnicanAddDTO.setHireDate(sdf.format(hireday));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                channelTechnicanAddDTO.setIdentityCard(channelTechnicanExcelModelDTO.getIdentityCard());
                channelTechnicanAddDTO.setJob(channelTechnicanExcelModelDTO.getJob());
                //男0 女1
                if("男".equals(channelTechnicanExcelModelDTO.getPersonGender().trim())) {
                    channelTechnicanAddDTO.setPersonGender(0);
                }else {
                    channelTechnicanAddDTO.setPersonGender(1);
                }
                channelTechnicanAddDTO.setTelephone(channelTechnicanExcelModelDTO.getTelephone());
                channelTechnicanAddDTO.setPhone(channelTechnicanExcelModelDTO.getPhone());
                //审核状态 （0代表为未通过） （1 代表通过）（2代表待审核）
                channelTechnicanAddDTO.setReviewStatus(2);
                channelTechnicanAddDTO.setQqNum(channelTechnicanExcelModelDTO.getQqNum());
                if(CollectionUtils.isNotEmpty(channelTechnicanExcelModelDTO.getTechnicanCertificateExcelModelDTOS())){
                    List<TechnicanCertificateExcelModelDTO> technicanCertificateExcelModelDTOS = channelTechnicanExcelModelDTO.getTechnicanCertificateExcelModelDTOS();
                    List<TechnicanCertificateAddDTO> technicanCertificateAddDTOList = new ArrayList<>();
                    //转换
                    for(TechnicanCertificateExcelModelDTO technicanCertificateExcelModelDTO : technicanCertificateExcelModelDTOS){
                        TechnicanCertificateAddDTO technicanCertificateAddDTO = new TechnicanCertificateAddDTO();
                        technicanCertificateAddDTO.setPersonId(technicanCertificateExcelModelDTO.getPersonId());
                        technicanCertificateAddDTO.setCertificateDirection(technicanCertificateExcelModelDTO.getCertificateDirection());
                        technicanCertificateAddDTO.setCertificateId(technicanCertificateExcelModelDTO.getCertificateId());
                        technicanCertificateAddDTO.setCertificateLevel(technicanCertificateExcelModelDTO.getCertificateLevel());
                        //处理时间戳
                        try {
                            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US);
                            Date invalidCertificateDate = sdf.parse(technicanCertificateExcelModelDTO.getInvalidCertificateTime());
                            sdf=new SimpleDateFormat("yyyy/MM/dd");
                            technicanCertificateAddDTO.setInvalidCertificateTime(sdf.format(invalidCertificateDate));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
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
