package com.crm.ssh2.right.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crm.ssh2.base.dao.BaseDao;
import com.crm.ssh2.right.dao.IRightDao;
import com.crm.ssh2.right.entity.Right;
import com.crm.ssh2.right.entity.RightUser;
import com.crm.ssh2.util.PageBean;
import com.crm.ssh2.util.StringUtils;

public class RightDaoimpl extends BaseDao implements IRightDao{
	
	private static final long serialVersionUID = 8990404156897424875L;
	
	
	@Override
	public void add(Right right) {
		this.getHibernateTemplate().save(right);
	}

	@Override
	public void edit(Right right) {
		Right r = this.getHibernateTemplate().load(Right.class, right.getrCode());
		if(null!=r) {
			r.setrText(right.getrText());
			r.setrUrl(right.getrUrl());
			r.setrTip(right.getrTip());
		}
	}

	@Override
	public void del(Right right) {
		Right r = this.getHibernateTemplate().load(Right.class, right.getrCode());
		if(null!=r) {
			this.getHibernateTemplate().delete(right);
		}
	}

	@Override
	public Right load(Right right) {
		return this.getHibernateTemplate().get(Right.class, right.getrCode());
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Right> list(Right right,RightUser rightUser) {
		String hql = "select new com.crm.ssh2.right.entity.Right(a.rCode,a.rParentCode,a.rType,a.rText,a.rUrl,a.rTip) from Right a,RightRole b,RightQx c where a.rCode=c.rqrCode and b.rrId = c.rqrRoleId ";
		Map<String , Object> args = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(right.getrCode())) {
			hql+=" and a.rCode = :rCode ";
			args.put("rCode", right.getrCode());
		}
		if(null==right.getrParentCode()) {
			hql+=" and a.rParentCode is null";
		}
		else {
			hql+=" and a.rParentCode = :rParentCode";
			args.put("rParentCode", right.getrParentCode());
		}
		
		if(null!=rightUser.getRuRoleId()) {
			hql+=" and b.rrId = "+rightUser.getRuRoleId();
		}
		return this.executeQuery(hql, args, null);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Right> list(Right right, PageBean pageBean) {
		String hql = "from Right where 1=1";
		Map<String , Object> args = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(right.getrCode())) {
			hql+=" and rCode = :rCode ";
			args.put("rCode", right.getrCode());
		}
		if(StringUtils.isNotBlank(right.getrText())) {
			hql+=" and rText like :rText";
			args.put("rText", "%"+right.getrText().trim()+"%");
		}
		if(StringUtils.isNotBlank(right.getrType())) {
			hql+=" and rTip like :rTip";
			args.put("rTip", "%"+right.getrTip().trim()+"%");
		}
		return this.executeQuery(hql, args, pageBean);
	}
}
