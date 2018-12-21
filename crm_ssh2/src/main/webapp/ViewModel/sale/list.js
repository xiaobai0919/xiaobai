function ViewModelSaleChance(data){
	var _this = this;
	
	//设置原始按钮形态
	this.enableButton = ko.observable(false);
	this.disableButton = ko.observable(true);
	
	this.selectRowIndex = -1;
	this.selectRow = null;
	
	this.selectRows = null;
	
	//datagrid绑定数据
	this.listOptions = {
		url : contextPath+"/sale/saleChanceAction_list.action?str=1",
		_onSelect:function(index,row){
			_this.selectedRowIndex = index;
			_this.selectedRow = row;
			if(index!=-1){
				//用来存放之前选中行的数据
				_this.selectRows = row;
			}
			//等于-1是没选中，不等于则是选中
			_this.enableButton(-1==index?false:true);
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
	
	//新建
	this.doAdd = function(){
		location.href = contextPath+"/sale/add.jsp";
	};
	
	//指派
	this.doZp = function(){
		if(_this.selectedRowIndex!=-1){
			location.href = contextPath+"/sale/saleChanceAction_loadZP.action?scId="+_this.selectRows.scId;
		}
	};
	
	//修改
	this.doEdit = function(){
		if(_this.selectedRowIndex!=-1){
			location.href = contextPath+"/sale/saleChanceAction_loadEdit.action?scId="+_this.selectRows.scId;
		}
	};
	
	//删除
	this.doDel = function(){
		if(_this.selectedRowIndex!=-1){
			//弹出提示框
			$.messager.confirm('确定','你确定要删除吗？',function(r){
				//如果确定，则进行删除操作
				if(r){
					var scId = _this.selectRows.scId;
					$.ajax({
						type:'post',
						url:contextPath+"/sale/saleChanceAction_del.action?scId="+scId,
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
			});
		}
	};
	
	
	
	
	
	
}