package com.ai.dubbo.ext.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 是否业务成功
	 */
	private boolean isSuccess = false;

	private String resultCode;

	private String resultMsg;

	// 用于异常时，存放堆栈信息
	private Object info;

	public BaseResponse() {

	}

	public BaseResponse(boolean isSuccess, String resultCode, String resultMsg,
			Object info) {
		this.isSuccess = isSuccess;
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
		this.info = info;
	}

	public BaseResponse(boolean isSuccess, String resultCode, String resultMsg) {
		this.isSuccess = isSuccess;
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
	}

	public BaseResponse(boolean isSuccess, String resultCode) {
		this.isSuccess = isSuccess;
		this.resultCode = resultCode;
	}

	public BaseResponse(String resultCode, String resultMsg) {
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;

	}
	@JsonProperty(value="isSuccess")
	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public Object getInfo() {
		return info;
	}

	public void setInfo(Object info) {
		this.info = info;
	}

}
