package com.ddsc.km.lab.dao.hibernate;

import java.util.*;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Hibernate;

import com.ddsc.core.dao.hibernate.GenericDaoHibernate;
import com.ddsc.core.entity.UserInfo;
import com.ddsc.core.exception.DdscApplicationException;
import com.ddsc.core.util.HibernateScalarHelper;
import com.ddsc.core.util.LocaleDataHelper;
import com.ddsc.core.util.Pager;
import com.ddsc.km.lab.dao.ILabSuppMstDao;
import com.ddsc.km.lab.entity.LabSuppMst;

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

public class LabSuppMstDaoHibernate extends GenericDaoHibernate<LabSuppMst,String> implements ILabSuppMstDao {

	@Override
	public Pager searchByConditions(Map<String, Object> conditions, Pager pager, UserInfo userInfo) throws DdscApplicationException {
		
		String suppName_lang = LocaleDataHelper.getPropertityWithLocalUpper("SUPP_NAME", userInfo.getLocale());
		
		StringBuffer sbsql = new StringBuffer();
		sbsql.append("SELECT SUPP.SUPP_ID, SUPP."+suppName_lang+" AS SUPP_NAME, SUPP.ADDRESS, SUPP.SUPP_TEL");
		sbsql.append(" FROM LAB_SUPP_MST SUPP");

		String keyword = " WHERE ";
		List<Object> value = new ArrayList<Object>();
		if (StringUtils.isNotEmpty((String) conditions.get("suppId"))) {
			sbsql.append(keyword + "SUPP.SUPP_ID LIKE ?");
			value.add(conditions.get("suppId") + "%");
			keyword = " AND ";
		}
		if (StringUtils.isNotEmpty((String) conditions.get("suppName"))) {
			sbsql.append(keyword + "SUPP." + suppName_lang + " LIKE ?");
			value.add("%"+conditions.get("suppName") + "%");
			keyword = " AND ";
		}
		
		sbsql.append(" ORDER BY SUPP.SUPP_ID ");
		
		// 建立List<HibernateScalarHelper> scalarList = new ArrayList<HibernateScalarHelper>(); 並add
		List<HibernateScalarHelper> scalarList = new ArrayList<HibernateScalarHelper>();
		scalarList.add(new HibernateScalarHelper("SUPP_ID", Hibernate.STRING));
		scalarList.add(new HibernateScalarHelper("SUPP_NAME", Hibernate.STRING));
		scalarList.add(new HibernateScalarHelper("ADDRESS", Hibernate.STRING));
		scalarList.add(new HibernateScalarHelper("SUPP_TEL", Hibernate.STRING));
		
		// 回傳
		return super.findBySQLQueryMapPagination(sbsql.toString(), pager, scalarList, value, userInfo);
	}

	@Override
	public List<Map<String, Object>> getList(UserInfo userInfo) throws DdscApplicationException {
		
		StringBuffer sbsql= new StringBuffer();
		
		String suppName_lang = LocaleDataHelper.getPropertityWithLocalUpper("SUPP_NAME", userInfo.getLocale());
		
		sbsql.append("SELECT SUPP.SUPP_ID, SUPP." + suppName_lang + " AS SUPP_NAME ");
		sbsql.append("FROM LAB_SUPP_MST SUPP ");
		
		List<Object> values = new ArrayList<Object>();
		sbsql.append(" ORDER BY SUPP.SUPP_ID ");
		
		List<HibernateScalarHelper> scalarList = new ArrayList<HibernateScalarHelper>();
		scalarList.add(new HibernateScalarHelper("SUPP_ID", Hibernate.STRING));
		scalarList.add(new HibernateScalarHelper("SUPP_NAME", Hibernate.STRING));
		return super.findBySQLQueryMap(sbsql.toString(), scalarList, values, userInfo);
	}

}
