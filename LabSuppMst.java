package com.ddsc.km.lab.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ddsc.core.entity.BaseEntity;
import com.ddsc.core.util.LocaleDataHelper;

/**
 * <table>
 * <tr>
 * <th>版本</th>
 * <th>日期</th>
 * <th>詳細說明</th>
 * <th>modifier</th>
 * </tr>
 * <tr>
 * <td>1.0</td>
 * <td>2017/7/4</td>
 * <td>新建檔案</td>
 * <td>"keyman"</td>
 * </tr>
 * </table>
 * @author "keyman"
 *
 * 類別說明 :
 *
 *
 * 版權所有 Copyright 2008 © 中菲電腦股份有限公司 本網站內容享有著作權，禁止侵害，違者必究。 <br>
 * (C) Copyright Dimerco Data System Corporation Inc., Ltd. 2009 All Rights
 */

@Entity
@Table(name="LAB_SUPP_MST")
@NamedQuery(name = "findSuppMstByKey", query = "Select o.suppId, o.suppName_lang1 As name From LabSuppMst o Where o.suppId=:suppId ")
public class LabSuppMst extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -5321238935276707463L;
	
	private String suppId;
	private String suppName;
	private String suppName_lang1;
	private String suppName_lang2;
	private String suppName_lang3;
	private String address;
	private String suppTel;
	
	@Id
	@Column(name="SUPP_ID")
	public String getSuppId() {
		return suppId;
	}
	
	public void setSuppId(String suppId) {
		this.suppId = suppId;
	}
	
	@Transient
	public String getSuppName() {
		if (null != this.suppName && this.suppName.length() == 0) {
			return null;
		} else {
			return this.suppName;
		}
	}
	
	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}
	
	@Column(name="SUPP_NAME_LANG1")
	public String getSuppName_lang1() {
		if (LocaleDataHelper.equalToLocale(LocaleDataHelper.LANGUAGE_1)) {
			return this.getSuppName();
		} else {
			return suppName_lang1;
		}
	}
	
	public void setSuppName_lang1(String suppName_lang1) {
		this.suppName_lang1 = suppName_lang1;
		if (LocaleDataHelper.equalToLocale(LocaleDataHelper.LANGUAGE_1)) {
			this.suppName = suppName_lang1;
		}
	}
	
	@Column(name="SUPP_NAME_LANG2")
	public String getSuppName_lang2() {
		if (LocaleDataHelper.equalToLocale(LocaleDataHelper.LANGUAGE_2)) {
			return this.getSuppName();
		} else {
			return suppName_lang2;
		}
	}
	
	public void setSuppName_lang2(String suppName_lang2) {
		this.suppName_lang2 = suppName_lang2;
		if (LocaleDataHelper.equalToLocale(LocaleDataHelper.LANGUAGE_2)) {
			this.suppName = suppName_lang2;
		}
	}
	
	@Column(name="SUPP_NAME_LANG3")
	public String getSuppName_lang3() {
		if (LocaleDataHelper.equalToLocale(LocaleDataHelper.LANGUAGE_3)) {
			return this.getSuppName();
		} else {
			return suppName_lang3;
		}
	}
	
	public void setSuppName_lang3(String suppName_lang3) {
		this.suppName_lang3 = suppName_lang3;
		if (LocaleDataHelper.equalToLocale(LocaleDataHelper.LANGUAGE_3)) {
			this.suppName = suppName_lang3;
		}
	}
	
	@Column(name="ADDRESS")
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
		
	@Column(name="SUPP_TEL")
	public String getSuppTel() {
		return suppTel;
	}
	
	public void setSuppTel(String suppTel) {
		this.suppTel = suppTel;
	}
	
}
