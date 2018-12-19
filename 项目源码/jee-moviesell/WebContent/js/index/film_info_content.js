// JavaScript Document


function attachMenu(objid)
{
    var tds=objid.getElementsByTagName('li');
    for(var i=0;i<tds.length;i++)
    {
        with(tds[i])
        {
            onmouseover=function()
            {
                with(this)
                {
                  style.background='#FFFFFF'; //这是鼠标移上去时的背景颜色
                  
                }
            }
            onmouseout=function()
            {
                with(this)
                {
                    style.background='#DEEFF7'; //这是鼠标移上去时的背景颜色
               
                }
            }
        }
    }
}