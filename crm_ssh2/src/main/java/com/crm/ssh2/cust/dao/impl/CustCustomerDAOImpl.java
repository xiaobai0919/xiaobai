package com.crm.ssh2.cust.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crm.ssh2.base.dao.BaseDao;
import com.crm.ssh2.cust.dao.ICustCustomerDAO;
import com.crm.ssh2.cust.entity.CustCustomer;
import com.crm.ssh2.util.PageBean;
import com.crm.ssh2.util.StringUtils;

public class CustCustomerDAOImpl extends BaseDao implements ICustCustomerDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1885211039828773438L;

	public CustCustomerDAOImpl() {
		super();
	}

	@Override
	public void add(CustCustomer custCustomer) {
		this.getHibernateTemplate().save(custCustomer);
	}

	@Override
	public void edit(CustCustomer custCustomer) {
		CustCustomer load = this.getHibernateTemplate().load(CustCustomer.class, custCustomer.getCcNo());
		if (null != load) {
			load.setCcName(custCustomer.getCcName());
			load.setCcRegion(custCustomer.getCcRegion());
			load.setCcManageName(custCustomer.getCcManageName());
			load.setCcLevelLabel(custCustomer.getCcLevelLabel());
			load.setCcSatisfy(custCustomer.getCcSatisfy());
			load.setCcCredit(custCustomer.getCcCredit());
			load.setCcAddress(custCustomer.getCcAddress());
			load.setCcZip(custCustomer.getCcZip());
			load.setCcTel(custCustomer.getCcTel());
			load.setCcFax(custCustomer.getCcFax());
			load.setCcWebsite(custCustomer.getCcWebsite());
			load.setCcLicenceNo(custCustomer.getCcLicenceNo());
			load.setCcChieftain(custCustomer.getCcChieftain());
			load.setCcBankroll(custCustomer.getCcBankroll());
			load.setCcTurnover(custCustomer.getCcTurnover());
			load.setCcBank(custCustomer.getCcBank());
			load.setCcBankAccount(custCustomer.getCcBankAccount());
			load.setCcLocalTaxNo(custCustomer.getCcLocalTaxNo());
			load.setCcNationalTaxNo(custCustomer.getCcNationalTaxNo());
		}
	}

	@Override
	public void del(CustCustomer custCustomer) {
		CustCustomer load = this.getHibernateTemplate().get(CustCustomer.class, custCustomer.getCcNo());
		if (null != load) {
			this.getHibernateTemplate().delete(load);
		}
	}

	@Override
	public CustCustomer load(CustCustomer custCustomer) {
		CustCustomer load = this.getHibernateTemplate().get(CustCustomer.class, custCustomer.getCcNo());
		return load;
	}

	@Override
	public List<CustCustomer> list(CustCustomer custCustomer, PageBean pageBean) {
		String hql = "from CustCustomer where 1=1"; 
		Map<String, Object> args = new HashMap<String, Object>();
		System.out.println("这是：" + custCustomer);
		if (StringUtils.isNotBlank(custCustomer.getCcName())) {
			hql += " and ccName like :cc_name";
			args.put("cc_name", "%" + custCustomer.getCcName().trim() + "%");
			System.out.println("sql:" + hql);
		}
		return this.executeQuery(hql, args, pageBean);
	}

}
