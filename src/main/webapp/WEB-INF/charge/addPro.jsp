<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加收费项目-- -2015</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="../Css/style.css" />
    <script type="text/javascript" src="../Js/jquery.js"></script>
    <script type="text/javascript" src="../Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="../Js/bootstrap.js"></script>
    <script type="text/javascript" src="../Js/ckform.js"></script>
    <script type="text/javascript" src="../Js/common.js"></script>
    <script type="text/javascript" src="../Js/ckeditor/ckeditor.js"></script>
 


    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }


        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }




    </style>
    <script type="text/javascript">
    $(function () {       
		$('#backid').click(function(){
				window.location.href="${pageContext.request.contextPath}/charge/list";
		 });
    });
    </script>
</head>
<body>
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">病历号</td>
        <td>
	<form action="${pageContext.request.contextPath}/charge/find" >
        <input type="text" name="id" value="${reg.medical_record}"/>
        <input type="hidden" name="charge_item_name" value="${pay.charge_item_name}"/>
    </form>  
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">姓名</td>
        <td>${reg.name}</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">收费项目</td>
        <td>
	<form action="${pageContext.request.contextPath}/charge/find" >
        <input type="hidden" name="id" value="${reg.medical_record}"/>
        <input type="text" name="charge_item_name" value="${pay.charge_item_name}"/>
    </form>  
        输入自动匹配出来</td>
    </tr>
	<form action="${pageContext.request.contextPath}/charge/addPro" method="post" class="definewidth m20">
    <tr>
        <td width="10%" class="tableleft">收费金额</td>
        	<input type="hidden" name="medical_record" value="${reg.medical_record}"/>
        	<input type="hidden" name="charge_item_name" value="${pay.charge_item_name}"/>
        <td><input type="text" name="charge_money" value="${pay.receivable_money}"/></td>
    </tr>
    <tr>
        <td colspan="2">
			<center>
				<button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
			</center>
		</td>
    </tr>
	</form>
</table>
                                                                                            
</body>
</html>