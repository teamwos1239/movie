function adminForm() {
	var inputCode = document.getElementById("input1").value.toUpperCase();

	if (inputCode.length <= 0) {
		alert("请输入验证码！");
		return false;
	} else if (inputCode != code) {
		alert("验证码输入错误！");
		createCode();
		return false;
	} else {
		var aaccount = document.getElementById("aaccount");
		var apass = document.getElementById("apass");

		if (aaccount.value.length == 0 || aaccount.value == "") {
			alert("账号为空");
			return false;
		} else if (apass.value == "" || apass.value.length == 0) {
			alert("密码为空");
			return false;
		} else {
			return true;
		}
	}

}

function formCheck() {
	var inputCode = document.getElementById("input1").value.toUpperCase();

	if (inputCode.length <= 0) {
		alert("请输入验证码！");
		return false;
	} else if (inputCode != code) {
		alert("验证码输入错误！");
		createCode();
		return false;
	} else {
		var uemail = document.getElementById("uemail");
		var uchecktext = document.getElementById("uchecktext");
		var upass = document.getElementById("upasss");
		var upass2 = document.getElementById("upasss2");
		
		if (uemail.value.length == 0 || uemail.value == "") {
			alert("邮箱为空");
			return false;
		}
		// 对电子邮件的验证
//		var myreg = '/^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/';
//		
//		alert("myreg.test(uemail.value)===="+myreg.test(uemail.value));
//		alert('uemail.value===='+uemail.value);
//		if (!myreg.test(uemail.value)) {
//			alert('提示  请输入有效的E_mail！'); 
//			alert('---');
//			return false;
//		} 
		if (uchecktext.value == "" || uchecktext.value.length == 0) {
			alert("确认码为空");
			return false;
		} 
		if (upass.value == "" || upass.length == 0) {
			alert("密码为空");
			return false;

		}
		if (upass != upass2) {
			alert("两次密码不相同");
			return false;
		}

		return true;
	}
}

var code; // 在全局 定义验证码
function createCode() {
	code = new Array();
	var codeLength = 4;// 验证码的长度
	var checkCode = document.getElementById("checkCode");
	checkCode.value = "";

	var selectChar = new Array(2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E',
			'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T',
			'U', 'V', 'W', 'X', 'Y', 'Z');

	for ( var i = 0; i < codeLength; i++) {
		var charIndex = Math.floor(Math.random() * 32);
		code += selectChar[charIndex];
	}
	if (code.length != codeLength) {
		createCode();
	}
	checkCode.value = code;
}

function validate() {
	var inputCode = document.getElementById("input1").value.toUpperCase();

	if (inputCode.length <= 0) {
		alert("请输入验证码！");
		return false;
	} else if (inputCode != code) {
		alert("验证码输入错误！");
		createCode();
		return false;
	} else {
		return true;
	}
}
