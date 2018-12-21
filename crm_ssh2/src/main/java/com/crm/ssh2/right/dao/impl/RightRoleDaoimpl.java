package com.crm.ssh2.right.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crm.ssh2.base.dao.BaseDao;
import com.crm.ssh2.right.dao.IRightRoleDao;
import com.crm.ssh2.right.entity.RightRole;
import com.crm.ssh2.util.PageBean;
import com.crm.ssh2.util.StringUtils;

public class RightRoleDaoimpl extends BaseDao implements IRightRoleDao{
	
	private static final long serialVersionUID = 8990404156897424875L;

	@Override
	public void add(RightRole rightRole) {
		this.getHibernateTemplate().save(rightRole);
		
	}

	@Override
	public void edit(RightRole rightRole) {
		RightRole rr = this.getHibernateTemplate().load(RightRole.class, rightRole.getRrId());
		if(null!=rr) {
			rr.setRrName(rightRole.getRrName());
			rr.setRrDesc(rightRole.getRrDesc());
			rr.setRrFlag(rightRole.getRrFlag());
		}
		
	}

	@Override
	public void del(RightRole rightRole) {
		RightRole rr = this.getHibernateTemplate().load(RightRole.class, rightRole.getRrId());
		if(null!=rr) {
			this.getHibernateTemplate().delete(rightRole);
		}
	}

	@Override
	public RightRole load(RightRole rightRole) {
		return this.getHibernateTemplate().get(RightRole.class,rightRole.getRrId());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RightRole> list(RightRole rightRole, PageBean pageBean) {
		System.out.println(rightRole);
		String hql = "from RightRole where 1=1";
		Map<String , Object> args = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(rightRole.getRrName())) {
			hql += " and rrName like :rname";
			args.put("rname", "%"+rightRole.getRrName().trim()+"%");
		}
		if(null!=rightRole.getRrFlag()) {
			if(3==rightRole.getRrFlag()) {
				hql += " and rrFlag is not null";
			}else {
				hql += " and rrFlag = :rflag";
				args.put("rflag", rightRole.getRrFlag());
			}
		}
		hql += " and rrId <> 1";
		System.out.println(hql);
		return this.executeQuery(hql, args, pageBean);
	}

}
