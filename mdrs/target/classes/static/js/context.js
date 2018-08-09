/**
 * 在js中获取user.html中的路径； 在spring boot部署到tomcat后或者
 * 在application.properties文件中指定了server.context-path=/的路径；
 * 则必须从后台获取数据必须执行context-path
 * 
 * @returns 返回项目路径
 */
function getContextPath() {
	var pathName = document.location.pathname;
	var index = pathName.substr(1).indexOf("/");
	var result = pathName.substr(0, index + 1);
	return result;
}
var uri=getContextPath();