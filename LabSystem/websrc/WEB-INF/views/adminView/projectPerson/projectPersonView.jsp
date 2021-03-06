<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.lab.lsystem.util.*"%>

<!-- 增加学生界面 -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@	taglib uri="/csystem-taglib" prefix="cusfun"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/button.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/addEditView.css" />
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/layer/layer.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/plugins/datePicker/WdatePicker.js"></script>

<style>
.add_pic {
	width: 140px;
	height: 150px;
	border: 1px dashed #ccc;
	float: right;
	margin-right: 10px;
}

.filePicker {
	float: left;
	margin-left: 60px;
	margin-top: 60px;
}
</style>

<table>
	<tr>
		<td class="lesta-150">参与人员顺序：</td>
		<td class="lestb"><input type="text" id="personOrder"
			name="personOrder" class="input_text_a" value="${projectPersonDomain.personOrder }"/>
		</td>
	</tr>
	<tr>
		<td class="lesta-150">参与人员编号：</td>
		<td class="lestb"><input type="text" id="personCode"
			name="personCode" class="input_text_a" value="${projectPersonDomain.personCode}"/>
		</td>
		<td class="lesta-150">作者姓名：</td>
		<td class="lestb"><input type="text" id="personName"
			name="personName" class="input_text_a" value="${projectPersonDomain.personName }" /></td>
	</tr>
</table>

<input id="closeButton" type="button"
	class="button button-highlight button-rounded button-small"
	style="margin-top:20px; margin-left: 300px;" value="关闭" />

<script>
	$("#closeButton").click(function() {
		//关闭当前页面
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭     
	});
</script>