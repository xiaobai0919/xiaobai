package com.crm.ssh2.basd.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.crm.ssh2.basd.dao.IBasdStorageDao;
import com.crm.ssh2.basd.entity.BasdStorage;
import com.crm.ssh2.base.dao.BaseDao;
import com.crm.ssh2.sale.entity.SaleChance;
import com.crm.ssh2.util.PageBean;
import com.crm.ssh2.util.StringUtils;

public class BasdStorageDaoimpl extends BaseDao implements IBasdStorageDao {

	private static final long serialVersionUID = -6467083385205391357L;

	@Override
	public void add(BasdStorage basdStorage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void edit(BasdStorage basdStorage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void del(BasdStorage basdStorage) {
		// TODO Auto-generated method stub

	}

	@Override
	public BasdStorage load(BasdStorage basdStorage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BasdStorage> list(BasdStorage basdStorage, PageBean pageBean) {
		String hql = "select new BasdStorage(bs.bsId,bs.bpId,bs.bsWarehouse,bs.bsWare,bs.bsCount,bs.bsMenu,bp.bpName,bp.bpType,bp.bpBatch) from BasdStorage bs,BasdProduct bp where bs.bpId=bp.bpId ";
		Map<String, Object> args = new HashMap<String, Object>();
		
		return this.executeQuery(hql, args, pageBean);
	}

}
