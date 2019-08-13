package com.demo.common.module.VO;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 技术人员
 */
@Data
public class ChannelTechnicanVO implements Serializable {
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
     * 人员性别 (和前端保持一致 修改为0 1返回形式)
     */
    private Integer personGender;
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
     *审核状态 和前端保持一致（0代表为未通过） （1 代表通过）（2代表待审核）
     */
    private Integer reviewStatus;
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
}
