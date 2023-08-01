<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Change Information</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
	integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
	crossorigin="anonymous"></script>
<!--<link href="CSS/sign-up.css" rel="stylesheet">-->
<style>
@import url(https://fonts.googleapis.com/css?family=Poppins:300);

html {
	height: 100%;
}

* {
	margin: 0px;
	padding: 0px;
}

body {
	font-family: sans-serif;
	/*background: linear-gradient(#30142b, #2772a1);*/
	background-color: #fff;
}

.login-page {
	width: 400px;
	/*padding: 8% 0 0;*/
	margin: auto;
	margin-top: 40px;
}

.form {
	/*position: relative;*/
	/*z-index: 1;*/
	text-align: center;
	/*position: absolute;*/
	/*top: 50%;*/
	/*left: 50%;*/
	width: 400px;
	padding: 40px;
	/*transform: translate(-50%, -50%);*/
	/*background: rgba(0, 0, 0, .5);*/
	background: #fff;
	box-sizing: border-box;
	box-shadow: 0 15px 25px rgba(0, 0, 0, .6);
	border-radius: 10px;
}

.form input {
	width: 100%;
	padding: 10px 0;
	font-size: 13px;
	color: #000;
	margin-top: 30px;
	border: none;
	border-bottom: 1px solid #000;
	outline: none;
	background: transparent;
}

.form .error {
	font-size: 13px;
	margin-top: 0;
	color: red;
	text-align: left;
}

h2 {
	color: #000;
}

.form .message {
	margin: 15px 0 0;
	color: #b3b3b3;
	font-size: 12px;
}

.form .message a {
	color: #289bb8;
	text-decoration: none;
}

.form .register-form {
	display: block;
}

.form .login-form {
	display: none;
}

.btn_sign_up {
	position: relative;
	display: inline-block;
	padding: 10px 20px;
	color: #289bb8;
	font-size: 16px;
	text-decoration: none;
	overflow: hidden;
	transition: .5s;
	margin-top: 15px;
	letter-spacing: 2px;
	border: none;
}

.btn_sign_up:hover {
	background: #289bb8;
	color: #000;
	border-radius: 5px;
	box-shadow: 0 0 5px #289bb8, 0 0 25px #289bb8, 0 0 50px #289bb8, 0 0
		100px #289bb8;
}

.btn_sign_up span {
	position: absolute;
	display: block;
}

.btn_sign_up span:nth-child(1) {
	top: 0;
	left: -100%;
	width: 100%;
	height: 2px;
	background: linear-gradient(90deg, transparent, #289bb8);
	animation: btn-anim1 1s linear infinite;
}

@keyframes btn_sign_up-anim1 { 0% {
	left: -100%;
}
50%,100%
{
left:100%;
}
}
.btn_sign_up span:nth-child(2) {
	top: -100%;
	right: 0;
	width: 2px;
	height: 100%;
	background: linear-gradient(180deg, transparent, #289bb8);
	animation: btn-anim2 1s linear infinite;
	animation-delay: .25s
}

@
keyframes btn_sign_up-anim2 { 0% {
	top: -100%;
}50%,100%
{
top:100%;
}
}
.btn_sign_up span:nth-child(3) {
	bottom: 0;
	right: -100%;
	width: 100%;
	height: 2px;
	background: linear-gradient(270deg, transparent, #289bb8);
	animation: btn-anim3 1s linear infinite;
	animation-delay: .5s
}

@keyframes btn_sign_up-anim3 { 0% {
	right: -100%;
}
50%,100%
{
right: 100%;
}
}
.btn_sign_up span:nth-child(4) {
	bottom: -100%;
	left: 0;
	width: 2px;
	height: 100%;
	background: linear-gradient(360deg, transparent, #289bb8);
	animation: btn-anim4 1s linear infinite;
	animation-delay: .75s
}

@
keyframes btn_sign_up-anim4 { 0% {
	bottom: -100%;
}
50%,100%
{
bottom:100%;
}
}
</style>
</head>
<body>
	<%
	String valueFullname = request.getAttribute("valueFullname") + "";
	String valueUsername = request.getAttribute("valueUsername") + "";
	String valueEmail = request.getAttribute("valueEmail") + "";
	String valuePhoneNumber = request.getAttribute("valuePhoneNumber") + "";
	String valueAddress = request.getAttribute("valueAddress") + "";
	String valueDeliveryAddress = request.getAttribute("valueDeliveryAddress") + "";
	String valueShoppingAddress = request.getAttribute("valueShoppingAddress") + "";
	String valueDateOfBirth = request.getAttribute("valueDateOfBirth") + "";

	valueFullname = (valueFullname == null || valueFullname.equals("null")) ? "" : valueFullname;
	valueUsername = (valueUsername == null || valueUsername.equals("null")) ? "" : valueUsername;
	valueEmail = (valueEmail == null || valueEmail.equals("null")) ? "" : valueEmail;
	valuePhoneNumber = (valuePhoneNumber == null || valuePhoneNumber.equals("null")) ? "" : valuePhoneNumber;
	valueAddress = (valueAddress == null || valueAddress.equals("null")) ? "" : valueAddress;
	valueDeliveryAddress = (valueDeliveryAddress == null || valueDeliveryAddress.equals("null"))
			? ""
			: valueDeliveryAddress;
	valueShoppingAddress = (valueShoppingAddress == null || valueShoppingAddress.equals("null"))
			? ""
			: valueShoppingAddress;
	valueDateOfBirth = (valueDateOfBirth == null || valueDateOfBirth.equals(null)) ? "" : valueDateOfBirth;

	String eUsername = request.getAttribute("eUsername") + "";
	String ePassword = request.getAttribute("ePassword") + "";
	String eRepassword = request.getAttribute("eRepassword") + "";
	String eEmail = request.getAttribute("eEmail") + "";
	String ePhoneNumber = request.getAttribute("ePhoneNumber") + "";

	eUsername = (eUsername == null || eUsername.equals("null")) ? "" : eUsername;
	ePassword = (ePassword == null || ePassword.equals("null")) ? "" : ePassword;
	eRepassword = (eRepassword == null || eRepassword.equals("null")) ? "" : eRepassword;
	eEmail = (eEmail == null || eEmail.equals("null")) ? "" : eEmail;
	ePhoneNumber = (ePhoneNumber == null || ePhoneNumber.equals("null")) ? "" : ePhoneNumber;
	%>
	<%
	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
	%>

	<%@include file="../header.jsp"%>

	<div class="login-page">
		<div class="form">
			<form class="register-form"
				action="<%=url%>/customer-controller?act=sign_up" method="POST">
				<input type="hidden" name="act" value="sign_up" />
				<h2>Register</h2>
				<div class="row">
					<div class="col">
						<div>
							<input type="text" id="fullname" placeholder="Full Name *"
								name="fullname" value="<%=valueFullname%>" required />
						</div>
						<div>
							<input type="text" id="username" placeholder="Username *"
								name="username" value="<%=valueUsername%>" required /> <span
								class="error"><%=eUsername%></span>
						</div>
						<div>
							<input type="email" id="email" placeholder="Email *" name="email"
								value="<%=valueEmail%>" required /> <span class="error"><%=eEmail%></span>
						</div>
						<div>
							<input type="password" id="password" placeholder="Password *"
								name="password" required onkeyup="checkDuplicatePassword()" />
							<span class="error"><%=ePassword%></span>
						</div>
						<div>
							<input type="password" id="repassword" placeholder="RePassword *"
								name="repassword" required onkeyup="checkDuplicatePassword()" />
							<span id="msgRepassword" class="error"><%=eRepassword%></span>
						</div>
					</div>
					<div class="col">
						<div>
							<input type="text" placeholder="Phone Number *"
								name="phoneNumber" value="<%=valuePhoneNumber%>" required /> <span
								class="error"><%=ePhoneNumber%></span>
						</div>
						<div>
							<input type="Date" placeholder="Date Of Birth *"
								name="dateOfBirth" value="<%=valueDateOfBirth%>" required />
						</div>
						<div>
							<input type="text" placeholder="Address *" name="address"
								value="<%=valueAddress%>" required />
						</div>
						<div>
							<input type="text" placeholder="Delivery Address"
								name="deliveryAddress" value="<%=valueDeliveryAddress%>" />
						</div>
						<div>
							<input type="text" placeholder="Shopping Address"
								value="<%=valueShoppingAddress%>" name="shoppingAddress" />
						</div>
					</div>
					<label id="verify"
						style="color: #000; font-size: 13px; white-space: nowrap; text-align: center; margin-top: 20px;">I
						agree all statements in Terms of service *</label> <input
						style="margin-top: 0;" type="checkbox" name="confirm" />
				</div>
				<button class="btn_sign_up" type="submit">
					<span></span> <span></span> <span></span> <span></span> Sign Up
				</button>
				<p class="message">
					Already registered? <a href="<%=url%>/Customer/sign-in.jsp">Sign
						In</a>
				</p>
			</form>
		</div>
	</div>
	<%@include file="../footer.jsp"%>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="JS/main.js"></script>
</body>

<script>
	function checkDuplicatePassword() {
		password = document.getElementById("password").value;
		repassword = document.getElementById("repassword").value;
		if (password != repassword) {
			document.getElementById("msgRepassword").innerHTML = "Password incorrect!";
			return false;
		} else {
			document.getElementById("msgRepassword").innerHTML = "";
			return true;
		}
	}

	function redirectToPage() {
		window.location.href = "index.jsp";
	}
</script>
</html>