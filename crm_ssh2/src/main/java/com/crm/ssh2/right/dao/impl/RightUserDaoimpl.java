package com.crm.ssh2.right.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crm.ssh2.base.dao.BaseDao;
import com.crm.ssh2.right.dao.IRightUserDao;
import com.crm.ssh2.right.entity.RightUser;
import com.crm.ssh2.util.PageBean;
import com.crm.ssh2.util.StringUtils;

public class RightUserDaoimpl extends BaseDao implements IRightUserDao{
	
	private static final long serialVersionUID = 8990404156897424875L;

	@Override
	public void add(RightUser rightUser) {
		this.getHibernateTemplate().save(rightUser);
	}

	@Override
	public void edit(RightUser rightUser) {
		RightUser r = this.getHibernateTemplate().load(RightUser.class, rightUser.getRuId());
		if(null!=r) {
			r.setRuName(rightUser.getRuName());
			r.setRuPassword(rightUser.getRuPassword());
			r.setRuRoleId(rightUser.getRuRoleId());
			
			r.setRuFlag(rightUser.getRuFlag());
		}
	}

	@Override
	public void del(RightUser rightUser) {
		RightUser r = this.getHibernateTemplate().load(RightUser.class, rightUser.getRuId());
		if(null!=r) {
			this.getHibernateTemplate().delete(rightUser);
		}
	}

	@Override
	public RightUser load(RightUser rightUser) {
		return this.getHibernateTemplate().get(RightUser.class, rightUser.getRuId());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RightUser> list(RightUser rightUser, PageBean pageBean) {
		String hql = "select new RightUser(a.ruId,a.ruName,a.ruPassword,a.ruRoleId,a.ruFlag,b.rrName,b.rrDesc)from RightUser a ,RightRole b  where a.ruRoleId=b.rrId";
		Map<String , Object> args = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(rightUser.getRuName())) {
			hql+=" and a.ruName like :ruName ";
			args.put("ruName", "%"+rightUser.getRuName()+"%");
		}
		if(null!=rightUser.getRuRoleId()) {
			hql+=" and a.ruRoleId = :ruRoleId ";
			args.put("ruRoleId", rightUser.getRuRoleId());
		}
		if(null!=rightUser.getRuFlag()) {
			if(3==rightUser.getRuFlag()) {
				hql+=" and a.ruFlag is not null";
			}else {
				hql+=" and a.ruFlag = :ruFlag ";
				args.put("ruFlag", rightUser.getRuFlag());
			}
		}
			hql +=" and a.ruRoleId <> 1";
		return this.executeQuery(hql, args, pageBean);
	}

	@SuppressWarnings("unchecked")
	@Override
	public RightUser login(RightUser rightUser) {
		String hql = "select new RightUser(a.ruId,a.ruName,a.ruPassword,a.ruRoleId,a.ruFlag,b.rrName)from RightUser a ,RightRole b  where a.ruRoleId=b.rrId";
		Map<String, Object> args = new HashMap<String, Object>();
		if(StringUtils.isNotBlank(rightUser.getRuName())&&StringUtils.isNotBlank(rightUser.getRuPassword())) {
			hql += " and a.ruName = :runame and a.ruPassword = :ruPassword";
			args.put("runame", rightUser.getRuName());
			args.put("ruPassword", rightUser.getRuPassword());
		}
		/*if(StringUtils.isNotBlank(rightUser.getRuPassword())) {
			hql += " and a.ruPassword = :ruPassword";
		}*/
		List<RightUser> list = this.executeQuery(hql, args, null);
		return list.get(0);
	}
}
