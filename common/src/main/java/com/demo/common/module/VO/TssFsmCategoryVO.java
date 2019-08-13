package com.demo.common.module.VO;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 分类 
 * 
 * @author wly
 *
 * @date 2019-07-18 14:35:08
 */
@Data
public class TssFsmCategoryVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@JsonProperty("cid")
	private Integer id;
	/**
	 * 分类名称
	 */
	@JsonProperty("fname")
	private String name;
	/**
	 * 分类父ID
	 */
	@JsonProperty("pid")
	private Integer parentid;
	/**
	 * 分类状态
	 */
	private Integer status;
	/**
	 * 当前级别
	 */
	private Integer level;
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date createtime;
	/**
	 * 更新时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date updatetime;

	/**
	 * 	子分类
	 */
	private List<TssFsmCategoryVO> children;
}
