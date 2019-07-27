package com.demo.channel.model.VO;

import lombok.Data;

/**
 * 技术人员证书信息
 */
@Data
public class TechnicanCertificateVO{
    /**
     * 证书Id
     */
    private String certificateId;
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

    public TechnicanCertificateVO(String certificateId, String certificateDirection, String certificateLevel, String invalidCertificateTime) {
        this.certificateId = certificateId;
        this.certificateDirection = certificateDirection;
        this.certificateLevel = certificateLevel;
        this.invalidCertificateTime = invalidCertificateTime;
    }
}
