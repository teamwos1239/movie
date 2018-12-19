// JavaScript Document


function attachChoose(objid)
{
    var tds=objid.getElementsByTagName('a');
    for(var i=0;i<tds.length;i++)
    {
        with(tds[i])
        {
            onmouseover=function()
            {
                with(this)
                {
                  
				  style.border="1px #BAB9B9 solid";
                }
            }
            onmouseout=function()
            {
                with(this)
                {	 
               		style.border="1px #fff solid";
                }
            }
        }
    }
}
 


function onclickSelect(selectValue,sId){
	
	document.getElementById(sId).value=selectValue;
	goFind();
}


function goFind(){
	var cno=document.getElementById('selectedCno').value;
	var tno=document.getElementById('selectedTno').value;
	var mno=document.getElementById('selectedMno').value;
	var stimeFlag=document.getElementById('stimeSelected').value;
	var selectedDayTime=document.getElementById('selectedDayTime').value;
	var versionFlag=document.getElementById('selectedVersion').value;
	
	
	url='/jee-moviesell/FindShowmoiveItemByCondtionServlet?cno='+cno+"&&tno="+tno+"&&mno="+mno+"&&stimeFlag="+stimeFlag+"&&selectedDayTime="+selectedDayTime+"&&versionFlag="+versionFlag;
	//alert('url======'+url);
	location=url;
	
	
}



