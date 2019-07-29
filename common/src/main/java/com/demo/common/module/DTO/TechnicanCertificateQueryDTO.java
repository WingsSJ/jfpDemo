package com.demo.common.module.DTO;

import lombok.Data;

/**
 * 技术人员证书信息
 */
@Data
public class TechnicanCertificateQueryDTO {
    /**
     * 证书Id
     */
    private String certificateId;
    /**
     *
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
    private String invalidCertificateTime;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 数据更新时间
     */
    private String updateTime;
}
