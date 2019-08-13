package com.demo.common.module.VO.app;

import lombok.Data;

import java.io.Serializable;

@Data
public class TechnicanCertificateAppVO implements Serializable {
    /**
     * 证书Id
     */
    private String tcId;
    /**
     * 证书方向
     */
    private String tcDrt;
    /**
     * 证书级别
     */
    private String tcLv;

    /**
     *证书失效时间
     */
    private String tcTime;

    public TechnicanCertificateAppVO(String tcId, String tcDrt, String tcLv, String tcTime) {
        this.tcId = tcId;
        this.tcDrt = tcDrt;
        this.tcLv = tcLv;
        this.tcTime = tcTime;
    }
}
