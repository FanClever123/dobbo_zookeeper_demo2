//Goodjs文件
layui.use(['table','form','laydate','layer','jquery'], function(){
  var table = layui.table
  ,form = layui.form
  ,laydate = layui.laydate
  ,layer = layui.layer
  ,$ = layui.jquery;

//日期，商品创建时间
laydate.render({
    elem: '#makedate',
    format:'yyyy/MM/dd HH:mm:ss',
	type:'datetime'
});
  
  var currentPage = 1;
  
  //初始化
  loadGood();
  
function loadGood(jsonEntity){
  //方法级渲染
  table.render({
   elem: '#listTable'
   ,url: '/good/listByPramas'
   ,width:1560
   ,height: 480
   ,page:true
   ,even:true
   ,where:jsonEntity
   ,limit:5
   ,limits:[2,3,5,8,10]
   ,cols: [[
     {checkbox: true}
     ,{field:'id', title: 'ID',align:'center', width:80, sort: true}
     ,{field:'gname', title: '商品名称',align:'center', width:160, sort: true}
     ,{field:'price', title: '价格',align:'center', width:160, sort: true}
     ,{field:'makedate', title: '商品创建时间',align:'center', width:160, sort: true}
     ,{field:'tid', title: '商品类型id',align:'center', width:160, sort: true}
     ,{field:'nums', title: '库存量',align:'center', width:160, sort: true}
     ,{field:'sales', title: '销量',align:'center', width:160, sort: true}
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
        jsonEntity['id'] = data.id;
        czGood("/good/delete",jsonEntity,obj);
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
      layer.open({
  		type:1,
  		title:"信息编辑",
  		area:['400px','500px'],
		anim:4,
        shade:0.6,
  		content:$("#updGoodDiv"),
  		success:function(){
        form.val("updGoodForm", {
    "gname": data.gname,
    "price": data.price,
    "makedate": data.makedate,
    "tid": data.tid,
    "nums": data.nums,
    "sales": data.sales,
        });

  		          //监听提交
			  form.on('submit(submitUpdGood)', function(FormData){
			    var jsonEntity = FormData.field
			    jsonEntity.id = data.id;
			    czGood("/good/updT",jsonEntity,obj);
			    layer.closeAll();
			    return false;
			  });
  		}
  	});
    } 
  });

    $("#delBatchGood").click(function(){
      var data = table.checkStatus('listTable').data;
	   if(data.length<1){
          layer.msg("请选择数据！！！",{"icon":3,anim:6,shade:0.6,"time":2000});
	   }else {
           layer.confirm("你确定要删除所选中的数据吗？？？", {icon: 7, title: '提示'}, function (index) {
               var params = "";
               for (var i = 0; i < data.length; i++) {
                   params += data[i].id+ ",";
               }
               delManyGood("/good/deletes", params);
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
  		content:$("#updGoodDiv"),
  		success:function(){
  		   $('form').eq(0).find('input').val('')
  		  //监听提交
		  form.on('submit(submitUpdGood)', function(FormData){
            var jsonEntity = FormData.field
		    czGood("/good/saveT",jsonEntity);
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
  function czGood(url,jsonEntity,obj){
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
                                                                                                                gname: jsonEntity.gname,
                                                                                         price: jsonEntity.price,
                                                                                         makedate: jsonEntity.makedate,
                                                                                         tid: jsonEntity.tid,
                                                                                         nums: jsonEntity.nums,
                                                                                         sales: jsonEntity.sales,
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
  function delManyGood(url,ids){
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
 




