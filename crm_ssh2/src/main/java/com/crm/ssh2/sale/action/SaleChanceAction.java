package com.crm.ssh2.sale.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletOutputStream;

import com.crm.ssh2.base.action.BaseAction;
import com.crm.ssh2.right.biz.IRightUserBiz;
import com.crm.ssh2.right.entity.RightUser;
import com.crm.ssh2.sale.biz.ISaleChanceBiz;
import com.crm.ssh2.sale.entity.SaleChance;
import com.crm.ssh2.sale.entity.SalePlan;
import com.crm.ssh2.util.PageBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ModelDriven;

public class SaleChanceAction extends BaseAction implements ModelDriven<SaleChance> {

	//SaleChance必须在这new一个新对象
	private SaleChance saleChance = new SaleChance();
	private ISaleChanceBiz saleChanceBiz;
	private IRightUserBiz rightUserBiz;

	@Override
	public SaleChance getModel() {
		return saleChance;
	}

	public ISaleChanceBiz getSaleChanceBiz() {
		return saleChanceBiz;
	}
	public void setSaleChanceBiz(ISaleChanceBiz saleChanceBiz) {
		this.saleChanceBiz = saleChanceBiz;
	}
	public IRightUserBiz getRightUserBiz() {
		return rightUserBiz;
	}
	public void setRightUserBiz(IRightUserBiz rightUserBiz) {
		this.rightUserBiz = rightUserBiz;
	}

	public String add() throws IOException {
		//获得输出流
		ServletOutputStream os = response.getOutputStream();
		//添加系统参数
		saleChance.setScDueDate(null);
		
		System.out.println(saleChance.getScId()+"=============================");
		
		RightUser ru = (RightUser) session.getAttribute("login");
		
		saleChance.setScCreateId(ru.getRuId());
		saleChance.setScCreateBy(ru.getRuName());

		saleChance.setScStatus("1");
		saleChance.setScCreateDate(new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
		//新建营销机会
		saleChanceBiz.add(saleChance);
		//组装datagrid对象所需要json数组
		Map<String, Object> data = new HashMap<String, Object>();
		//写入键、值
		data.put("message", "增加成功");
		data.put("code", 0);
		
		ObjectMapper om = new ObjectMapper();
		om.writeValue(os, data);
		os.flush();
		
		return null;
	}
	
	public String del() throws IOException {
		ServletOutputStream os = response.getOutputStream();
		saleChanceBiz.del(saleChance);
		
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("message", "删除成功");
		data.put("code", 0);
		
		ObjectMapper om = new ObjectMapper();
		om.writeValue(os, data);
		os.flush();
		
		return null;
	}

	public String edit() {
		//模仿从用户表取出所有客户经理信息
		RightUser rightUser = new RightUser();
		rightUser.setRuRoleId(4);
		List<RightUser> rightUserList = rightUserBiz.list(rightUser, null);
		Map<String,Object> args = new HashMap<String,Object>();
		for (RightUser ru : rightUserList) {
			args.put(ru.getRuId()+"", ru.getRuName());
		}
		String scDueTo = (String) args.get(saleChance.getScDueId()+"");
		
		saleChance.setScDueTo(scDueTo);
		if(saleChance.getScDueId()!=-1) {
			saleChance.setScStatus("2");
		}
		saleChanceBiz.edit(saleChance);
		this.message = "修改成功";
		return LIST;
	}
	
	public String ZP() {
		saleChanceBiz.ZP(saleChance);
		this.message = "指派成功";
		return LIST;
	}

	public String loadZP() {
		this.result = this.saleChanceBiz.load(saleChance);
		//模仿从用户表取出所有客户经理信息
		RightUser rightUser = new RightUser();
		rightUser.setRuRoleId(4);
		List<RightUser> rightUserList = rightUserBiz.list(rightUser, null);
		Map<String,Object> args = new HashMap<String,Object>();
		for (RightUser ru : rightUserList) {
			args.put(ru.getRuId()+"", ru.getRuName());
		}
		this.resulta = args;
		return "ZP";
	}
	
	public String list() throws IOException {
		Integer maxChcId = saleChanceBiz.dogetMaxScId();
		session.setAttribute("maxScId", maxChcId);
		//取营销机会状态
		String str = request.getParameter("str");
		
		//获得输出流
		ServletOutputStream os = response.getOutputStream();
		//分页操作
		PageBean pageBean = new PageBean();
		pageBean.setRequest(request);
		request.setAttribute("pageBean", pageBean);
		
		//查询数据
		List<SaleChance> saleChanceList = saleChanceBiz.list(str,saleChance, pageBean);
		for (SaleChance sc : saleChanceList) {
			if("1".equals(sc.getScStatus())) {
				sc.setScStatus("未指派");
			}
			else if("2".equals(sc.getScStatus())) {
				sc.setScStatus("开发中");
			}else{
				sc.setScStatus("已归档");
			}
		}
		
		//组装datagrid对象所需的json数组
		Map<String, Object> data = new HashMap<String,Object>();
		//写入键值
		data.put("total", pageBean.getTotal());//总页数
		data.put("rows", saleChanceList);//数据集合
		
		ObjectMapper om = new ObjectMapper();
		om.writeValue(os, data);
		os.flush();
		
		return null;
	}
	
	public String loadEdit() {
		this.result = this.saleChanceBiz.load(saleChance);
		//模仿从用户表取出所有客户经理信息
		RightUser rightUser = new RightUser();
		rightUser.setRuRoleId(4);
		List<RightUser> rightUserList = rightUserBiz.list(rightUser, null);
		Map<String,Object> args = new HashMap<String,Object>();
		for (RightUser ru : rightUserList) {
			args.put(ru.getRuId()+"", ru.getRuName());
		}

		this.resulta = args;
		return "edit";
	}
	
	/**
	 * 开发计划管理取值
	 * @return
	 */
	//制定计划
	public String loadZD() {
		List<SaleChance> loadZD = this.saleChanceBiz.loadJH(saleChance);
		SaleChance sc = loadZD.get(0);
		request.setAttribute("sc", sc);
		Set<SalePlan> salePlan = sc.getSalePlan();
		request.setAttribute("spList", salePlan);
		return "ZD";
	}
	
	//执行计划
	public String loadZX() {
		List<SaleChance> loadZD = this.saleChanceBiz.loadJH(saleChance);
		SaleChance sc = loadZD.get(0);
		request.setAttribute("sc", sc);
		Set<SalePlan> salePlan = sc.getSalePlan();
		request.setAttribute("spList", salePlan);
		return "ZX";
	}
	
	//查看
	public String Look() {
		List<SaleChance> loadZD = this.saleChanceBiz.loadJH(saleChance);
		SaleChance sc = loadZD.get(0);
		request.setAttribute("sc", sc);
		Set<SalePlan> salePlan = sc.getSalePlan();
		request.setAttribute("spList", salePlan);
		return "Look";
	}
	
	//修改状态
	public String editStatus() throws IOException {
		String str = request.getParameter("str");
		saleChance.setScStatus(str);
		saleChanceBiz.editStatus(saleChance);
		
		ServletOutputStream os = response.getOutputStream();
		//组装datagrid对象所需的json数组
		Map<String, Object> data = new HashMap<String,Object>();
		//写入键值
		if("3".equals(str)) {
			data.put("message", "用户开发成功，已添加新客户记录。");
		}
		if("4".equals(str)) {
			data.put("message", "用户开发失败，已添加新客户记录。");
		}
		data.put("code", 0);
		
		ObjectMapper om = new ObjectMapper();
		om.writeValue(os, data);
		os.flush();
		
		return null;
	}
	
}
