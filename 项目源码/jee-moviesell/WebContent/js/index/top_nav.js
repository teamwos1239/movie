// JavaScript Document
 

function attachXMenu(objid)
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
                    style.background='#41A0CC'; //这是鼠标移上去时的背景颜色
                  
                }
            }
            onmouseout=function()
            {
                with(this)
                {
                    style.background='#5EB7E2'; //这是鼠标离开时的背景颜色
               
                }
            }
        }
    }
}
