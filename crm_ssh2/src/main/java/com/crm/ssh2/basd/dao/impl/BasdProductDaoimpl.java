package com.crm.ssh2.basd.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crm.ssh2.basd.dao.IBasdProductDao;
import com.crm.ssh2.basd.entity.BasdProduct;
import com.crm.ssh2.base.dao.BaseDao;
import com.crm.ssh2.util.PageBean;
import com.crm.ssh2.util.StringUtils;

public class BasdProductDaoimpl extends BaseDao implements IBasdProductDao {

	private static final long serialVersionUID = -6467083385205391357L;

	@Override
	public void add(BasdProduct basdProduct) {
		// TODO Auto-generated method stub

	}

	@Override
	public void edit(BasdProduct basdProduct) {
		// TODO Auto-generated method stub

	}

	@Override
	public void del(BasdProduct basdProduct) {
		// TODO Auto-generated method stub

	}

	@Override
	public BasdProduct load(BasdProduct basdProduct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BasdProduct> list(BasdProduct basdProduct, PageBean pageBean) {
		String hql = "from BasdProduct where 1=1 ";
		Map<String, Object> args = new HashMap<String,Object>();
		
		if(StringUtils.isNotBlank(basdProduct.getBpName())) {
			hql+=" and bpName like :bpName ";
			args.put("bpName", "%"+basdProduct.getBpName()+"%");
		}
		if(StringUtils.isNotBlank(basdProduct.getBpType())) {
			hql+=" and bpType like :bpType ";
			args.put("bpType", "%"+basdProduct.getBpType()+"%");
		}
		if(StringUtils.isNotBlank(basdProduct.getBpBatch())) {
			hql+=" and bpBatch like :bpBatch ";
			args.put("bpBatch", "%"+basdProduct.getBpBatch()+"%");
		}
		
		
		
		return this.executeQuery(hql, args, pageBean);
	}

}
