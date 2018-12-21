package com.crm.ssh2.basd.biz;

import java.util.List;

import com.crm.ssh2.basd.entity.BasdProduct;
import com.crm.ssh2.util.PageBean;

public interface IBasdProductBiz {
	
	void add(BasdProduct basdProduct);
	
	void edit(BasdProduct basdProduct);
	
	void del(BasdProduct basdProduct);
	
	BasdProduct load(BasdProduct basdProduct);
	
	List<BasdProduct> list(BasdProduct basdProduct,PageBean pageBean);
}
