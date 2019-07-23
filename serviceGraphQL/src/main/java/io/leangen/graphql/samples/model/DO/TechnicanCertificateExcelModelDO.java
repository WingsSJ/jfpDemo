package io.leangen.graphql.samples.model.DO;

import lombok.Data;

@Data
public class TechnicanCertificateExcelModelDO {
    /**
     * 证书编号
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
}
