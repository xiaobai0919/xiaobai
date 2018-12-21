package com.crm.ssh2.cust.entity;

import com.crm.ssh2.base.entity.BaseEntity;

public class CustCustomer extends BaseEntity {

	/**
	 * 客户信息类
	 */
	private static final long serialVersionUID = 1786112311860900243L;

	private String ccNo; // 客户编号

	private String ccName; // 客户名称
	private String ccRegion; // 地区：根据字典（地区）

	private Integer ccManagerId;// 客户经理ID
	private String ccManageName; // 客户经理名字
	private Integer ccLevel; // 客户级别 默认1 根据字典

	private String ccLevelLabel;// 客户级别标志

	private Integer ccSatisfy;// 客户满意度:1~5 默认值3 (数据字典 客户满意度)
	private Integer ccCredit;// 客户信用度:1~5 默认值3 (数据字典 客户信用度)

	private String ccAddress;// 地址
	private String ccZip;// 邮政编码
	private String ccTel;// 电话

	private String ccFax;// 传真

	private String ccWebsite;// 网站
	private String ccLicenceNo;// 营业执照注册号

	private String ccChieftain;// 法人
	private Integer ccBankroll;// 注册资金（万元）:默认值0
	private Integer ccTurnover;// 年营业额:默认值0

	private String ccBank;// 开户银行

	private String ccBankAccount;// 银行帐号
	private String ccLocalTaxNo;// 地税登记号

	private String ccNationalTaxNo;// 国税登记号
	private String ccStatus;// 客户状态: 默认值 1 正常 2 非正常 数据字典(客户状态)

	public CustCustomer() {
		super();
	}

	public String getCcNo() {
		return ccNo;
	}

	public void setCcNo(String ccNo) {
		this.ccNo = ccNo;
	}

	public String getCcName() {
		return ccName;
	}

	public void setCcName(String ccName) {
		this.ccName = ccName;
	}

	public String getCcRegion() {
		return ccRegion;
	}

	public void setCcRegion(String ccRegion) {
		this.ccRegion = ccRegion;
	}

	public Integer getCcManagerId() {
		return ccManagerId;
	}

	public void setCcManagerId(Integer ccManagerId) {
		this.ccManagerId = ccManagerId;
	}

	public String getCcManageName() {
		return ccManageName;
	}

	public void setCcManageName(String ccManageName) {
		this.ccManageName = ccManageName;
	}

	public Integer getCcLevel() {
		return ccLevel;
	}

	public void setCcLevel(Integer ccLevel) {
		this.ccLevel = ccLevel;
	}

	public String getCcLevelLabel() {
		return ccLevelLabel;
	}

	public void setCcLevelLabel(String ccLevelLabel) {
		this.ccLevelLabel = ccLevelLabel;
	}

	public Integer getCcSatisfy() {
		return ccSatisfy;
	}

	public void setCcSatisfy(Integer ccSatisfy) {
		this.ccSatisfy = ccSatisfy;
	}

	public Integer getCcCredit() {
		return ccCredit;
	}

	public void setCcCredit(Integer ccCredit) {
		this.ccCredit = ccCredit;
	}

	public String getCcAddress() {
		return ccAddress;
	}

	public void setCcAddress(String ccAddress) {
		this.ccAddress = ccAddress;
	}

	public String getCcZip() {
		return ccZip;
	}

	public void setCcZip(String ccZip) {
		this.ccZip = ccZip;
	}

	public String getCcTel() {
		return ccTel;
	}

	public void setCcTel(String ccTel) {
		this.ccTel = ccTel;
	}

	public String getCcFax() {
		return ccFax;
	}

	public void setCcFax(String ccFax) {
		this.ccFax = ccFax;
	}

	public String getCcWebsite() {
		return ccWebsite;
	}

	public void setCcWebsite(String ccWebsite) {
		this.ccWebsite = ccWebsite;
	}

	public String getCcLicenceNo() {
		return ccLicenceNo;
	}

	public void setCcLicenceNo(String ccLicenceNo) {
		this.ccLicenceNo = ccLicenceNo;
	}

	public String getCcChieftain() {
		return ccChieftain;
	}

	public void setCcChieftain(String ccChieftain) {
		this.ccChieftain = ccChieftain;
	}

	public Integer getCcBankroll() {
		return ccBankroll;
	}

	public void setCcBankroll(Integer ccBankroll) {
		this.ccBankroll = ccBankroll;
	}

	public Integer getCcTurnover() {
		return ccTurnover;
	}

	public void setCcTurnover(Integer ccTurnover) {
		this.ccTurnover = ccTurnover;
	}

	public String getCcBank() {
		return ccBank;
	}

	public void setCcBank(String ccBank) {
		this.ccBank = ccBank;
	}

	public String getCcBankAccount() {
		return ccBankAccount;
	}

	public void setCcBankAccount(String ccBankAccount) {
		this.ccBankAccount = ccBankAccount;
	}

	public String getCcLocalTaxNo() {
		return ccLocalTaxNo;
	}

	public void setCcLocalTaxNo(String ccLocalTaxNo) {
		this.ccLocalTaxNo = ccLocalTaxNo;
	}

	public String getCcNationalTaxNo() {
		return ccNationalTaxNo;
	}

	public void setCcNationalTaxNo(String ccNationalTaxNo) {
		this.ccNationalTaxNo = ccNationalTaxNo;
	}

	public String getCcStatus() {
		return ccStatus;
	}

	public void setCcStatus(String ccStatus) {
		this.ccStatus = ccStatus;
	}

	@Override
	public String toString() {
		return "CustCustomer [ccNo=" + ccNo + ", ccName=" + ccName + ", ccRegion=" + ccRegion + ", ccManagerId="
				+ ccManagerId + ", ccManageName=" + ccManageName + ", ccLevel=" + ccLevel + ", ccLevelLabel="
				+ ccLevelLabel + ", ccSatisfy=" + ccSatisfy + ", ccCredit=" + ccCredit + ", ccAddress=" + ccAddress
				+ ", ccZip=" + ccZip + ", ccTel=" + ccTel + ", ccFax=" + ccFax + ", ccWebsite=" + ccWebsite
				+ ", ccLicenceNo=" + ccLicenceNo + ", ccChieftain=" + ccChieftain + ", ccBankroll=" + ccBankroll
				+ ", ccTurnover=" + ccTurnover + ", ccBank=" + ccBank + ", ccBankAccount=" + ccBankAccount
				+ ", ccLocalTaxNo=" + ccLocalTaxNo + ", ccNationalTaxNo=" + ccNationalTaxNo + ", ccStatus=" + ccStatus
				+ "]";
	}

}
