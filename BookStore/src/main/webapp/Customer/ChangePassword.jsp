<%@page import="Model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" data-bs-theme="auto">
<head>
<script src="assets/js/color-modes.js"></script>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.112.5">
<title>Change Password</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.3/examples/sign-in/">
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



<link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.b-example-divider {
	width: 100%;
	height: 3rem;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
		rgba(0, 0, 0, .15);
}

.b-example-vr {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh;
}

.bi {
	vertical-align: -.125em;
	fill: currentColor;
}

.nav-scroller {
	position: relative;
	z-index: 2;
	height: 2.75rem;
	overflow-y: hidden;
}

.nav-scroller .nav {
	display: flex;
	flex-wrap: nowrap;
	padding-bottom: 1rem;
	margin-top: -1px;
	overflow-x: auto;
	text-align: center;
	white-space: nowrap;
	-webkit-overflow-scrolling: touch;
}

.btn-bd-primary {
	--bd-violet-bg: #712cf9;
	--bd-violet-rgb: 112.520718, 44.062154, 249.437846;
	--bs-btn-font-weight: 600;
	--bs-btn-color: var(--bs-white);
	--bs-btn-bg: var(--bd-violet-bg);
	--bs-btn-border-color: var(--bd-violet-bg);
	--bs-btn-hover-color: var(--bs-white);
	--bs-btn-hover-bg: #6528e0;
	--bs-btn-hover-border-color: #6528e0;
	--bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
	--bs-btn-active-color: var(--bs-btn-hover-color);
	--bs-btn-active-bg: #5a23c8;
	--bs-btn-active-border-color: #5a23c8;
}

.error {
	font-size: 13px;
	margin-left: 2px;
	color: red;
	font-style: italic;
	margin-top: 0px;
	margin-bottom: 5px;
}

.bd-mode-toggle {
	z-index: 1500;
}
</style>

	<%
		String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	%>


<!-- Custom styles for this template -->
<link href="<%=url%>/CSS/sign-in.css" rel="stylesheet">
</head>
<body>

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
		
	%>
	
	<%
		String eCurrentPassword = request.getAttribute("eCurrentPassword") + "";
		String eNewPassword = request.getAttribute("eNewPassword") + "";
		String eConfirmPassword = request.getAttribute("eConfirmPassword") + "";
		
		eCurrentPassword = (eCurrentPassword == null || eCurrentPassword.equals("null"))?"":eCurrentPassword;
		eNewPassword = (eNewPassword == null || eNewPassword.equals("null"))?"":eNewPassword;
		eConfirmPassword = (eConfirmPassword == null || eConfirmPassword.equals("null"))?"":eConfirmPassword;
		
	%>
	<%@include file="../header.jsp" %>
	<main class="form-signin w-100 m-auto">
		<form action="<%=url%>/customer-controller?act=change_password" method="POST">
			<!-- src="assets/brand/bootstrap-logo.svg" -->
			<div style="text-align: center;">
				<img style="display:inline-block;" class="mb-1" src="<%=url%>/Image/Logo/GigiandJullyLogo.png" alt="logo"
					width="120" height="auto">
			</div>
			<h1 class="h3 mb-3 fw-normal" style="text-align: center;">Change
				Password</h1>
			<div class="form-floating">
				<input type="password" class="form-control" id="floatingPassword"
					placeholder="currentPassword" style="margin-bottom: 0px;" name="currentPassword"> <label
					for="floatingPassword">Current Password</label>
				<p class="error"><%= eCurrentPassword%></p>
			</div>
			<div class="form-floating">
				<input type="password" class="form-control" id="floatingPassword"
					placeholder="newPassword" style="margin-top: 0px; margin-bottom: 0px;" name="newPassword"> <label
					for="floatingPassword">New Password</label>
				<p class="error"><%=eNewPassword%></p>
			</div>
			<div class="form-floating">
				<input type="password" class="form-control" id="floatingPassword"
					placeholder="confirmPassword" style="margin-bottom: 0px;" name="confirmPassword"> <label
					for="floatingPassword">Confirm Password</label>
				<p class="error"><%=eConfirmPassword%></p>
			</div>

			<button class="btn btn-primary w-100 py-2" type="submit">Change
				Password</button>
			<p class="mt-4 mb-3 text-body-secondary" style="text-align: center">&copy;
				2023–2025</p>
		</form>
	</main>
	<%@include file="../footer.jsp" %>
	<script src="assets/dist/js/bootstrap.bundle.min.js"></script>
	<% } %>
</body>
</html>