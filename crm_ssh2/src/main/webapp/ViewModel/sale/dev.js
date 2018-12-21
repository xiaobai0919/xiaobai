function ViewModelSalePlan(){
	var _this = this;
	
	//设置原始按钮形态
	this.enableButton = ko.observable(false);
	this.disableButton = ko.observable(false);
	
	this.selectRowIndex = -1;
	this.selectRow = null;
	
	//再设置一个参数用来判断查看
	
	this.selectRows = null;
	
	//datagrid绑定数据
	this.listOptions = {
		url : contextPath+"/sale/saleChanceAction_list.action?str=0",
		_onSelect:function(index,row){
			_this.selectedRow = row;
			
			if(index!=-1){
				//用来存放之前选中行的数据
				_this.selectRows = row;
			}
			
			//等于-1是没选中，不等于则是选中
			if(-1==index){
				//用来判断状态是开发中还是已归档
				_this.selectedRowIndexa = -1;
				_this.selectedRowIndexb = -1;
				//
				_this.enableButton(false);
				_this.disableButton(false);
				return;
			}
			if("开发中"==row.scStatus){
				_this.selectedRowIndexa = index;
				_this.selectedRowIndexb = -1;
				_this.enableButton(-1==index?false:true);
				_this.disableButton(false);
			}
			if("已归档"==row.scStatus){
				_this.selectedRowIndexa = -1;
				_this.selectedRowIndexb = index;
				_this.disableButton(-1==index?false:true);
				_this.enableButton(false);
			}
		}
	};
	
	//查询的表单
	this.form = {
		methodName : null,
		scId : null,
		scSource : null,
		scCustName : null,
		scTitle : null,
		scRate : null,
		scLinkman : null,
		scTel : null,
		scDesc : null,
		scCreateId : null,
		scCreateBy : null,
		scCreateDate : null,
		scDueId : null,
		scDueTo : null,
		scDueDate : null,
		scStatus : null
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
	
	//制定计划
	this.doZD = function(){
		if(_this.selectedRowIndexa!=-1){
			location.href = contextPath+"/sale/saleChanceAction_loadZD.action?scId="+_this.selectRows.scId;
		}
	};
	
	//执行计划
	this.doZX = function(){
		if(_this.selectedRowIndexa!=-1){
			location.href = contextPath+"/sale/saleChanceAction_loadZX.action?scId="+_this.selectRows.scId;
		}
	};
	
	//开发成功
	this.doWin = function(){
		if(_this.selectedRowIndexa!=-1){
			$.ajax({
				type:'post',
				url:contextPath+"/sale/saleChanceAction_editStatus.action?scId="+_this.selectRows.scId+"&str="+3,
				dataType:'json',
				success : function(str){
					//判断是否删除成功 code等于0证明删除成功，否则相反
					if(str&&str.code==0){
						$.messager.alert('消息',str.message,'info',function(){
							//重载行，刷新当前界面
							$("#tab").datagrid("reload");
						});
					}
				}
			});		
		}
	};
	
	//查看
	this.doLook = function(){
		if(_this.selectedRowIndexb!=-1){
			location.href = contextPath+"/sale/saleChanceAction_Look.action?scId="+_this.selectRows.scId;
		}
	};
	
	
	
};