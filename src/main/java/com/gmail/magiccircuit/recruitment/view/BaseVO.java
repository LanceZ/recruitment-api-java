package com.gmail.magiccircuit.recruitment.view;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class BaseVO implements Serializable {
	public static final String RES_CODE_SUCC = "0";

	public static final String RES_CODE_ERR_CHECK_USER_FAILED = "10";
	
	public static final String RES_CODE_ERR_SESSION_NULL = "11";
	
	public static final String RES_CODE_ERR_CHECK_PARAMS_FAILED = "20";
	
	public static final String RES_CODE_ERR_DATA_NOT_FOUND = "50";
	
	public static final String RES_CODE_ERR_USER_NOT_FOUND = "51";

	private static final long serialVersionUID = 1L;

	Map<String, Object> attrs = new HashMap<String, Object>();

	String resCode;

	String resMsg;

	public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}

	public String getResMsg() {
		return resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}

	public void setAttr(String key, Object value) {
		this.attrs.put(key, value);
	}

	public Object getAttr(String key) {
		return this.attrs.get(key);
	}
}
