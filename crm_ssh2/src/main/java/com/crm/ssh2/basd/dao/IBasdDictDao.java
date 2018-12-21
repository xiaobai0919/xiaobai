package com.crm.ssh2.basd.dao;

import java.util.List;

import com.crm.ssh2.basd.entity.BasdDict;
import com.crm.ssh2.util.PageBean;

public interface IBasdDictDao {
	
	//取最大字典表最大编号
	Integer dogetMaxBdId();
	//增加字典数据
	void add(BasdDict basdDict);
	//修改字典数据
	void edit(BasdDict basdDict);
	//删除字典数据
	void del(BasdDict basdDict);
	//单个查询
	BasdDict load(BasdDict basdDict);
	//查询所有
	List<BasdDict> list(BasdDict basdDict,PageBean pageBean);
}
