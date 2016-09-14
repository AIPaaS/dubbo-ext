package com.ai.dubbo.ext.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * 分页对象.<br>
 * 提供给外部系统的分页Bean<br>
 * 
 * @param <T>
 *            结果集的数据类型 Date: 2015年8月7日 <br>
 *            Copyright (c) 2015 asiainfo.com <br>
 * @author gucl
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageInfo<T> extends BaseResponse implements Serializable {
	public PageInfo(boolean isSuccess, String resultCode, String resultMessage,
			String info) {
		super(isSuccess, resultCode, resultMessage, info);
	}

	public PageInfo(boolean isSuccess, String resultCode, String resultMessage) {
		super(isSuccess, resultCode, resultMessage);
	}

	public PageInfo(boolean isSuccess, String resultCode) {
		super(isSuccess, resultCode);
	}

	private static final long serialVersionUID = 1L;

	/**
	 * 请求查询的页码
	 */
	private Integer pageNo = 1;

	/**
	 * 每页显示条数
	 */
	private Integer pageSize;

	/**
	 * 结果集
	 */
	private List<T> result;

	/**
	 * 总条数
	 */
	private int count = 0;

	/**
	 * 总页数
	 */
	private int pageCount;

	private int startRowIndex;
	private int endRowIndex;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	/**
	 * 获取开始行
	 * 
	 * @return
	 * @author gucl
	 */
	public int getStartRowIndex() {
		startRowIndex = (this.getPageNo() - 1) * this.getPageSize();
		return startRowIndex;
	}

	/**
	 * 获取结束行
	 * 
	 * @return
	 * @author gucl
	 */
	public int getEndRowIndex() {
		endRowIndex = this.getPageNo() * this.getPageSize();
		return endRowIndex;
	}

	/**
	 * 获取最大页数
	 * 
	 * @return
	 * @author gucl
	 */
	public int getPageCount() {
		int quotient = this.getCount() / this.getPageSize();
		int remainder = this.getCount() % this.getPageSize();
		pageCount = quotient;
		if (remainder > 0) {
			pageCount += 1;
		}
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

}
