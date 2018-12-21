package com.crm.ssh2.basd.dao;

import java.util.List;

import com.crm.ssh2.basd.entity.BasdStorage;
import com.crm.ssh2.util.PageBean;

public interface IBasdStorageDao {
	
	void add(BasdStorage basdStorage);
	
	void edit(BasdStorage basdStorage);
	
	void del(BasdStorage basdStorage);
	
	BasdStorage load(BasdStorage basdStorage);
	
	List<BasdStorage> list(BasdStorage basdStorage,PageBean pageBean);
}
