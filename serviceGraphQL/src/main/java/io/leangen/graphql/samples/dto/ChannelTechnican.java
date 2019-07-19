package io.leangen.graphql.samples.dto;

import io.leangen.graphql.samples.reslt.HttpBase;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 技术人员模型
 */
@Data
public class ChannelTechnican extends HttpBase {
    /**
     * 技术人员Id （唯一属性）
     */
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
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;
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
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date hireDate;
    /**
     * qq号
     */
    private String qqNum;
    /**
     * 座机电话（固话）
     */
    private String telephone;
    /**
     *审核状态 （wait） （pass）（not）
     */
    private String reviewStatus;
    /**
     * 审核未通过的原因
     */
    private String notPassCause;
    /**
     * 是否删除
     */
    private Integer haveDelete;
}
