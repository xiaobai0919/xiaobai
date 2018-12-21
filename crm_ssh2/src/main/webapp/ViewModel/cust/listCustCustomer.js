/**
 * 定义vm模型
 * 
 * @returns
 */

function ViewModel(data) {
	var _this = this;

	this.enableButton = ko.observable(false);

	this.selectedRowIndex = -1;

	this.selectRow = null;
	this.options = {
		url : contextPath + "/cust/custCustomerAction_list.action",
		_onSelect : function(index, row) {
			_this.selectedRowIndex = index;
			_this.selectRow = row;
			_this.enableButton(-1 != index ? true : false);

		}
	};

	// 地区
	$.ajax({
		type : 'post',
		async : false,
		url : contextPath + "/basd/basdDictAction_list.action?bdType=" + "地区",
		dataType : 'json',
		success : function(d) {
			console.log(d);
			$(d.rows).each(
					function(index, element) {
						$(
								"<option value='" + element.bdItem + "'>"
										+ element.bdItem + "</option>")
								.appendTo("#ccRegion");
					});
		}
	});

	// 客户等级
	$.ajax({
		type : 'post',
		async : false,
		url : contextPath + "/basd/basdDictAction_list.action?bdType="
				+ "企业客户等级",
		dataType : 'json',
		success : function(d) {
			console.log(d);
			$(d.rows).each(
					function(index, element) {
						$(
								"<option value='" + element.bdItem + "'>"
										+ element.bdItem + "</option>")
								.appendTo("#ccLevelLabel");
					});
		}
	});

	// 客户满意度
	$.ajax({
		type : 'post',
		async : false,
		url : contextPath + "/basd/basdDictAction_list.action?bdType="
				+ "客户满意度",
		dataType : 'json',
		success : function(d) {
			console.log(d);
			$(d.rows).each(
					function(index, element) {
						$(
								"<option value='" + element.bdItem + "'>"
										+ element.bdItem + "</option>")
								.appendTo("#ccSatisfy");
					});
		}
	});

	// 客户信用度
	$.ajax({
		type : 'post',
		async : false,
		url : contextPath + "/basd/basdDictAction_list.action?bdType="
				+ "客户信用度",
		dataType : 'json',
		success : function(d) {
			console.log(d);
			$(d.rows).each(
					function(index, element) {
						$(
								"<option value='" + element.bdItem + "'>"
										+ element.bdItem + "</option>")
								.appendTo("#ccCredit");
					});
		}
	});

	// 客户经理
	$.ajax({
		type : 'post',
		async : false,
		url : contextPath + "/cust/custCustomerAction_list.action",
		dataType : 'json',
		success : function(d) {
			console.log(d);
			$(d.rows).each(
					function(index, element) {
						console.log(1111);
						$(
								"<option value='" + element.ccManageName + "'>"
										+ element.ccManageName + "</option>")
								.appendTo("#ccManageName");
					});
		}
	});

	// 查询表单
	this.queryForm = {
		methodName : 'list',
		ccName : null
	};

	this.queryForm = ko.mapping.fromJS(this.queryForm);
	delete this.queryForm.__ko_mapping__;

	// 弹出框的表单
	this.form = {
		methodName : null,
		ccNo : null,
		ccName : null,
		ccRegion : null,
		ccManageName : null,
		ccLevelLabel : null,
		ccSatisfy : null,
		ccCredit : null,
		ccAddress : null,
		ccZip : null,
		ccTel : null,
		ccFax : null,
		ccWebsite : null,
		ccLicenceNo : null,
		ccChieftain : null,
		ccBankroll : null,
		ccTurnover : null,
		ccBank : null,
		ccBankAccount : null,
		ccLocalTaxNo : null,
		ccNationalTaxNo : null,
	};
	this.form = ko.mapping.fromJS(this.form);
	delete this.form.__ko_mapping__;

	// 查找
	this.doQuery = function() {

		console.log("doQuery");

		var f = ko.toJS(_this.queryForm);
		console.log(f);

		$("#dg").datagrid("load", f);
	};

	// 清空
	this.doClear = function() {
		_this.doQuery();
		com.clearForm(_this.queryForm);
	};

	// 修改
	this.doEdit = function() {
		var f = ko.toJS(_this.form);
		console.log(_this.selectRow);
		_this.form.methodName('edit');
		for ( var attribute in _this.form) {
			if (_this.selectRow[attribute]) {
				_this.form[attribute](_this.selectRow[attribute]);
			}
		}

		$("#dd").dialog("open");
	};

	// 删除
	this.dodel = function() {
		$.messager.confirm('确认', '您确定要删除此客户吗？', function(r) {
			if (r) {
				var url = contextPath + "/cust/custCustomerAction_del.action"
				url += "?ccNo=" + ko.toJS(_this.selectRow["ccNo"]);
				$.ajax({
					url : url,
					dataType : 'json',
					success : function(d) {
						if (d && d.code == 0) {
							$.messager.alert('消息', d.message, 'info',
									function() {
										_this.doQuery();
									});
						}
					}
				});
			}
		});
		return false;
	};

	// 联系人
	this.doLinkman = function() {
		location.href = contextPath
				+ "/cust/custLinkmanAction_list2?ClkCustNo="
				+ (_this.selectRow["ccNo"]);
	};

	// 交往记录
	this.doActivities = function() {
		location.href = contextPath
				+ "/cust/custActivityAction_list2?caCustNo="
				+ (_this.selectRow["ccNo"]);
	};

	// 历史订单
	this.doOrders = function() {
		location.href = contextPath
				+ "/basd/basdOrdersAction_list2?boCustomer="
				+ _this.selectRow.ccName;
	};

	// 提交
	this.doSubmit = function() {
		var f = ko.toJS(_this.form);
		$.ajax({
			type : 'post',
			data : _this.form,
			url : contextPath + "/cust/custCustomerAction_" + f.methodName
					+ ".action",
			dataType : 'json',
			success : function(d) {
				$.messager.alert('消息', d.message, 'info', function() {
					if (0 == d.code) {
						$("#dd").dialog("close");
						$('#dg').datagrid("reload");
					}
				});
			}
		});
	};

	// 关闭
	this.doClose = function() {
		$("#dd").dialog("close");
	};

};

function changeState(disabled) {
	if (disabled) {
		$("#editBtn,#delBtn").linkbutton("disable");
	} else {
		$("#editBtn,#delBtn").linkbutton("enable");
	}
};