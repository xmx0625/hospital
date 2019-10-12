<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	通过new Form表单对象,从表单对象中获得上传的文件对象
	将这个对象通过ajax发送到后台
 -->

<form action="#" id="formId">
	<input type="file" name="img"><br>
	<input type="button" value="上传" onClick="doUpload();">
	<input type="button" value="下载" onClick="doDownload();">
</form>
<input type="hidden" value="" id="i2">
<div>
	<img id="i1" alt="" width="800px" height="450px" src="">
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/Js/jquery.js"></script>
<script type="text/javascript">

	function doUpload() {
		// 创建Form对象对象
		var formData = new FormData($("#formId")[0]);
		// ajax 发送请求,返回图片地址,赋值给img标签
		$.ajax({
			url:"${pageContext.request.contextPath }/FastDFSupload",
			type:"POST",
			data:formData,
			async:false,
			contentType:false,
			processData:false,
			success:function(data) {
				alert(data.obj.path);
				$("#i1").attr("src",data.obj.path);
				$("#i2").val(data.obj.fid);
			}
			
		});
	}
	
	function doDownload() {
		var fid = $("#i2").val();
		window.open("http://localhost:8080/hospital/download?fid="+fid);
	}
</script>
</html>