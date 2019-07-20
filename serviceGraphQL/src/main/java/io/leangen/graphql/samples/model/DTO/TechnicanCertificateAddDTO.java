package io.leangen.graphql.samples.model.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 技术人员证书信息
 */
@Data
public class TechnicanCertificateAddDTO implements Serializable,Cloneable {
    /**
     * 证书Id
     */
    @NotBlank
    private String certificateId;
    /**
     * 人员Id
     */
    private String personId;
    /**
     * 证书方向
     */
    @NotBlank
    private String certificateDirection;
    /**
     * 证书级别
     */
    @NotBlank
    private String certificateLevel;
    /**
     *证书获取时间
     */
    @NotBlank
    private String receiveCertificateTime;
    /**
     *证书失效时间
     */
    private String invalidCertificateTime;
}
