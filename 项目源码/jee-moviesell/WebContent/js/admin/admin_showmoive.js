
function seatclick(imgId,valueId, i, j) {

	var imgBtn = document.getElementById(imgId);
	var valueInput=document.getElementById(valueId);

	
	if(imgBtn.className=='seat_img'){
		imgBtn.className='seat_img3';
		valueInput.value="0";
	}else{
		imgBtn.className='seat_img';
		valueInput.value="2";
	}
	
	
}

function setSeat(){
	var seat=document.getElementsByName("value_1");
	var str="";
	for(var i=0;i<seat.length;i++){
		str=str+seat[i].value+"-";
	}
	str=str.substring(0, str.length-1);
	document.getElementById("sseatsatust1").value=str;
	
	//-----/
	seat=document.getElementsByName("value_2");
	str="";
	for(var i=0;i<seat.length;i++){
		str=str+seat[i].value+"-";
	}
	str=str.substring(0, str.length-1);
	document.getElementById("sseatsatust2").value=str;

	//-----/
	seat=document.getElementsByName("value_3");
	str="";
	for(var i=0;i<seat.length;i++){
		str=str+seat[i].value+"-";
	}
	str=str.substring(0, str.length-1);
	document.getElementById("sseatsatust3").value=str;

	//-----/
	seat=document.getElementsByName("value_4");
	str="";
	for(var i=0;i<seat.length;i++){
		str=str+seat[i].value+"-";
	}
	str=str.substring(0, str.length-1);
	document.getElementById("sseatsatust4").value=str;

	//-----/
	seat=document.getElementsByName("value_5");
	str="";
	for(var i=0;i<seat.length;i++){
		str=str+seat[i].value+"-";
	}
	str=str.substring(0, str.length-1);
	document.getElementById("sseatsatust5").value=str;

	//-----/
	seat=document.getElementsByName("value_6");
	str="";
	for(var i=0;i<seat.length;i++){
		str=str+seat[i].value+"-";
	}
	str=str.substring(0, str.length-1);
	document.getElementById("sseatsatust6").value=str;

	//-----/
	seat=document.getElementsByName("value_7");
	str="";
	for(var i=0;i<seat.length;i++){
		str=str+seat[i].value+"-";
	}
	str=str.substring(0, str.length-1);
	document.getElementById("sseatsatust7").value=str;

	//-----/
	seat=document.getElementsByName("value_8");
	str="";
	for(var i=0;i<seat.length;i++){
		str=str+seat[i].value+"-";
	}
	str=str.substring(0, str.length-1);
	document.getElementById("sseatsatust8").value=str;
	
	//-----/
	seat=document.getElementsByName("value_9");
	str="";
	for(var i=0;i<seat.length;i++){
		str=str+seat[i].value+"-";
	}
	str=str.substring(0, str.length-1);
	document.getElementById("sseatsatust9").value=str;
	
}

function checkSub(){
	if(document.getElementById("sseatsatust8").value==""){
		
		alert("座位还未确定");
		return false;
	}else{
		return true;
	}
	
}
