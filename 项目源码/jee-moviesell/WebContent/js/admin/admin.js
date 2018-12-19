// JavaScript Document

function attachUserMenu(objid) {
	var tds = objid.getElementsByTagName('div');
	for ( var i = 0; i < tds.length; i++) {
		with (tds[i]) {
			onmouseover = function() {
				with (this) {
					// style.background='#41A0CC'; //这是鼠标移上去时的背景颜色
					//style="color: white;background: 
					
					style.color='white';
					style.backgroundColor='#5DB6E0';
					
				}
			}
			onmouseout = function() {
				with (this) {
					// style.background='#5EB7E2'; //这是鼠标离开时的背景颜色
					style.color='';
					style.backgroundColor='';
				}
			}
		}
	}
}

function adminmenuOnclick(dId) {

	/*
	 * document.getElementById('dd1').style.display=="none";
	 * document.getElementById('dd2').style.display=="none";
	 * document.getElementById('dd3').style.display=="none";
	 */

	document.getElementById('dd1').style.display = "none";
	document.getElementById('dd2').style.display = "none";
	document.getElementById('dd3').style.display = "none";
	document.getElementById('dd4').style.display = "none";
	document.getElementById('dd5').style.display = "none";

	var dId1 = document.getElementById(dId);
	if (dId1.style.display == "none") {

		dId1.style.display = "block";
	} else {
		dId1.style.display = "none";
	}

}
