function ViewModelAdd(){
	
	var _this = this;
	
	var chcId = $("#scId").val();
	//查询的表单
	this.form = {
		scId : chcId,
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
		scDueTo : null,
		scDueDate : null,
		scStatus : null
	}
	this.form = ko.mapping.fromJS(this.form);
	delete this.form.__ko_mapping__;
	
	this.doAdd = function(){
		var f = ko.toJS(_this.form);
		$.ajax({
			type : 'post',
			data : f,
			url : contextPath+"/sale/saleChanceAction_add.action",
			dataType : 'json',
			success : function(str){
				//弹出提示框
				$.messager.alert('消息',str.message,'info',function(){
					location.href = contextPath+"/sale/list.jsp";
				})
			}
		});
	};
	
	
	
	
	
}