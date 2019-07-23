package io.leangen.graphql.samples.model.DO;

import lombok.Data;

import java.util.Date;

/**
 * 技术人员证书信息
 */
@Data
public class TechnicanCertificateDO {
    /**
     * 证书Id
     */
    private String certificateId;
    /**
     * 人员Id
     */
    private String personId;
    /**
     * 证书方向
     */
    private String certificateDirection;
    /**
     * 证书级别
     */
    private String certificateLevel;

    /**
     *证书失效时间
     */
    private Date invalidCertificateTime;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 数据更新时间
     */
    private Date updateTime;
    /**
     * 是否被删除
     */
    private Integer haveDelete;
}
