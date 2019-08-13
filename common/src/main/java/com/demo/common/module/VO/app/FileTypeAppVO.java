package com.demo.common.module.VO.app;

import lombok.Data;

import java.io.Serializable;

/**
 * 分类 
 * 
 * @author wly
 *
 * @date 2019-07-18 14:35:08
 */
@Data
public class FileTypeAppVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	private String typeId;
	/**
	 * 分类名称
	 */
	private String typeName;
}
