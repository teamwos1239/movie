// JavaScript Document


function attachSetMenu(objid)
{
    var tds=objid.getElementsByTagName('dd');
    for(var i=0;i<tds.length;i++)
    {
        with(tds[i])
        {
            onmouseover=function()
            {
                with(this)
                {
                  className="set_on";
                  
                }
            }
            onmouseout=function()
            {
                with(this)
                {
                   className="";
               
                }
            }
        }
    }
}