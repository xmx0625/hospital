<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <meta charset="utf-8">
    <!-- 引入 ECharts 文件 -->
    <script src="${pageContext.request.contextPath }/Js/echarts.min.js"></script>
</head>
<body>
<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    <div id="main" style="width: 600px;height:400px;"></div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/Js/jquery-1.11.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	  	$.ajax({
	  		url:"${pageContext.request.contextPath }/charge/echarts.do",
	  		type:"get",
	  		success:function(msg){
	  			alert(msg);
	  			var myChart = echarts.init(document.getElementById('main'));

	  	        // 指定图表的配置项和数据
	  	        var option = {
	  	            title: {
	  	                text: 'ECharts 入门示例'
	  	            },
	  	            tooltip: {},
	  	            legend: {
	  	                data:['销量']
	  	            },
	  	            xAxis: {
	  	                data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子","lm"]
	  	            },
	  	            yAxis: {},
	  	            series: [{
	  	                name: '销量',
	  	                type: 'bar',
	  	                data: msg
	  	            }]
	  	        };

	  	        // 使用刚指定的配置项和数据显示图表。
	  	        myChart.setOption(option);
	  		}
	  	})
	});
</script>
</html>