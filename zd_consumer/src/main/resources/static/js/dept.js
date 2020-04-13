//Deptjs文件
layui.use(['table','form','laydate','layer','jquery'], function(){
  var table = layui.table
  ,form = layui.form
  ,laydate = layui.laydate
  ,layer = layui.layer
  ,$ = layui.jquery;

  
  var currentPage = 1;
  
  //初始化
  loadDept();
  
function loadDept(jsonEntity){
  //方法级渲染
  table.render({
   elem: '#listTable'
   ,url: '/dept/listByPramas'
   ,width:1560
   ,height: 480
   ,page:true
   ,even:true
   ,where:jsonEntity
   ,limit:5
   ,limits:[2,3,5,8,10]
   ,cols: [[
     {checkbox: true}
     ,{field:'deptno', title: 'ID',align:'center', width:80, sort: true}
     ,{field:'dname', title: '部门名称',align:'center', width:160, sort: true}
     ,{field:'loc', title: '部门地址',align:'center', width:160, sort: true}
	  ,{fixed: 'right',title: '操作', width:256, align:'center', toolbar: '#bar'}
    ]] 
    ,done: function(res, curr, count){
    	currentPage = curr; 
	  }
  });
  }
  
  //监听工具条
  table.on('tool(list)', function(obj){
    var data = obj.data;
    if(obj.event === 'show'){
    	layer.alert('查看行：<br>'+ JSON.stringify(data))
    } else if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        var jsonEntity = {};
        jsonEntity['deptno'] = data.deptno;
        czDept("/dept/delete",jsonEntity,obj);
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
      layer.open({
  		type:1,
  		title:"信息编辑",
  		area:['400px','500px'],
		anim:4,
        shade:0.6,
  		content:$("#updDeptDiv"),
  		success:function(){
        form.val("updDeptForm", {
    "dname": data.dname,
    "loc": data.loc,
        });

  		          //监听提交
			  form.on('submit(submitUpdDept)', function(FormData){
			    var jsonEntity = FormData.field
			    jsonEntity.deptno = data.deptno;
			    czDept("/dept/updT",jsonEntity,obj);
			    layer.closeAll();
			    return false;
			  });
  		}
  	});
    } 
  });

    $("#delBatchDept").click(function(){
      var data = table.checkStatus('listTable').data;
	   if(data.length<1){
          layer.msg("请选择数据！！！",{"icon":3,anim:6,shade:0.6,"time":2000});
	   }else {
           layer.confirm("你确定要删除所选中的数据吗？？？", {icon: 7, title: '提示'}, function (index) {
               var params = "";
               for (var i = 0; i < data.length; i++) {
                   params += data[i].deptno+ ",";
               }
               delManyDept("/dept/deletes", params);
               flush(currentPage);
               layer.close(index);
           });
       }
    });
  

  
  //刷新
  $("#flush").click(function(){
	  flush(currentPage);
  });
  
  //添加
  $("#saveUI").click(function(){
	  layer.open({
  		type:1,
  		title:"添加页面",
  		area:['600px','500px'],
	    anim:4,
	    shade:0.6,
  		content:$("#updDeptDiv"),
  		success:function(){
  		   $('form').eq(0).find('input').val('')
  		  //监听提交
		  form.on('submit(submitUpdDept)', function(FormData){
            var jsonEntity = FormData.field
		    czDept("/dept/saveT",jsonEntity);
		    layer.closeAll();
		    return false;
		  });
  		}
  	});
  });
  
  function flush(currentPage){
	  table.reload('listTable', {
	        page: {
	          curr: currentPage 
	        }
	     });
  }
  
  //普通增删改操作
  function czDept(url,jsonEntity,obj){
	  $.ajax({
		   	type:"post",
		   	url:url,
		   	data:jsonEntity,
		   	success:function(data){
		   		if(data=="delSuccess"){
	   				layer.msg("删除单个成功。。。",{"icon":6,anim:4,shade:0.6,"time":2000});
		   		    obj.del();
		   		}else if(data=="updSuccess"){
	   				layer.msg("信息修改成功。。。",{"icon":6,anim:4,shade:0.6,"time":2000});
		   			 obj.update({
                                                                                                                dname: jsonEntity.dname,
                                                                                         loc: jsonEntity.loc,
                                           		   	      });
		   		}else if(data=="saveSuccess"){
		   		    layer.msg("数据添加改成功。。。",{"icon":6,anim:4,shade:0.6,"time":2000});
		   		    flush(1);
		   		}else{
		   			layer.msg("操作失败！！！",{"icon":2,anim:4,shade:0.6,"time":2000});
		   		}	
		   	},
		   	error:function(){
		   		layer.msg("操作异常！！！",{"icon":3,anim:6,shade:0.6,"time":2000});
		   	}
	   });
  }
  
  //批量删除
  function delManyDept(url,ids){
	  $.ajax({
			type:"post",
			url:url,
			data:{'ids':ids},
			success:function(data){
				if(data=="delSuccess"){
					layer.msg("批量删除数据成功。。",{"icon":6,anim:4,shade:0.6,"time":2000});
					 flush(currentPage);
				}else{
					layer.msg("批量删除数据失败！！",{"icon":2,anim:4,shade:0.6,"time":2000});
				}
			},
			error:function(){
				layer.msg("对不起，服务器异常！！！",{"icon":3,anim:6,shade:0.6,"time":2000});
			}
		});
  }
});
 




