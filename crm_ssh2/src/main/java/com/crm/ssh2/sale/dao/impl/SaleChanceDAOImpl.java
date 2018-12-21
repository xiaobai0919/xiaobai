package com.crm.ssh2.sale.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.crm.ssh2.base.dao.BaseDao;
import com.crm.ssh2.sale.dao.ISaleChanceDAO;
import com.crm.ssh2.sale.entity.SaleChance;
import com.crm.ssh2.util.PageBean;
import com.crm.ssh2.util.StringUtils;

public class SaleChanceDAOImpl extends BaseDao implements ISaleChanceDAO {

	private static final long serialVersionUID = -1006774252010141819L;

	@Override
	public void add(SaleChance saleChance) {
		this.getHibernateTemplate().save(saleChance);
	}

	@Override
	public void edit(SaleChance saleChance) {
		SaleChance sc = this.getHibernateTemplate().load(SaleChance.class, saleChance.getScId());
		if(null!=sc) {
			sc.setScSource(saleChance.getScSource());
			sc.setScCustName(saleChance.getScCustName());
			sc.setScTitle(saleChance.getScTitle());
			sc.setScRate(saleChance.getScRate());
			sc.setScLinkman(saleChance.getScLinkman());
			sc.setScTel(saleChance.getScTel());
			sc.setScDesc(saleChance.getScDesc());
			sc.setScCreateId(saleChance.getScCreateId());
			sc.setScCreateBy(saleChance.getScCreateBy());
			sc.setScCreateDate(saleChance.getScCreateDate());
			sc.setScDueId(saleChance.getScDueId());
			sc.setScDueTo(saleChance.getScDueTo());
			sc.setScDueDate(saleChance.getScDueDate());
			sc.setScStatus(saleChance.getScStatus());
		}
	}
	
	@Override
	public void editStatus(SaleChance saleChance) {
		SaleChance sc = this.getHibernateTemplate().load(SaleChance.class, saleChance.getScId());
		if(null!=sc) {
			sc.setScStatus(saleChance.getScStatus());
		}
	}

	@Override
	public void del(SaleChance saleChance) {
		SaleChance sc = this.getHibernateTemplate().load(SaleChance.class, saleChance.getScId());
		if(null!=sc) {
			this.getHibernateTemplate().delete(saleChance);
		}
	}

	public SaleChance load(SaleChance saleChance) {
		return this.getHibernateTemplate().load(SaleChance.class, saleChance.getScId());
	}
	
	//查询所有
	@Override
	public List<SaleChance> list(String str,SaleChance saleChance, PageBean pageBean) {
		String hql = "from SaleChance where 1=1 ";
		Map<String, Object> args = new HashMap<String,Object>();
		
		if("1".equals(str)) {
			hql+=" and scStatus = :scStatus ";
			args.put("scStatus", str);
		}
		else {
			hql+=" and scStatus != 1 ";
		}
		
		if(StringUtils.isNotBlank(saleChance.getScCustName())) {
			hql+=" and scCustName like :scCustName ";
			args.put("scCustName", "%"+saleChance.getScCustName()+"%");
		}
		if(StringUtils.isNotBlank(saleChance.getScTitle())) {
			hql+=" and scTitle like :scTitle ";
			args.put("scTitle", "%"+saleChance.getScTitle()+"%");
		}
		if(StringUtils.isNotBlank(saleChance.getScLinkman())) {
			hql+=" and scLinkman like :scLinkman ";
			args.put("scLinkman", "%"+saleChance.getScLinkman()+"%");
		}
		
		return this.executeQuery(hql, args, pageBean);
	}
	
	//查询单个
	@Override
	public List<SaleChance> loadJH(SaleChance saleChance) {
		String hql = "from SaleChance where 1=1 ";
		Map<String, Object> args = new HashMap<String,Object>();
		hql+=" and scId = :scId ";
		args.put("scId", saleChance.getScId());
		
		return this.executeQuery(hql, args, null);
	}
	
	//获得最大编号值
	@Override
	public Integer dogetMaxScId() {
		String hql = "select max(sc.scId) from SaleChance sc";
		List<Integer> list = new ArrayList<Integer>();
		list = (List<Integer>)this.getHibernateTemplate().find(hql);
		return list.get(0);
	}

	@Override
	public void ZP(SaleChance saleChance) {
		SaleChance sc = this.getHibernateTemplate().get(SaleChance.class, saleChance.getScId());
		if(null!=sc) {
			sc.setScDueId(saleChance.getScDueId());
			//模仿从用户表取出所有客户经理信息
			Map<String,Object> args = new HashMap<String,Object>();
			args.put("1", "xiaobai");
			args.put("4", "客户经理一号");
			args.put("5", "客户经理二号");
			args.put("6", "客户经理三号");
			//
			String scDueTo = (String) args.get(saleChance.getScDueId()+"");
			sc.setScDueTo(scDueTo);
			sc.setScDueDate(saleChance.getScDueDate());
			sc.setScStatus("2");
		}
	}
	
	//查询所有
	public SaleChance listSalePlan(final SaleChance saleChance) {
		List<SaleChance> list = this.getHibernateTemplate().execute(new HibernateCallback<List<SaleChance>>() {
			@Override
			public List<SaleChance> doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("from SaleChance where spChcId = :spChcId");
				query.setParameter("spChcId", saleChance.getScId());
				return query.list();
			}
		});
		return list.get(0);
	}
	
}
