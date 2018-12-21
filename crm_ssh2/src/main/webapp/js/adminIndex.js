$(function(){
	$("#tab").tabs({
		fit:true,
		tools:[{
			iconCls:'icon-mini-refresh',
			 handler:function(){    
	        	var tab = $("#tab").tabs("getSelected");
	        	if(tab){
	        		var src = $("iframe",tab).attr("src");
	        		$("iframe",tab).attr("src",src);
	        	}
			 }    
		}]
	});
	
	var url = contextPath+"/right/rightAction_list.action";
	$("#gn").tree({//左侧功能实现
		url:url,
		onBeforeLoad:function(node,param){//在载入请求数据数据之前触发，如果返回false可终止载入数据操作。
			if(node){//为true则载入数据操作
				var defaults = $("#gn").tree("options");	
				var url = contextPath+"/right/rightAction_list.action";
				url+="?rParentCode="+node.id;
				defaults.url = url;
			}
		},
		onSelect : function(node){//选中事件
			var url = node.attributes.url;
			if(url){
				//alert("选中事件："+url);
				//打开界面
				openTab(node.text,contextPath+url);
			}
		}
	});
	
	//打开界面按钮
	function openTab(title,url){
		var b = $("#tab").tabs("exists",title);
		if(b){//有该界面则选中
			$("#tab").tabs("select",title);
		}else{//没有该界面则进行以下操作
			$("#tab").tabs("add",{//添加新界面
				title:title,
				content:'<iframe scrolling="no" frameborder="0" src="'+url+'" width="99%" height="99%"></iframe>',
				closable:true,  
			});
		}
	};
	
	
	
});