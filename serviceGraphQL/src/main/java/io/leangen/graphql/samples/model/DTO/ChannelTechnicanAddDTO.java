package io.leangen.graphql.samples.model.DTO;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 技术人员模型
 */
@Data
public class ChannelTechnicanAddDTO implements Serializable,Cloneable{
    /**
     * 技术人员Id （唯一属性）
     */
    @NotBlank
    private String personId;
    /**
     * 公司Id
     */
    @NotBlank
    private String companyId;
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
}
