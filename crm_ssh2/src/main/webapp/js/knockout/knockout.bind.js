/*
 * 创建自定义LinkButton绑定
 * */
ko.bindingHandlers.LinkButton = {
	init : function(element, valueAccessor, allBindingsAccessor, viewModel) {
		//console.log("init");
	},
	update : function(element, valueAccessor, allBindingsAccessor, viewModel) {
		//console.log("update");
		//valueAccessor()可以得到应用到这个绑定的model上的当前属性值
		var value = valueAccessor();//访问器
		//得到的绑定对应的值
		var enableButton = ko.utils.unwrapObservable(value);
		//element是应用绑定的元素
		if (enableButton) {
			$(element).linkbutton({}).linkbutton("enable");
		} else {
			$(element).linkbutton({}).linkbutton("disable");
		}
	}
};

/*
 * 创建自定义datagrid绑定
 * */
ko.bindingHandlers.datagrid = {
	update : function(element, valueAccessor, allBindingsAccessor, viewModel) {
		//valueAccessor()可以得到应用到这个绑定的model上的当前属性值
		var value = valueAccessor();//访问器
		//得到的绑定对应的值
		var options = ko.utils.unwrapObservable(value);
		//console.log(options);
		
		var selectRowIndex = -1;
		var selectRow = null;
		var defaults = {
			fit : true,
			toolbar : "#tb",
			singleSelect : true,
			pagination : true,
			pageList : [ 10, 20, 30, 40, 50 ],
			rownumbers : true,
			pageSize : 10,
			url : null,
			onLoadSuccess : function(data) {
				//changeState(true);
			},
			//在数据表格显示之前触发。
			onBeforeSelect : function(index, row) {
				var _selectedIndex = $(this).attr("_selectedIndex");
				_selectedIndex = _selectedIndex || (_selectedIndex == 0 ? 0 : -1);

				if (selectRowIndex == index) {//需要禁用时
					$(this).datagrid("unselectRow", index);
					selectRowIndex = -1;
					options._onSelect(selectRowIndex,null);
					return false;
				} else {//需要启用时
					selectRowIndex = index;
					options._onSelect(selectRowIndex,row);
				}
			},
			_onSelect:function(index,row){//index是被选中行的下标，
				
			}
		};
		options = $.extend(defaults,options);
		//element是应用绑定的元素
		$(element).datagrid(options);
		
	}
};