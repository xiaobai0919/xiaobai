function ViewModel() {
	var self = this;
	
	this.enableButton = ko.observable(false);
	
	this.selectedRowIndex = -1;
	this.selectRow = null;
	
	//表格数据绑定
	this.options = {
		url : contextPath + "/right/rightAction_lists.action",
		_onSelect : function(index, row) {
			self.selectedRowIndex = index;
			self.selectRow = row;
			self.enableButton(-1 == index ? false : true);
		}
	};
	
	//查询表单
	this.formcx = {
		methodName:'lists',
		rText:'',
		rTip:''
	};
	this.formcx = ko.mapping.fromJS(this.formcx);
	delete this.formcx.__ko_mapping__;
	
	//查询
	this.doQuery = function() {
		var f = ko.toJS(self.formcx);
		console.log(f);
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
		rCode:null,
		rParentCode:null,
		rType:null,
		rText:null,
		rUrl:null,
		rTip:null,
	}
	this.form = ko.mapping.fromJS(this.form);
	delete this.form.__ko_mapping__;
	
	// 增加
	this.doAdd = function() {
		com.clearForm(self.form);
		self.form.methodName('add');
		$("#rCode").removeAttr("disabled");
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
			$("#rCode").attr("disabled","disabled");
			$("#dd").dialog("open");
		}
	};
	
	//删除
	this.dodel = function() {
		if(null!=self.selectRow){
			$.messager.confirm('确认', '您确定要删除此条记录？', function(r){
				if (r){
					var url =  contextPath + "/right/rightAction_del.action";
					$.ajax({
						url:url,
						dataType:'json',
						data:{rCode:self.selectRow.rCode},
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
		alert(f.methodName);
		$.ajax({
			type:'post',
			data:self.form,
			url:contextPath+"/right/rightAction_"+f.methodName+".action",
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
}