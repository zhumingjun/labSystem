<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>		

<!-- 增加学生界面 -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/button.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/addEditView.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/webuploader/webuploader.css" />

<script>
	console.info("${pageContext.request.contextPath}");
	var BASE_URL='${pageContext.request.contextPath}/teacher/';
</script>

<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>
<script src="${pageContext.request.contextPath}/resources/layer/layer.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/datePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/validform/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/validform.js"></script>
 <script src="${pageContext.request.contextPath}/resources/plugins/webuploader/webuploader.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/webuploader/csystem/userInfoHeadUpload.js"></script>


<style>
	.add_pic{
	    width: 140px;
	    height: 150px;
	    border: 1px dashed #ccc;
	    float: right;
	    margin-right: 10px;
	}
	.filePicker {
		float:left;
	    margin-left: 60px;
	    margin-top: 60px;
	}
	
</style>

<form id="studentFormId" modelAttribute="domain" action="${pageContext.request.contextPath}/teacher/student/save" method="post">
		<input type="hidden" id="gradeId" name="grade" value=""/>
		<input type="hidden" id="tutorId" name="tutorDomain.id" value=""/>
		<input type="hidden" id="restutorId" name="restutorDomain.id" value=""/>
	<table>	
		<tr>
			<td class="lesta-150">学号：</td>
			<td class="lestb">
				<input type="text" id="stuCode" name="stuCode" class="input_text_a" placeholder="请输入学号">
			</td>
			<td>
				<input type="hidden" id="headImg" name="headImg" value=""/>
				<div id="filePicker" class="filePicker">选择图片</div>
				<div class="add_pic" id="add_pic">
					<img id="head_img" src="${pageContext.request.contextPath}/resources/images/touxiang.png" width="140px;" height="150px;" style="border-radius:5px;"/>
				</div>
			</td>
		</tr>
		<tr>
			<td class="lesta-150">姓名：</td>
			<td class="lestb">
				<input type="text" id="stuname" name="name" class="input_text_a" placeholder="请输入姓名">
			</td>
			<td class="lesta-150">是否毕业：</td>
			<td class="lestb">
				<input type="radio" name="isGraduate" value="0" checked="checked"/>未毕业
				<input type="radio" name="isGraduate" value="1" />已毕业
			</td>
		</tr>
		<tr>
		    <td class="lesta-150">性别：</td>
			<td class="lestb">
				<input type="radio" name="sex" value="0" checked="checked"/>男
				<input type="radio" name="sex" value="1" />女
			</td>
		</tr>
		<tr>
			<td class="lesta-150">导师：</td>
			<td class="lestb">
				<select id="tutor_select_add_id" class="select_style">
					<option value="" selected="selected">选择</option>
					<c:forEach items="${teachers }" var="teachersDomain">
						<option value="${teachersDomain.id }">${teachersDomain.name}</option>
					</c:forEach>
				</select>
			</td>
			<td class="lesta-150">责任导师：</td>
			<td class="lestb">
				<select id="restutor_select_add_id" class="select_style">
					<option value="" selected="selected">选择</option>
					<c:forEach items="${teachers }" var="teachersDomain">
						<option value="${teachersDomain.id }">${teachersDomain.name}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td class="lesta-150">出生日期：</td>
			<td class="lestb">
				<input type="text" name="birthday" class="Wdate" readonly="readonly" placeholder="出生日期" onfocus="WdatePicker({maxDate:'%y-%M-%d'})" style="width: 150px;height: 30px;cursor: pointer;"/> 
			</td>

		</tr>
		<tr>
			<td class="lesta-150">研究生年级：</td>
			<td class="lestb">
				<select id="grade_select_add_id" class="select_style">
					<option value="" selected="selected">选择</option>
					<c:forEach items="${gradeItem }" var="gradedomain">
						<option value="${gradedomain.value }">${gradedomain.name}</option>
					</c:forEach>
				</select>
			</td>
			<td class="lesta-150">手机号码：</td>
			<td class="lestb">
				<input type="text" id="studentphoneNumber" name="phoneNumber" class="input_text_a" ignore="ignore" placeholder="请输入手机号码" />
			</td>
		</tr>
		<tr>
			<td class="lesta-150">银行卡号：</td>
			<td class="lestb">
				<input type="text" id="bankCard" name="bankCard" class="input_text_a" ignore="ignore" placeholder="请输入财务账号"/>
			</td>
			<td class="lesta-150">邮箱：</td>
			<td class="lestb">
				<input type="text" id="studentemail" name="email" class="input_text_a" ignore="ignore" placeholder="请输入邮箱"/>
			</td>
		</tr>
		<tr>
			<td class="lesta-150">身份证：</td>
			<td class="lestb">
				<input type="text" id="studentidNumber" name="idNumber" class="input_text_a" placeholder="请输入身份证号" />
			</td>
		</tr>
		<tr>
			<td class="lesta-150">家庭住址：</td>
			<td class="lestb">
				<input type="text" id="studenthomeAddress" name="homeAddress" class="input_text_a" placeholder="请输入家庭住址" />
			</td>
			<td class="lesta-150">入学年份：</td>
			<td class="lestb">
				<input type="text" id="entryYear" name="entryYear" class="input_text_a" placeholder="请输入入职年份" />
			</td>
		</tr> 
		<tr>
			<td class="lesta-150">家庭联系人：</td>
			<td class="lestb">
				<input type="text" id="contactPerson" name="contactPerson" class="input_text_a" placeholder="请输入家庭联系人" />
			</td>
			<td class="lesta-150">家庭联系方式：</td>
			<td class="lestb">
				<input type="text" id="familyContact" name="familyContact" class="input_text_a" placeholder="请输入家庭联系方式" />
			</td>
		</tr> 
	</table>
	<input id="saveButton" type="button" class="button button-highlight button-rounded button-small" style="margin-top:20px; margin-left: 300px;" value="确定"/>
</form>

<script>






	//表单验证
	$.Tipmsg.r=null;
	
	var showmsg=function(msg,obj){
		console.info(msg); 
		layer.tips(msg, obj);
	};
	
	$("#studentFormId").Validform({
		tiptype:function(msg,o){
			console.info(msg); 
			showmsg(msg,o.obj[0]);
		}
	}); 


	//下拉框选择后给隐藏域赋值
	$("#grade_select_add_id").change(function(){
		var grade_id=$(this).children('option:selected').val();
		$("#gradeId").val(grade_id);
	});
	

	//下拉框选择后给隐藏域赋值
	$("#tutor_select_add_id").change(function(){
		var tutor_id=$(this).children('option:selected').val();
		$("#tutorId").val(tutor_id);
	});
	

	//下拉框选择后给隐藏域赋值
	$("#restutor_select_add_id").change(function(){
		var restutor_id=$(this).children('option:selected').val();
		$("#restutorId").val(restutor_id);
	});
	
	
	

</script>