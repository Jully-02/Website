<%@page import="Model.Customer"%>
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
		String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	%>

	<% 
		String valueFullname = request.getAttribute("valueFullname") + "";
		String valueEmail = request.getAttribute("valueEmail") + "";
		String valuePhoneNumber = request.getAttribute("valuePhoneNumber") + "";
		String valueAddress = request.getAttribute("valueAddress") + "";
		String valueDeliveryAddress = request.getAttribute("valueDeliveryAddress") + "";
		String valueShoppingAddress = request.getAttribute("valueShoppingAddress") + "";
		String valueDateOfBirth = request.getAttribute("valueDateOfBirth") + "";
		
		String eEmail = request.getAttribute("eEmail") + "";
		String ePhoneNumber = request.getAttribute("ePhoneNumber") + "";

		eEmail = (eEmail == null || eEmail.equals("null"))?"":eEmail;
		ePhoneNumber = (ePhoneNumber == null || ePhoneNumber.equals("null"))?"":ePhoneNumber;
		
	%>
	<%
		Object object = session.getAttribute("customer");
		Customer customer1 = null;
		if (object != null) {
			customer1 = (Customer)object;
		}
		
		if (customer1 == null) {
			response.sendRedirect(url + "/index.jsp");
		}
		else {
			valueFullname = (valueFullname == null || valueFullname.equals("null"))?customer1.getCustomerName():valueFullname;
			valueEmail = (valueEmail == null || valueEmail.equals("null"))?customer1.getEmail():valueEmail;
			valuePhoneNumber = (valuePhoneNumber == null || valuePhoneNumber.equals("null"))?customer1.getPhoneNumber():valuePhoneNumber;
			valueDeliveryAddress = (valueDeliveryAddress == null || valueDeliveryAddress.equals("null"))?customer1.getDeliveryAddress():valueDeliveryAddress;
			valueShoppingAddress = (valueShoppingAddress == null || valueShoppingAddress.equals("null"))?customer1.getShoppingAddress():valueShoppingAddress;
			valueAddress = (valueAddress == null || valueAddress.equals("null"))?customer1.getAddress():valueAddress;
			valueDateOfBirth = (valueDateOfBirth == null || valueDateOfBirth.equals(null))?customer1.getDateOfBirth().toString():valueDateOfBirth;
	%>
	<%@include file="../header.jsp" %>
	<div class="login-page">
		<div class="form">
			<form class="register-form" action="<%=url%>/customer-controller?act=change_information" method="POST">
				<h2 style="letter-spacing: 1px;">Change Information</h2>
				<div class="row">
					<div class="col">
						<div>
							<input type="text" id="fullname" placeholder="Full Name *"
								name="fullname" value="<%= valueFullname%>" required />
						</div>
						<div>
							<input type="text" placeholder="Phone Number *" name="phoneNumber" value="<%=valuePhoneNumber %>" required />
							<span class="error"><%= ePhoneNumber %></span>
						</div>
						<div>
							<input type="Date" placeholder="Date Of Birth *"
								name="dateOfBirth" value="<%=valueDateOfBirth%>" required />
						</div>
					</div>
					<div class="col">
						<div>
							<input type="text" placeholder="Address *" name="address" value="<%= valueAddress %>" required />
						</div>
						<div>
							<input type="text" placeholder="Delivery Address" name="deliveryAddress" value="<%= valueDeliveryAddress %>" />
						</div>
						<div>
							<input type="text" placeholder="Shopping Address" value="<%= valueShoppingAddress %>" name="shoppingAddress" />
						</div>
					</div>
				</div>
				<div>
					<input type="email" id="email" placeholder="Email *" name="email" value="<%= valueEmail %>" required />
					<span class="error"><%= eEmail %></span>
				</div>
				<button class="btn_sign_up" type="submit" style="margin-top: 45px;"> <span></span> <span></span>
					<span></span> <span></span> Save
				</button>
			</form>
		</div>
	</div>
	<%@include file="../footer.jsp" %>
	<% }%>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="<%=url%>/JS/main.js"></script>
</body>
</html>