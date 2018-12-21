function ViewModel() {
	var self = this;
	
	this.enableButton = ko.observable(false);
	
	this.selectedRowIndex = -1;
	this.selectRow = null;
	
	
	//表格数据绑定
	this.options = {
		url : contextPath + "/right/rightRoleAction_list.action",
		_onSelect : function(index, row) {
			self.selectedRowIndex = index;
			self.selectRow = row;
			self.enableButton(-1 == index ? false : true);
		}
	};
	
	//查询表单
	this.formcx = {
		methodName:'list',
		rrName:'',
		rrDesc:'',
		rrFlag:'3'
	};
	this.formcx = ko.mapping.fromJS(this.formcx);
	delete this.formcx.__ko_mapping__;
	
	//查询
	this.doQuery = function() {
		var f = ko.toJS(self.formcx);
		$("#dg").datagrid("load", f);
	};
	
	// 清空
	this.doClear = function() {
		com.clearForm(self.formcx);
		self.doQuery();
	};
	
	//增加，修改表单
	this.form = {
		methodName:null,
		rrId:null,
		rrName:null,
		rrDesc:null,
		rrFlag:null
	}
	this.form = ko.mapping.fromJS(this.form);
	delete this.form.__ko_mapping__;
	
	// 增加
	this.doAdd = function() {
		com.clearForm(self.form);
		self.form.methodName('add');
		$("#dd").dialog("open");
	};
	// 修改
	this.doEdit = function() {
		if(null!=self.selectRow){
			self.form.methodName('edit');
			for(var attribute in self.form){
				if(self.selectRow[attribute]){
					self.form[attribute](self.selectRow[attribute]);
				}
			}
			$("#dd").dialog("open");
		}
	};
	
	// 查看
	this.dock = function() {
		if(null!=self.selectRow){
			self.form.methodName('ck');
			for(var attribute in self.form){
				if(self.selectRow[attribute]){
					self.form[attribute](self.selectRow[attribute]);
				}
			}
			$("#cc").dialog("open");
		}
	};
	
	//删除
	this.dodel = function() {
		if(null!=self.selectRow){
			$.messager.confirm('确认', '您确定要删除此条记录？', function(r){
				if (r){
					var url =  contextPath + "/right/rightRoleAction_del.action";
					$.ajax({
						url:url,
						dataType:'json',
						data:{rrId:self.selectRow.rrId},
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
		var f = ko.toJS(self.form);
		$.ajax({
			type:'post',
			data:self.form,
			url:contextPath+"/right/rightRoleAction_"+f.methodName+".action",
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
	
	//关闭
	this.doClose = function() {
		com.clearForm(self.form);
		self.form.methodName('add');
		$("#dd").dialog("close");
	};
	
	//关闭
	this.doCloses = function() {
		com.clearForm(self.form);
		$("#cc").dialog("close");
	};
}