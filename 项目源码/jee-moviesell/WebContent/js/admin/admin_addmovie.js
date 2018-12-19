function movieCheck(){
	
	var inmname=document.getElementById('mname').value;
	var inmtype=document.getElementById('mtype').value;
	var inmstarttime=document.getElementById('mstarttime').value;
	var inmendtime=document.getElementById('mendtime').value;
	var inmdirector=document.getElementById('mdirector').value;
	var inmroles=document.getElementById('mroles').value;
	var inmcountry=document.getElementById('mcountry').value;
	var inmlength=document.getElementById('mlength').value;
	var inminformation=document.getElementById('minformation').value;
	var inmlikerate=document.getElementById('mlikerate').value;
	var inmpicpath=document.getElementById('mpicpath').value;
	var inmspecial=document.getElementById('mspecial').value;
	
	if(inmname.length==0||inmname==''){
		alert('电影名为空');
		return false;
	}
	
	
	if(inmtype.length==0||inmtype==''){
		alert('电影类型为空');
		return false;
	}
	
	
	if(inmstarttime.length==0||inmstarttime==''){
		alert('电影上映时间为空');
		return false;
	}
	
	
	if(inmdirector.length==0||inmdirector==''){
		alert('导演为空');
		return false;
	}
	
	
	if(inmroles.length==0||inmroles==''){
		alert('主演为空');
		return false;
	}
	
	
	if(inmcountry.length==0||inmcountry==''){
		alert('国家为空');
		return false;
	}
	
	
	if(inmlength.length==0||inmlength==''){
		alert('电影片长为空');
		return false;
	}
	
	
	
	if(inminformation.length==0||inminformation==''){
		alert('电影剧情为空');
		return false;
	}
	
	
	
	if(inmlikerate.length==0||inmlikerate==''){
		alert('喜欢率为空');
		return false;
	}
	
	
	
	if(inmpicpath.length==0||inmpicpath==''){
		alert('图片路径为空');
		return false;
	}
	
	
	if(inmspecial.length==0||inmspecial==''){
		alert('电影特色为空');
		return false;
	}
	
	
	
	return true;
	
	
	
	
	
	
	
	
}