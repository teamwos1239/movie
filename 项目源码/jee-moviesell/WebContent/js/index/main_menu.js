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
                  className="on";
                  
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