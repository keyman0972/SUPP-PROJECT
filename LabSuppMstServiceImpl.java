package com.ddsc.km.lab.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ddsc.core.entity.UserInfo;
import com.ddsc.core.exception.DdscApplicationException;
import com.ddsc.core.util.Pager;
import com.ddsc.km.lab.dao.ILabSuppMstDao;
import com.ddsc.km.lab.entity.LabSuppMst;
import com.ddsc.km.lab.service.ILabSuppMstService;

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

public class LabSuppMstServiceImpl implements ILabSuppMstService {
	
	private ILabSuppMstDao labSuppMstDao;
	
	@Override
	public LabSuppMst get(String id, UserInfo info) throws DdscApplicationException {
		try{
			return labSuppMstDao.get(id, info);
		}catch (DdscApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new DdscApplicationException(e, info);
		}
	}

	@Override
	public LabSuppMst create(LabSuppMst entity, UserInfo info) throws DdscApplicationException {
		try{
			labSuppMstDao.save(entity, info);
			return entity;
		}catch (DdscApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new DdscApplicationException(e, info);
		}
	}

	@Override
	public List<LabSuppMst> create(List<LabSuppMst> labSecondMsts, UserInfo info) throws DdscApplicationException {
		try{
			List<LabSuppMst> labSuppMstList = new ArrayList<LabSuppMst>();
			for(LabSuppMst labSuppMst: labSecondMsts){
				labSuppMstList.add(this.create(labSuppMst, info));
			}
			return labSuppMstList;
		}catch (DdscApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new DdscApplicationException(e, info);
		}
	}
	
	@Override
	public LabSuppMst update(LabSuppMst entity, UserInfo info) throws DdscApplicationException {
		try{
			return labSuppMstDao.update(entity, info);
		}catch (DdscApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new DdscApplicationException(e, info);
		}
	}
	
	@Override
	public List<LabSuppMst> update(List<LabSuppMst> labSuppMsts, UserInfo info) throws DdscApplicationException {
		try {
			List<LabSuppMst> lstReturn = new ArrayList<LabSuppMst>();
			for (LabSuppMst entity : labSuppMsts) {

				if ("insert".equals(entity.getOperate())) {
					// 新增
					lstReturn.add(this.create(entity, info));
				} else if ("update".equals(entity.getOperate())) {
					// 修改
					lstReturn.add(this.update(entity, info));
				}  else if ("delete".equals(entity.getOperate())){
					//刪除
					this.delete(entity, info);
				} else {
					// 未異動, 不做任何處理
					lstReturn.add(entity);
				}
			}
			return lstReturn;
		} catch (DdscApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new DdscApplicationException(e, info);
		}
	}
	
	@Override
	public LabSuppMst delete(LabSuppMst entity, UserInfo info) throws DdscApplicationException {
		try{
			labSuppMstDao.delete(entity, info);
			return entity;
		} catch (DdscApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new DdscApplicationException(e, info);
		}
	}
	
	@Override
	public List<LabSuppMst> delete(List<LabSuppMst> labSuppMsts, UserInfo info) throws DdscApplicationException {
		try{
			List<LabSuppMst> labSuppMstList = new ArrayList<LabSuppMst>();
			for(LabSuppMst labSuppMst : labSuppMsts){				
				labSuppMstList.add(this.delete(labSuppMst, info));			
			}
			return labSuppMstList;
		} catch (DdscApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new DdscApplicationException(e, info);
		}
	}
	
	@Override
	public List<LabSuppMst> searchAll(UserInfo info) throws DdscApplicationException {
		return null;
	}

	@Override
	public Pager searchByConditions(Map<String, Object> conditions, Pager pager, UserInfo userInfo) throws DdscApplicationException {
		try{
			return this.labSuppMstDao.searchByConditions(conditions, pager, userInfo);		
		} catch (DdscApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new DdscApplicationException(e, userInfo);
		}
	}

	@Override
	public List<LabSuppMst> searchByConditions(Map<String, Object> conditions, UserInfo userInfo) throws DdscApplicationException {
		return null;
	}

	@Override
	public List<Object> queryDataByParamsByService(Map<String, Object> conditions, UserInfo userInfo) throws DdscApplicationException {
		return null;
	}

	@Override
	public int getDataRowCountByConditions(Map<String, Object> conditions, UserInfo info) throws DdscApplicationException {
		try{
			return this.labSuppMstDao.getDataRowCountByConditions(conditions, info);		
		} catch (DdscApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new DdscApplicationException(e, info);
		}
	}
	
	@Override
	public List<Map<String, Object>> getList(UserInfo info) {
		try{
			return this.getLabSuppMstDao().getList(info);
		} catch (DdscApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new DdscApplicationException(e, info);
		}
	}
	
	
	public ILabSuppMstDao getLabSuppMstDao() {
		return labSuppMstDao;
	}

	public void setLabSuppMstDao(ILabSuppMstDao labSuppMstDao) {
		this.labSuppMstDao = labSuppMstDao;
	}
}
