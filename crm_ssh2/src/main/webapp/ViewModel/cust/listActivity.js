/**
 * 定义vm模型
 * 
 * @returns
 */
function ViewModel(data) {
	
	var ccno = $('#ccno').val();
	var ccname = $('#ccname').val();
	
	var _this = this;

	this.enableButton = ko.observable(false);

	this.selectedRowIndex = -1;

	this.selectRow = null;
	this.options = {
		url : contextPath + "/cust/custActivityAction_list.action?caCustNo="+ccno,
		_onSelect : function(index, row) {
			_this.selectedRowIndex = index;
			_this.selectRow = row;
			_this.enableButton(-1 != index ? true : false);
		}
	};
	// 查询表单
	this.queryForm = {
		methodName : 'list',
		CaCustName : null	
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
	
	// 弹出框的表单
	this.form = {
		methodName : null,
		caID : null,
		caCustNo : null,
		caCustName : null,
		caDate : null,
		caPlace : null,
		caTitle : null,
		caRemark : null,
		caDesc : null,
	};
	this.form = ko.mapping.fromJS(this.form);
	delete this.form.__ko_mapping__;

	//新增
	this.doAdd = function() {
		com.clearForm(_this.form);
		_this.form.methodName('add');
		_this.form.caCustNo(ccno);
		_this.form.caCustName(ccname);
		$("#dd").dialog("open");
	};
	
	// 修改
	this.doEdit = function() {
		com.clearForm(_this.form);
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
		if(null!=_this.selectRow){
			$.messager.confirm('确认', '您确定要删除此条记录？', function(r) {
				if (r) {
					var url = contextPath + "/cust/custActivityAction_del.action"
					$.ajax({
						url : url,
						dataType : 'json',
						data:{ caID:_this.selectRow.caID},
						success:function(d){
							if(d&&d.code==0){
								$.messager.alert('消息',d.message,'info',function(){
									$('#dg').datagrid("reload");
								});
							}
						}
					});
				}
			});
			return false;
		}
	};

	//提交
	this.doSubmit = function() {
		var f = ko.toJS(_this.form);
		console.log(f);
		$.ajax({
			type:'post',
			data:_this.form,
			url:contextPath+"/cust/custActivityAction_"+f.methodName+".action",
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