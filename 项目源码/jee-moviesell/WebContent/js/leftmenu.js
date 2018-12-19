

function menuOnclick(dId){
		
		
		/* document.getElementById('dd1').style.display=="none";
		document.getElementById('dd2').style.display=="none";
		document.getElementById('dd3').style.display=="none"; */
		
		document.getElementById('dd1').style.display="none";
		document.getElementById('dd2').style.display="none";
		document.getElementById('dd3').style.display="none";
		document.getElementById('dd4').style.display="none";
		
		
		
		
		var dId1=document.getElementById(dId);
		if(dId1.style.display=="none"){
			
			dId1.style.display="block";
		}else{
			dId1.style.display="none";
		}
		
		
	}

