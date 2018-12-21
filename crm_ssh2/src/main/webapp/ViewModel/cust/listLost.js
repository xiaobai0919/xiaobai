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
		url : contextPath + "/cust/custLostAction_list.action",
		_onSelect : function(index, row) {
			_this.selectedRowIndex = index;
			_this.selectRow = row;
			_this.enableButton(-1 != index ? true : false);
		}
	};
	// 查询表单
	this.queryForm = {
		methodName : 'list',
		clCustName : null
	};

	this.queryForm = ko.mapping.fromJS(this.queryForm);
	delete this.queryForm.__ko_mapping__;

	// 弹出框的表单
	this.form = {
		methodName : null,
		clId : null,
		clCustName : null,
		clCustManagerName : null,
		clLastOrderDate : null,
		clDelay : null,
		clReason : null,
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

	// 确认流失
	this.doSure = function() {
		com.clearForm(_this.form);
		_this.form.methodName('edit3');
		for ( var attribute in _this.form) {
			if (_this.selectRow[attribute]) {
				_this.form[attribute](_this.selectRow[attribute]);
			}
		}

		$("#dd").dialog("open");
	};
	
	//暂缓流失
	this.doLow = function() {
		com.clearForm(_this.form);
		_this.form.methodName('edit');
		for ( var attribute in _this.form) {
			if (_this.selectRow[attribute]) {
				_this.form[attribute](_this.selectRow[attribute]);
			}
		}

		$("#dd").dialog("open");
	};
	
	//提交
	this.doSubmit = function() {
		var f = ko.toJS(_this.form);
		$.ajax({
			type:'post',
			data:_this.form,
			url:contextPath+"/cust/custLostAction_"+f.methodName+".action",
			dataType:'json',
			success:function(d){
				$.messager.alert('消息',d.message,'info',function(){
					if(0==d.code){
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