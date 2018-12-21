package com.crm.ssh2.basd.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crm.ssh2.basd.dao.IBasdDictDao;
import com.crm.ssh2.basd.entity.BasdDict;
import com.crm.ssh2.base.dao.BaseDao;
import com.crm.ssh2.util.PageBean;
import com.crm.ssh2.util.StringUtils;

public class BasdDictDaoimpl extends BaseDao implements IBasdDictDao {

	private static final long serialVersionUID = -6467083385205391357L;

	public BasdDictDaoimpl() {
		
	}

	@Override
	public void add(BasdDict basdDict) {
		this.getHibernateTemplate().save(basdDict);

	}

	@Override
	public void edit(BasdDict basdDict) {
		BasdDict basdd = this.getHibernateTemplate().load(BasdDict.class, basdDict.getBdId());
		if(null!=basdd) {
			basdd.setBdType(basdDict.getBdType());
			basdd.setBdItem(basdDict.getBdItem());
			basdd.setBdValue(basdDict.getBdValue());
			basdd.setBdIsEditable(basdDict.getBdIsEditable());
		}
	}

	@Override
	public void del(BasdDict basdDict) {
		BasdDict basdd = this.getHibernateTemplate().load(BasdDict.class, basdDict.getBdId());
		if(null!=basdd) {
			this.getHibernateTemplate().delete(basdDict);
		}

	}

	@Override
	public BasdDict load(BasdDict basdDict) {
		BasdDict basdd = this.getHibernateTemplate().get(BasdDict.class, basdDict.getBdId());
		return basdd;
	}

	@Override
	public List<BasdDict> list(BasdDict basdDict, PageBean pageBean) {
		String hql = "from BasdDict bd where 1=1";
		Map<String, Object> args = new HashMap<String, Object>();
		
		if(StringUtils.isNotBlank(basdDict.getBdType())) {
			hql += " and bdType like :bdType";
			args.put("bdType", "%"+basdDict.getBdType().trim()+"%");
		}
		if(StringUtils.isNotBlank(basdDict.getBdItem())) {
			hql += " and bdItem like :bdItem";
			args.put("bdItem", "%"+basdDict.getBdItem().trim()+"%");
		}
		if(StringUtils.isNotBlank(basdDict.getBdValue())) {
			hql += " and bdValue like :bdValue";
			args.put("bdValue", "%"+basdDict.getBdValue().trim()+"%");
		}
		return this.executeQuery(hql, args, pageBean);
	}
	
	//获得最大编号值
	@Override
	public Integer dogetMaxBdId() {
		String hql = "select max(bd.bdId) from BasdDict bd";
		List<Integer> list = new ArrayList<Integer>();
		list = (List<Integer>)this.getHibernateTemplate().find(hql);
		return list.get(0);
	}
	

}
