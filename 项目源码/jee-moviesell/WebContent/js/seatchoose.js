// JavaScript Document

function seatclick(imgId, i, j) {

	/*
	 * if(document.getElementById(imgId).style.backgroundImage!=null)
	 * document.getElementById(imgId).style.backgroundImage="url(../pic/chooseseats/sit_div_img1.jpg)";
	 * 
	 * else
	 */
	// if(1==1){
	// }
	var msgDiv = document.getElementById("msgs");
	if (msgDiv.getElementsByTagName('button').length <= 5) {
	
		var imgBtn = document.getElementById(imgId);
		imgBtn.style.backgroundImage = "url(/jee-moviesell/pic/chooseseats/sit_div_img3.jpg)";
		imgBtn.onclick="";
		imgBtn.removeAttribute("onclick");
		imgBtn.style.cursor="default";

		var newnode1 = document.createElement("button");
		newnode1.innerHTML = "您选择了：第" + i + "排  " + j + "号座";
//		alert( "您选择了：第" + i + "排  " + j + "号座");
		newnode1.value = i + "-" + j;
		newnode1.name = "seatchosen";
		msgDiv.appendChild(newnode1);
		document.getElementById("seatCount").value=msgDiv.getElementsByTagName('button').length+1 ;
	} else {
		alert("你最多只能选择六个座位");
	}

}
function productjia(pId) {

	var x = document.getElementById(pId).value;
	x = parseInt(x);

	document.getElementById(pId).value = x + 1;

}

function productjian(pId) {
	var x = document.getElementById(pId).value;
	x = parseInt(x);
	if (x==0) {
		alert("个数已经为最少");
	} else {
		document.getElementById(pId).value = x - 1;
	}
}

function sub(Insno){
	
	if(document.getElementById("seatCount").value==0){
		alert('您还未选择座位');
	}else{
		var sno=Insno;
		var btnArray=document.getElementById("msgs").getElementsByTagName('button');
		var seatString="";
		for ( var int = 0; int < btnArray.length; int++) {
			seatString=seatString+btnArray[int].value+",";
		}
		seatString=seatString.substring(0, seatString.length-1);
		
		var oquantity1=document.getElementById("oquantity1").value;
		var oquantity2=document.getElementById("oquantity2").value;
		
		location='/jee-moviesell/CreateOrderServlet?sno='+sno+'&&seatString='+seatString+'&&oquantity1='+oquantity1+'&&oquantity2='+oquantity2;
	}
}

