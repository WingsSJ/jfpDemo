package com.demo.common.module.VO.app;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ChannelCompanyAppVO implements Serializable {

    /**
     * 主键id
     */
    private String cid;


    /**
     * 公司名称
     */
    private String cname;

    /**
     * 详细地址
     */
    private String addr;

    /**
     * 公司邮箱
     */
    private String cemail;

    /**
     * 邮政编码
     */
    private String postalCode;

    /**
     * 传真
     */
    private String fax;

    /**
     * 电话
     */
    private String telephone;

    /**
     * 所属省份
     */
    private String province;

    /**
     * 所属地市
     */
    private String city;

    /**
     * 所属区域
     */
    private String county;

    /**
     * 服务星级
     */
    private Integer cstar;

    /**
     * 是否是供货商
     */
    private Integer isSupplier;

    /**
     * 供货商级别
     */
    private Integer clevel;

    /**
     * 公司规模
     */
    private Integer cscale;

    /**
     * 服务范围
     */
    private String cscope;

    /**
     * 主营品牌
     */
    private String mainBus;

    /**
     * 公司网址
     */
    private String curl;

    /**
     * 统一社会信用码
     */
    private String credCode;

    /**
     * 注册资本
     */
    private BigDecimal registeredCapital;

    /**
     * 注册类型
     */
    private String registeredType;

    /**
     * 注册时间
     */
    private String registeredDate;

    /**
     * 法人姓名
     */
    private String legalName;

    /**
     * 法人性别
     */
    private Integer legalSex;

    /**
     * 公司税号
     */
    private String corpTax;

    /**
     * 开户行
     */
    private String cbank;

    /**
     * 银行账号
     */
    private String caccount;

    /**
     * 总经理姓名
     */
    private String managerName;

    /**
     * 总经理性别
     */
    private Integer managerSex;

    /**
     * 总经理邮箱
     */
    private String managerEmail;

    /**
     * 技术接口人姓名
     */
    private String techName;

    /**
     * 技术接口人性别
     */
    private Integer techSex;

    /**
     * 技术接口人职务
     */
    private String techPost;

    /**
     * 技术接口人座机
     */
    private String techTelephone;

    /**
     * 技术接口人手机号
     */
    private String techPhone;

    /**
     * 技术接口人邮箱
     */
    private String techEmail;

    /**
     * 商务接口人姓名
     */
    private String busName;

    /**
     * 商务接口人性别
     */
    private Integer busSex;

    /**
     * 商务接口人职务
     */
    private String busPost;

    /**
     * 商务接口人座机
     */
    private String busTelephone;

    /**
     * 商务接口人手机号
     */
    private String busPhone;

    /**
     * 商务接口人邮箱
     */
    private String busEmail;

    /**
     * 审核不通过原因
     */
    private String notPassCause;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态 0待审核1审核通过2审核不通过
     */
    private Integer status;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 更新人
     */
    private String updateUser;

    /**
     * 删除标志 默认值为0 代表未删除 1代表已删除
     */
    private Integer isDelete;


    private Integer code;

    private String message;

    /**
     * 标记：0 正常  1 删除
     */
    private Integer delFlag;

    private String __typename;


}
