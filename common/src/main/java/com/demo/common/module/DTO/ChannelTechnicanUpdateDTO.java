package com.demo.common.module.DTO;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

/**
 * 技术人员模型
 */
@Data
public class ChannelTechnicanUpdateDTO implements Serializable,Cloneable{
    /**
     * 技术人员Id （唯一属性）
     */
    @NotBlank
    private String personId;
    /**
     * 公司Id
     */
    private String companyId;
    /**
     * 技术人员姓名
     */
    private String personName;
    /**
     * 人员性别
     */
    private Integer personGender;
    /**
     * 人员身份证Id
     */
    private String identityCard;
    /**
     * 技术人员生日（yyyy-MM-dd）
     */
    @JSONField(name = "birthday",format = "yyyy-MM-dd")
    private String birthday;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 人员公司所在省
     */
    private String province;
    /**
     * 人员公司所在市
     */
    private String city;
    /**
     * 人员公司所在镇
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
    @JSONField(name = "hireDate",format = "yyyy-MM-dd")
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
}
