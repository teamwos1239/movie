


function checkForm(formId){
	
	var forM=document.getElementById(formId);
	if(forM.value==null||forM.value==""){
		alert('图片选择为空！');
		return false;
	}
	
	return true;
	
}