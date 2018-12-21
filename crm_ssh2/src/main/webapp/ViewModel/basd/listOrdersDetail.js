/**
 * 定义vm模型
 * 
 * @returns
 */
function ViewModel(data) {
	
	var biId = $('#boID').val();
	
	var _this = this;

	this.enableButton = ko.observable(false);

	this.selectedRowIndex = -1;

	this.selectRow = null;
	this.options = {
		url : contextPath + "/basd/ordersDetailAction_list.action?boId="+biId,
		_onSelect : function(index, row) {
			_this.selectedRowIndex = index;
			_this.selectRow = row;
			_this.enableButton(-1 != index ? true : false);
		}
	};
	// 查询表单
	this.queryForm = {
		methodName : 'list',
		boCustomer : null	
	};

	this.queryForm = ko.mapping.fromJS(this.queryForm);
	delete this.queryForm.__ko_mapping__;

	// 查找
	this.doQuery = function() {

		console.log("doQuery");

		var f = ko.toJS(_this.queryForm);
		console.log(f);

		$("#dg").datagrid("load", f);
	};

	// 关闭
	this.doClose = function() {
		com.clearForm (_this.form);
		_this.form.methodName('add');
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