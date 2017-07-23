package com.ddsc.km.lab.service;

import java.util.List;
import java.util.Map;

import com.ddsc.core.entity.UserInfo;
import com.ddsc.core.exception.DdscApplicationException;
import com.ddsc.core.service.IBaseCRUDService;
import com.ddsc.core.service.IBaseSearchService;
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

public interface ILabSuppMstService extends IBaseCRUDService<LabSuppMst, String>, IBaseSearchService<LabSuppMst, String> {
	
	public int getDataRowCountByConditions(Map<String, Object> conditions, UserInfo info) throws DdscApplicationException;
	
	public List<Map<String, Object>> getList(UserInfo info) throws DdscApplicationException;
	
	public List<LabSuppMst> create(List<LabSuppMst> labSecondMsts, UserInfo info) throws DdscApplicationException;
	public List<LabSuppMst> update(List<LabSuppMst> labSecondMsts, UserInfo info) throws DdscApplicationException;
	public List<LabSuppMst> delete(List<LabSuppMst> labSecondMsts, UserInfo info) throws DdscApplicationException;
}
