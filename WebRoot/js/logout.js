$(function(){
	
	
	$("#logout").bind("click",function(){
		
		if(confirm("是否退出？")){
			
			window.location="logout.do";
			
			
			
		}else{
			
			window.location="admin.do";
			
		};
		
		
		
	});
	
	
	
	
	
	
	
});