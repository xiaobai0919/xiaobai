/**
 * 对knockout.validation插件进行初始化
 */
$.extend(ko.validation.configuration, {
    decorateElement: true,
    registerExtenders: true,
    messagesOnModified: true,
    insertMessages: false,
    parseInputAttributes: false,
    messageTemplate: null,
    errorElementClass: 'error'
});
ko.validation.locale('zh-CN');//引入中文语言包