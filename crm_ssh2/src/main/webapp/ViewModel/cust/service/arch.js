function ViewModelArch(data){
	var _this = this;
	
	//设置原始按钮形态
	this.enableButton = ko.observable(false);
	
	this.selectRowIndex = -1;
	this.selectRow = null;
	
	//datagrid绑定数据
	this.listOptions = {
		url : contextPath+"/cust/custServiceAction_list.action",
		_onSelect:function(index,row){
			_this.selectRowIndex = index;
			_this.selectRow = row;
			//等于-1是没选中，不等于则是选中
			_this.enableButton(-1==index?false:true);
		}
	};
	
	//查询的表单
	this.form = {
		methodName : null,
		csId : null,
		csType : null,
		csTitle : null,
		csCustNo : null,
		csCustName : null,
		csStatus : null,
		csRequest : null,
		csCreateId : null,
		csCreateBy : null,
		csCreateDate : null,
		csDueId : null,
		csDueTo : null,
		csDueDate : null,
		csDealBy : null,
		csDealId : null,
		csDeal : null,
		csDealDate : null,
		csResult : null,
		csSatisfy : null
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
		var csType = $("#csType").val();
		if(csType!=-1){
			f.csType = csType;
		}
		//将分配按钮变为不可用
		_this.selectRowIndex = -1;
		_this.enableButton(false);
		$("#tab").datagrid("load",f);
	};
	
	//清空
	this.doClear = function(){
		//将分配按钮变为不可用
		_this.selectRowIndex = -1;
		_this.enableButton(false);
		com.clearForm(_this.form);
		this.doQuery();
	};
	
	//进入单独处理界面
	this.doLook = function(){
		if(_this.selectRowIndex!=-1){
			location.href = contextPath+"/cust/custServiceAction_toCL.action?csId="+_this.selectRow.csId;
		}
	};
	
	
	
	
	
}