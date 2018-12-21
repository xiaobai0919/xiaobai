function ViewModelBasdStorage(data){
	var _this = this;
	
	this.selectRowIndex = -1;
	this.selectRow = null;
	
	this.selectRows = null;

	//datagrid绑定数据
	this.listOptions = {
		url : contextPath+"/basd/basdStorageAction_list.action",
		_onSelect:function(index,row){
			_this.selectedRowIndex = index;
			_this.selectedRow = row;
		}
	};
	
	//查询的表单
	this.form = {
		methodName : null,
		bdId : null,
		bpName : null,
		bdItem : null,
		bdValue : null,
		bdIsEditable : null,
		bsWarehouse:null
	}
	this.form = ko.mapping.fromJS(this.form);
	delete this.form.__ko_mapping__;
	
	//表单验证
	var rules = {
		scCustName : {
			required : false,
			maxLength : 10,
			minLength : 1
		}
	}
	com.initFormValidate({
		form : _this.form,
		rules : rules
	})
	
	//查询
	this.doQuery = function(){
		if(_this.form.errors().length!=0){//有错误则提示并且不提交
			_this.form.errors.showAllMessages();
			return;
		}
		_this.form.methodName("list");
		var f = ko.toJS(_this.form);
		$("#tab").datagrid("load",f);
	};
	
	//清空
	this.doClear = function(){
		com.clearForm(_this.form);
		this.doQuery();
	};
	
	
	
	
}