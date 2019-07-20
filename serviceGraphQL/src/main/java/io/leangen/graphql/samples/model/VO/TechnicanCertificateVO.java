package io.leangen.graphql.samples.model.VO;

import lombok.Data;

/**
 * 技术人员证书信息
 */
@Data
public class TechnicanCertificateVO {
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
     *证书获取时间
     */
    private String receiveCertificateTime;
    /**
     *证书失效时间
     */
    private String invalidCertificateTime;
}
