function theatreCheck(){
	
	
	var intname=document.getElementById('tname');
	var intaddress=document.getElementById('taddress');
	var inthallnumber=document.getElementById('thallnumber');
	var inttel=document.getElementById('ttel');
	var intaddress=document.getElementById('taddress');
	var intintro=document.getElementById('tintro');
	var intseatnumber=document.getElementById('tseatnumber');
	var intspecialinfo=document.getElementById('tspecialinfo');
	var intparkloc=document.getElementById('tparkloc');
	var intbusinfo=document.getElementById('tbusinfo');
	
	if(intname.value==''||intname.value.length==0){
		alert('电影院的名字为空');
		return false;
	}
	
	
	return true;
	
	
}