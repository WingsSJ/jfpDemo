package com.demo.common.module.VO;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 文件 
 * 
 * @author wly
 *
 * @date 2019-07-18 14:35:08
 */
@Data
public class TssFsmDoc implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@JsonProperty("fid")
	private String docId;
	/**
	 * 文件名称
	 */
	@JsonProperty("name")
	private String docName;
	/**
	 * 文件大小
	 */
	@JsonProperty("size")
	private String docSize;
	/**
	 * 文件hash值
	 */
	private String docSha256;
	/**
	 * 文件类型
	 */
	@JsonProperty("category")
	private String docCategory;
	/**
	 * 文件分类
	 */
	@JsonProperty("type")
	private String docType;
	/**
	 * 文件URL
	 */
	@JsonProperty("url")
	private String docUrl;
	/**
	 * 预览URL
	 */

	private String watchUrl;
	/**
	 * 状态 0:正常；1：删除;2回收站
	 */
	@JsonProperty("status")
	private Integer delFlag;
	/**
	 * 下载次数
	 */
	@JsonProperty("downloadNumber")
	private Integer docDownloadNumber;
	/**
	 * 分享次数
	 */
	@JsonProperty("shareNumber")
	private Integer docShareNumber;
	/**
	 * 创建人ID
	 */
	@JsonProperty("createdId")
	private String createdById;
	/**
	 * 创建人姓名
	 */
	@JsonProperty("createdName")
	private String createdByName;
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@JsonProperty("ctime")
	private Date createdTime;
	/**
	 * 更新人id
	 */
	@JsonProperty("updatedId")
	private String updatedById;
	/**
	 * 更新人姓名
	 */
	@JsonProperty("updatedName")
	private String updatedByName;
	/**
	 * 更新时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@JsonProperty("utime")
	private Date updatedTime;
	/**
	 * 版本
	 */
	@JsonProperty("version")
	private String docVersion;

}
