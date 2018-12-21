package com.crm.ssh2.base.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.crm.ssh2.sale.entity.SalePlan;
import com.crm.ssh2.util.PageBean;

public class BaseDao extends HibernateDaoSupport implements Serializable {

	private static final long serialVersionUID = 1L;

	public BaseDao() {

	}

	private static final Logger log = LogManager.getLogger(BaseDao.class);
 
	/**
	 * 通用分页查询
	 * 
	 * @param hql
	 * @param args
	 * @param pageBean
	 * @return
	 */
	public List executeQuery(final String hql,final Map<String,Object> args,final PageBean pageBean) {
		return this.getHibernateTemplate().execute(new HibernateCallback<List>() {
			@Override
			public List doInHibernate(Session session) throws HibernateException {
				Query query = null;
				// 1.查满足条件的总记录
				if (null != pageBean && pageBean.isPagination()) {// 判断属性是否为空与是否为真
					String convertCountHql = convertCountHql(hql);
					log.info(convertCountHql);
					query = session.createQuery(convertCountHql);
					//赋值
					setParameters(query, args);
					//兼容Long和Integer
					Object total = query.uniqueResult();//uniqueResult：返回唯一的结果/单行单列
					pageBean.setTotal(total.toString());
				}

				query = session.createQuery(hql);
				log.info(hql);
				setParameters(query, args);
				//2.查询满足条件并指定页码的记录
				if(null!=pageBean&&pageBean.isPagination()){
					query.setFirstResult(pageBean.getStartIndex());//设置起始记录
					query.setMaxResults(pageBean.getRows());//设置最大结果集
				}
				List list = query.list();
				
				return list;
			}
			
		});
	}

	/**
	 * 通用参数赋值
	 * 
	 * @param query
	 * @param args
	 */
	public void setParameters(Query query, Map<String, Object> args) {
		if (null == args && 0 == args.size()) {
			return;
		}

		String name = null;
		Object value = null;
		for (Map.Entry<String, Object> entry : args.entrySet()) {
			name = entry.getKey();
			value = entry.getValue();
			if (value instanceof Collection) {// List和Set
				query.setParameterList(name, (Collection) value);
			} else if (value instanceof Object[]) {// 数组
				query.setParameterList(name, (Object[]) value);
			} else {// 单值
				query.setParameter(name, value);
			}
		}

	}

	/**
	 * 将普通hql转为全部hql
	 * 
	 * @param hql
	 * @return
	 */
	public String convertCountHql(String hql) {
		String convertCountHql = "";

		String newHQL = new String(hql).toUpperCase();// 改为大写
		int beginIndex = newHQL.indexOf("FROM ");
		int endIndex = newHQL.indexOf("ORDER BY");
		if (-1 == endIndex) {
			convertCountHql = "select count(*) " + hql.substring(beginIndex);
		} else {
			convertCountHql = "select count(*) " + hql.substring(beginIndex, endIndex);
		}

		return convertCountHql;
	}

}
