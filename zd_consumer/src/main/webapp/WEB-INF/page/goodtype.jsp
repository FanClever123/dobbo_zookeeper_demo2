<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!doctype html>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<head>
    <base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Goodtype显示页面</title>
    <!--引入layui的样式文件-->
    <link rel="stylesheet" href="static/lib/layui/css/layui.css">
    <!--引入layui的js文件-->
    <script src="static/lib/layui/layui.js"></script>
</head>
<body>

 <!--操作添加修改的div-->
 <div style="display: none;margin-top: 20px;" id="updGoodtypeDiv">
  <form class="layui-form" action="" lay-filter="updGoodtypeForm">
                  <div class="layui-form-item">
	    <div class="layui-inline">
	      <label class="layui-form-label">类型名称</label>
	      <div class="layui-input-inline">
	        <input type="text" name="tname" lay-verify="required" autocomplete="off" placeholder="请输入类型名称"  class="layui-input" id="tname">
	      </div>
	    </div>
	   </div>
		                 <div class="layui-form-item">
	    <div class="layui-inline">
	      <label class="layui-form-label">类型简介</label>
	      <div class="layui-input-inline">
	        <input type="text" name="tdesc" lay-verify="required" autocomplete="off" placeholder="请输入类型简介"  class="layui-input" id="tdesc">
	      </div>
	    </div>
	   </div>
		       <div class="layui-form-item">
	    <div class="layui-input-block">
	      <button class="layui-btn" lay-submit="" lay-filter="submitUpdGoodtype">立即提交</button>
	      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
	    </div>
      </div>
    </form>
   </div>
   
 <div style="margin: 20px;">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
        <legend>Goodtype显示页面</legend>
    </fieldset>
    <div class="layui-btn-group listTable">
	  <button class="layui-btn" id="flush"><i class="layui-icon">&#x1002;</i>刷新</button> 
	</div> 
	<div class="layui-btn-group listTable">  
	  <button class="layui-btn layui-btn-danger" id="delBatchGoodtype"><i class="layui-icon">&#xe640;</i>批量删除</button>
	</div>
	<div class="layui-btn-group listTable">  
	  <button class="layui-btn layui-btn-small layui-btn-normal" id="saveUI"><i class="layui-icon">&#xe608;</i>增加</button>
	</div>
	<table class="layui-table" id="listTable" lay-filter="list"></table>
	<script type="text/html" id="bar">
 	  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="show" ><i class="layui-icon">&#xe609;</i>查看</a>
 	  <a class="layui-btn layui-btn-xs" lay-event="edit" ><i class="layui-icon">&#xe642;</i>修改</a>
 	  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" ><i class="layui-icon">&#xe640;</i>删除</a>
	</script>
</div>
	 
 <script src="static/js/goodtype.js"></script>
</body>
</html>

 