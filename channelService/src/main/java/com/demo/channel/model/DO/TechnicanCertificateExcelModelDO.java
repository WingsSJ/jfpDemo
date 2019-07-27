package com.demo.channel.model.DO;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class TechnicanCertificateExcelModelDO {
    /**
     *
     */
    @ExcelIgnore
    private String personId;
    /**
     * 证书方向
     */
    @Excel(name = "证书方向*", orderNum = "15")
    private String certificateDirection;
    /**
     * 证书级别
     */
    @Excel(name = "证书级别*", orderNum = "16")
    private String certificateLevel;
    /**
     * 证书编号
     */
    @Excel(name = "证书编号*", orderNum = "17")
    private String certificateId;
    /**
     *证书失效时间
     */
    @Excel(name = "证书有效期*", orderNum = "18")
    private Date invalidCertificateTime;
}
