package com.crm.ssh2.cust.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import com.crm.ssh2.basd.biz.IBasdDictBiz;
import com.crm.ssh2.basd.biz.impl.BasdDictBizimpl;
import com.crm.ssh2.basd.dao.impl.BasdDictDaoimpl;
import com.crm.ssh2.basd.entity.BasdDict;
import com.crm.ssh2.base.action.BaseAction;
import com.crm.ssh2.cust.biz.ICustServiceBiz;
import com.crm.ssh2.cust.entity.CustService;
import com.crm.ssh2.right.biz.IRightUserBiz;
import com.crm.ssh2.right.biz.impl.RightBizimpl;
import com.crm.ssh2.right.biz.impl.RightUserBizimpl;
import com.crm.ssh2.right.dao.impl.RightUserDaoimpl;
import com.crm.ssh2.right.entity.RightUser;
import com.crm.ssh2.sale.entity.SaleChance;
import com.crm.ssh2.util.PageBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ModelDriven;

public class CustServiceAction extends BaseAction implements ModelDriven<CustService> {

	private CustService custService = new CustService();
	
	private ICustServiceBiz custServiceBiz;
	private IBasdDictBiz basdDictBiz;
	private IRightUserBiz rightUserBiz;

	@Override
	public CustService getModel() {
		return custService;
	}

	public ICustServiceBiz getCustServiceBiz() {
		return custServiceBiz;
	}
	public void setCustServiceBiz(ICustServiceBiz custServiceBiz) {
		this.custServiceBiz = custServiceBiz;
	}
	public IBasdDictBiz getBasdDictBiz() {
		return basdDictBiz;
	}
	public void setBasdDictBiz(IBasdDictBiz basdDictBiz) {
		this.basdDictBiz = basdDictBiz;
	}
	public IRightUserBiz getRightUserBiz() {
		return rightUserBiz;
	}
	public void setRightUserBiz(IRightUserBiz rightUserBiz) {
		this.rightUserBiz = rightUserBiz;
	}
	

	public CustServiceAction() {
		super();
	}

	public String add() throws IOException {
		
		RightUser ru = (RightUser) session.getAttribute("login");
		custService.setCsStatus("新创建");
		custService.setCsCreateId(ru.getRuId());
		custService.setCsCreateBy(ru.getRuName());
		custService.setCsCreateDate(new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
		custServiceBiz.add(custService);
		
		//获得输出流
		ServletOutputStream os = response.getOutputStream();
		//组装datagrid对象所需的json数组
		Map<String, Object> data = new HashMap<String,Object>();
		//写入键、值
		data.put("message", "创建成功");
		data.put("code", 0);
		
		ObjectMapper om = new ObjectMapper();
		om.writeValue(os, data);
		os.flush();
		
		return null;
	}

	public String del() throws IOException {
		custServiceBiz.del(custService);

		//获得输出流
		ServletOutputStream os = response.getOutputStream();
		//组装datagrid对象所需的json数组
		Map<String, Object> data = new HashMap<String,Object>();
		//写入键、值
		data.put("message", "删除成功");
		data.put("code", 0);
		
		ObjectMapper om = new ObjectMapper();
		om.writeValue(os, data);
		os.flush();
		
		return null;
	}

	public String edit() throws IOException {
		RightUser ru = (RightUser) session.getAttribute("login");
		custService.setCsStatus("已处理");
		custService.setCsDealId(ru.getRuId());
		custService.setCsDeal(ru.getRuName());
		custService.setCsCreateDate(new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
		
		custServiceBiz.editCL(custService);
		//获得输出流
		ServletOutputStream os = response.getOutputStream();
		//组装datagrid对象所需的json数组
		Map<String, Object> data = new HashMap<String,Object>();
		//写入键、值
		data.put("message", "处理成功");
		data.put("code", 0);
		
		ObjectMapper om = new ObjectMapper();
		om.writeValue(os, data);
		os.flush();
				
		return null;
	}
	
	public String editMyd() throws IOException {
		custService.setCsStatus("已反馈");
		custServiceBiz.editFK(custService);
		//获得输出流
		ServletOutputStream os = response.getOutputStream();
		//组装datagrid对象所需的json数组
		Map<String, Object> data = new HashMap<String,Object>();
		//写入键、值
		data.put("message", "处理成功");
		data.put("code", 0);
		
		ObjectMapper om = new ObjectMapper();
		om.writeValue(os, data);
		os.flush();
				
		return null;
	}
	

	public String load() {
		this.result = this.custServiceBiz.load(custService);
		return this.getForward(EDIT);
	}
	
	//获得下拉框的值
	public void get() {
		//查询所有服务类型信息
		BasdDict basdDict = new BasdDict();
		basdDict.setBdType("服务类型");
		List<BasdDict> basdDictList = basdDictBiz.list(basdDict, null);
		session.setAttribute("basdDictList", basdDictList);
		//查询所有满意度信息
		basdDict.setBdType("满意度");
		List<BasdDict> myd = basdDictBiz.list(basdDict, null);
		session.setAttribute("myd", myd);
		//查询所有客户经理信息
		RightUser rightUser = new RightUser();
		rightUser.setRuRoleId(4);
		List<RightUser> rightUserList = rightUserBiz.list(rightUser, null);
		session.setAttribute("rightUserList", rightUserList);
		
	}
	
	public String toAdd() {
		Integer maxCsId = custServiceBiz.getMaxCsId();
		request.setAttribute("maxCsId", maxCsId+1);
		this.get();
		return "toAdd";
	}
	
	public String toMYD() {
		//取出客户服务信息
		CustService cs = custServiceBiz.load(custService);
		this.get();
		request.setAttribute("cs", cs);
		return "toMYD";
	}
	
	//主界面查询
	public String list() throws IOException {
		String str = request.getParameter("str");
		//获得输出流
		ServletOutputStream os = response.getOutputStream();
		//分页操作
		PageBean pageBean = new PageBean();
		pageBean.setRequest(request);
		request.setAttribute("pageBean", pageBean);
		
		//查询数据
		List<CustService> custServiceList = custServiceBiz.list(str,custService, pageBean);
		
		this.get();
		
		//组装datagrid对象所需的json数组
		Map<String, Object> data = new HashMap<String,Object>();
		//写入键值
		data.put("total", pageBean.getTotal());//总页数
		data.put("rows", custServiceList);//数据集合
		
		ObjectMapper om = new ObjectMapper();
		om.writeValue(os, data);
		os.flush();
				
		return null;
	}
	
	//分配
	public String doFP() throws IOException {
		//获得输出流
		ServletOutputStream os = response.getOutputStream();
		
		RightUser rightUser = new RightUser();
		rightUser.setRuId(Integer.parseInt(custService.getCsDueId()));
		RightUser ru = rightUserBiz.load(rightUser);
		custService.setCsDueTo(ru.getRuName());
		custService.setCsStatus("已分配");
		custServiceBiz.edit(custService);
		
		//组装datagrid对象所需的json数组
		Map<String, Object> data = new HashMap<String,Object>();
		//写入键、值
		data.put("message", "分配成功");
		data.put("code", 0);
		
		ObjectMapper om = new ObjectMapper();
		om.writeValue(os, data);
		os.flush();
				
		return null;
	}
	
	//跳转处理界面
	public String toCL() {
		//取出客户服务信息
		CustService cs = custServiceBiz.load(custService);
		request.setAttribute("cs", cs);
		
		return "cl";
	}
}
