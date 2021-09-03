<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
</head>
<body>

${param.message}<br/>
<form name="loginForm" action="LoginController" method="post" onsubmit="return validateForm()">
	Enter username : <input type="text" name="username"/><label id="userId"></label><br/>
	Enter password : <input type="text" name="password"/><label id="userPassword"></label><br/>
	<input type="submit" value="Login">
</form>


<script>
function validateForm(){

	let username=document.loginForm.username.value;
	let password=document.loginForm.password.value;
	let labelUsername=document.getElementById("userId");
	let labelPassword=document.getElementById("userPassword");

	labelUsername.innerText="";
	labelPassword.innerText="";
	
	if(username==null||username==""){
		labelUsername.innerText="Username field is empty";
		labelUsername.style.color="red";
		return false;
	}
	
	if(password==null||password==""){
		labelPassword.innerText="Password field is empty";
		labelPassword.style.color="red";
		return false;
	}

	return true;
}
</script>
</body>
</html>