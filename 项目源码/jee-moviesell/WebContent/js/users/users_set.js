// JavaScript Document

function citySelected(cno){
	url="/jee-moviesell/FindTheatresByCnoServlet?cno="+cno;
	location=url;
	
}

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


