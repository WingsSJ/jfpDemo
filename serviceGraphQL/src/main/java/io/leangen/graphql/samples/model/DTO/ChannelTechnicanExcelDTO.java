package io.leangen.graphql.samples.model.DTO;

import lombok.Data;

@Data
public class ChannelTechnicanExcelDTO {
    /**
     *
     */
    private String companyName;
    /**
     *
     */
    private String companyId;
    /**
     * 技术人员Id （唯一属性）
     */
    private String personId;
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
     * 技术人员生日
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
     * 入职日期
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
}
