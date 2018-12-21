package com.crm.ssh2.cust.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crm.ssh2.base.dao.BaseDao;
import com.crm.ssh2.cust.dao.ICustServiceDAO;
import com.crm.ssh2.cust.entity.CustService;
import com.crm.ssh2.util.PageBean;
import com.crm.ssh2.util.StringUtils;

public class CustServiceDAOImpl extends BaseDao implements ICustServiceDAO {

	private static final long serialVersionUID = 1084392037234753734L;
	
	@Override
	public void add(CustService custService) {
		this.getHibernateTemplate().save(custService);
	}

	@Override
	public void edit(CustService custService) {
		CustService cs = this.getHibernateTemplate().load(CustService.class, custService.getCsId());
		if(null!=cs) {
			cs.setCsId(custService.getCsId());
			cs.setCsStatus(custService.getCsStatus());
			cs.setCsDueId(custService.getCsDueId());
			cs.setCsDueTo(custService.getCsDueTo());
			cs.setCsDueDate(new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
		}
	}
	
	@Override
	public void editCL(CustService custService) {
		CustService cs = this.getHibernateTemplate().load(CustService.class, custService.getCsId());
		if(null!=cs) {
			cs.setCsId(custService.getCsId());
			cs.setCsStatus(custService.getCsStatus());
			cs.setCsDealBy(custService.getCsDealBy());
			cs.setCsDealId(custService.getCsDealId());
			cs.setCsDeal(custService.getCsDeal());
			cs.setCsDealDate(new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
		}
	}
	
	@Override
	public void editFK(CustService custService) {
		CustService cs = this.getHibernateTemplate().load(CustService.class, custService.getCsId());
		if(null!=cs) {
			cs.setCsId(custService.getCsId());
			cs.setCsStatus(custService.getCsStatus());
			cs.setCsResult(custService.getCsResult());
			cs.setCsSatisfy(custService.getCsSatisfy());
		}
	}

	@Override
	public void del(CustService custService) {
		CustService cs = this.getHibernateTemplate().load(CustService.class, custService.getCsId());
		if(null!=cs) {
			this.getHibernateTemplate().delete(custService);
		}
	}

	@Override
	public CustService load(CustService custService) {
		return this.getHibernateTemplate().get(CustService.class, custService.getCsId());
	}

	@Override
	public List<CustService> list(String str,CustService custService, PageBean pageBean) {
		String hql = "from CustService where 1=1";
		Map<String, Object> args = new HashMap<String, Object>();
		
		//状态分类
		if(StringUtils.isNotBlank(str)) {
			hql+=" and csStatus = :csStatus";
			args.put("csStatus", str);
		}
		//客户名称+概要模糊查
		if(StringUtils.isNotBlank(custService.getCsCustName())) {
			hql+=" and csCustName like :csCustName";
			args.put("csCustName", "%"+custService.getCsCustName()+"%");
		}
		if(StringUtils.isNotBlank(custService.getCsTitle())) {
			hql+=" and csTitle like :csTitle";
			args.put("csTitle", "%"+custService.getCsTitle()+"%");
		}
		//服务类型查询
		if(StringUtils.isNotBlank(custService.getCsType())) {
			hql+=" and csType like :csType";
			args.put("csType", "%"+custService.getCsType()+"%");
		}
		//创建日期区间查询
		if(StringUtils.isNotBlank(custService.getCsCreateDate())) {
			hql+=" and csCreateDate >= :csCreateDate";
			args.put("csCreateDate", custService.getCsCreateDate());
		}
		if(StringUtils.isNotBlank(custService.getCsDealDate())) {
			hql+=" and csCreateDate <= :csDealDate";
			args.put("csDealDate", custService.getCsDealDate());
		}
		
		return this.executeQuery(hql, args, pageBean);
	}
	
	//获得最大编号值
	@Override
	public Integer getMaxCsId() {
		String hql = "select max(cs.csId) from CustService cs";
		List<Integer> list = new ArrayList<Integer>();
		list = (List<Integer>)this.getHibernateTemplate().find(hql);
		return list.get(0);
	}

}
