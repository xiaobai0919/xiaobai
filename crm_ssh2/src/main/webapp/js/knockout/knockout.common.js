/*
 * knockout自定义公共函数
 */

com = {};

/*
 * 对form进行双向绑定的初始化，props要保留的属性
 * 保留表单中的指定属性，为空则保留所有属性
 * */
//com.toJS = function(form,props){
//	var f = {};
//	form = form || {};
//	props = props || [];
//	
//	if(props.length==0){//初始化所有属性
//		f = ko.toJS(form)
//	}else{
//		for(var i=0;i<props.length;i++){
//			if(form[props[i]]){//props[i]取出属性名，再在form里面找有没有该属性，有则保留
//				f[props[i]] = form[props[i]];
//			}
//		}
//	}
//	return f; 
//};

com.clearForm =  function(form){
	for(var attribute in form){
		console.log(attribute);
		if(attribute=='errors')
			continue;
		form[attribute](null);
	}
};
/**
 * 使用knockout.validation插件对表单元素进行验证，并通过jquery-ui-tooltip插件显示错误消息
 * options.form 要验证的表单元素，调用此方法后，form会多出一个验证属性errors
 * options.rules 要添加的验证规则
 */
com.initFormValidate = function (options) {
    options = options || {};
    var defaults = {form: {}, rules: {}};
    options = $.extend(defaults, options);

    for (var attribute in defaults.rules) {//给指定表单元素添加验证规则
        if (options.form[attribute]) {
        	options.form[attribute] = ko.observable().extend(options.rules[attribute]);
        }
    }
    options.form.errors = ko.validation.group(options.form);//给表单添加一个errors属性
    com.initTooltip();//给表单元素添加tooltip提示功能
};


/**
 * 给表单元素如input/select等添加tooltip提示功能
 * @param options
 */
com.initTooltip = function (options) {
    options = options || {};
    var defaults = {
        targetElement: '.ttip',
        position: {
            my: "left+10 center",
            at: "right center",
            show: {
                effect: "slideDown",
                delay: 250
            },
            hide: {effect: "explode", duration: 1000},
            using: function (position, feedback) {
                $(this).css(position);
                $('<div></div>')
                    .addClass('ui-tooltip-arrow')
                    .addClass(feedback.vertical)
                    .addClass(feedback.horizontal)
                    .appendTo(this);
            }
        }
    };
    defaults = $.extend(defaults, options);

    $(defaults.targetElement).tooltip(defaults);
};