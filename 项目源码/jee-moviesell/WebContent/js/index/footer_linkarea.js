// JavaScript Document

function attachFooter(objid) {
	var tds = objid.getElementsByTagName('td');
	for ( var i = 0; i < tds.length; i++) {

		with (tds[i]) {
			onmouseover = function() {
				with (this) {
					style.border = '2px #41A0CC solid'; // 这是鼠标移上去时的背景颜色

				}
			}
			onmouseout = function() {
				with (this) {
					style.border = '2px white solid'; // 这是鼠标离开时的背景颜色

				}
			}
		}
	}
}
