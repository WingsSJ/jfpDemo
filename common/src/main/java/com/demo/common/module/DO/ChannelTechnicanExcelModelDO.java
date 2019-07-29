package com.demo.common.module.DO;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;


/**
 * 渠道技术人员模型类
 */
@Data
public class ChannelTechnicanExcelModelDO {
    /**
     * 前端传递做属性填充
     */
    @ExcelIgnore
    private String companyName;
    /**
     * 前端传递做属性填充
     */
    @ExcelIgnore
    private String companyId;
    /**
     * 技术人员Id （服务端生成UUID）
     */
    @ExcelIgnore
    private String personId;
    /**
     * 技术人员姓名
     */
    @Excel(name = "姓名*", orderNum = "1")
    private String personName;
    /**
     * 人员性别
     */
    @Excel(name = "性别*", orderNum = "2")
    private String personGender;
    /**
     * 人员身份证Id
     */
    @Excel(name = "身份证*", orderNum = "4")
    private String identityCard;
    /**
     * 技术人员生日
     */
    @Excel(name = "出生年月*",importFormat = "yyyy/MM/dd", orderNum = "3")
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date birthday;
    /**
     * 联系电话
     */
    @Excel(name = "手机号*", orderNum = "10")
    private String phone;
    /**
     * 省
     */
    @Excel(name = "所属省份*", orderNum = "5")
    private String province;
    /**
     * 市
     */
    @Excel(name = "所属地市*", orderNum = "6")
    private String city;
    /**
     * 镇
     */
    @Excel(name = "所属区*", orderNum = "7")
    private String county;
    /**
     * 居住地址
     */
    @Excel(name = "居住地址*", orderNum = "8")
    private String address;
    /**
     * 人员职务
     */
    @Excel(name = "职务*", orderNum = "9")
    private String job;
    /**
     * 邮箱地址
     */
    @Excel(name = "邮箱*", orderNum = "11")
    private String email;
    /**
     * 入职日期
     */
    @Excel(name = "入职时间*",importFormat = "yyyy/MM/dd",exportFormat = "yyyy/MM/dd",orderNum = "1")
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date hireDate;
    /**
     * qq号
     */
    @Excel(name = "QQ", orderNum = "12")
    private String qqNum;
    /**
     * 座机电话（固话）
     */
    @Excel(name = "座机", orderNum = "14")
    private String telephone;

    /**
     * 渠道技术人员证书信息
     */
    @ExcelCollection(name = "证书",orderNum = "15")
    private List<TechnicanCertificateExcelModelDO> technicanCertificateExcelModelDOS;
    /***
     * 校验结果
     */
    @ExcelIgnore
    private String verifyResult;
    /**
     * 对应数据校验状态码 校验通过
     */
    @ExcelIgnore
    private Integer verifyCode;

    /**
     * 非空校验
     */
    public boolean checkNull(){
        return StringUtils.isAnyBlank(this.companyId,this.companyName,this.personName,
                this.personGender,this.identityCard,this.phone,this.province,this.city,this.county,this.address,this.job);
    }
}
