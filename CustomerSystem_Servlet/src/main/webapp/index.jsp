<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CustomSystem_Servlet</title>
</head>

<style>
:root {
	-while-color: #fff; -
	-black-color: #000; -
	-text-color: #ccc; -
	-privary-key: #f60;
}

* {
	padding: 0;
	margin: 0;
	box-sizing: border-box;
	box-sizing: inherit;
}

html {
	font-size: 62.5%;
	line-height: 1.6rem;
	font-family: 'Roboto', sans-serif;
	box-sizing: border-box;
}

#main {
	background-color: #ccffff;
	padding: 20px 15px;
	height: 969px;
}

.header-br {
	border: 1px solid #000000;
	margin-top: 30px;
}

.header-text {
	color: #ff0000;
	font-size: 35px;
}

.content-login__header h3 {
	color: #5066ff;
	margin-top: 170px;
	font-size: 30px;
	margin-bottom: 10px;
}

.content-text {
	font-size: 20px;
	margin-top: 10px;
}

.content-login {
	text-align: center;
}

.form-label {
	font-size: 20px;
}

#lblErrorMessage {
	color: #ff0000;
	font-size: 13px;
}

.form-group__btn {
	margin-bottom: 425px;
}

.content-login__container {
	margin-top: 20px;
}

.form-submit {
	background-color: #c0c0c0;
	color: #000000;
}

#txtUserID {
	font-size: 30px;
}

#txtPassword {
	font-size: 30px;
}

.form-group__password {
	margin-top: 10px;
}

.form-group__btn {
	margin-top: 50px;
}

#btnClear {
	margin-left: 200px;
}

.form-group__btn button {
	font-size: 20px;
	padding: 5px 25px;
}

.form-label__userID {
	padding-right: 21px;
}

.footer-text__copyright {
	font-size: 20px;
	margin-top: 5px;
}
</style>

<body>
	<div id="main">
		<div class="header">
			<h3 class="header-text">Training</h3>
			<div class="header-br"></div>
		</div>
		<div class="content">
			<div class="content-text">Login</div>
			<div class="content-login">
				<form action="/CustomerSystem_Servlet/Login" id="idform"
					method="POST" onsubmit="return checkInput()"> 
					<div class="content-login__header">
						<h3>LOGIN</h3>
						<div id="lblErrorMessage">
							<%
								if (request.getAttribute("message") != null) {
							%>
								<p><%=request.getAttribute("message")%></p> <%
							 }
							 %>
						</div>
					</div>
					<div class="content-login__container">

						<div class="form-group">
							<label for="fullname" class="form-label form-label__userID">User
								Id: </label> <input id="txtUserID" name="userName" maxlength="8"
								type="text" class="form-control">
						</div>
						<div class="form-group__password">
							<label for="password" class="form-label">Password: </label> <input
								id="txtPassword" name="password"  type="password"
								maxlength="8" class="form-control">
						</div>
						<div class="form-group__btn">
							<button type="submit" id="btnLogin" class="form-submit">Login</button>
							<button type="button" id="btnClear" class="form-submit" onclick="clearData()">Clear</button>
						</div>
					</div>
				</form>
			</div>
		</div>

		<footer class="footer">
			<div class="header-br"></div>
			<div class="footer-text__copyright">Copyright (c) 2000-2008
				FUJINET, All Rights Reserved.</div>
		</footer>


	</div>
</body>

<script>
	function clearData() {
		console.log("data");
		document.getElementById("txtUserID").value = "";
		document.getElementById("txtPassword").value = "";
		document.getElementById("lblErrorMessage").value = "";
	}
	
	
	function checkInput() {
		
		var user = document.getElementById("txtUserID").value;
		var pass = document.getElementById("txtPassword").value;
		document.getElementById("lblErrorMessage").textContent = "";
		if (user == "") {
			console.log(111);
			document.getElementById("lblErrorMessage").textContent = "ユーザーIDを入力してください。";
			return false;
		}
		if (pass == "") {
			document.getElementById("lblErrorMessage").textContent = "パスワードを入力してください。";
			return false;
		}
		document.getElementById("lblErrorMessage").textContent = "";
		return true;
	}
</script>
</html>