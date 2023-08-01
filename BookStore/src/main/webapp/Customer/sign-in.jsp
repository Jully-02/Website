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
<title>Sign In</title>

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
	margin-bottom: 0px;
}

.bd-mode-toggle {
	z-index: 1500;
}
</style>
<%
String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
%>
<link href="<%=url%>/CSS/sign-in.css" rel="stylesheet">
<!-- Custom styles for this template -->
</head>

<body>
	<%
	String valueUsername = request.getAttribute("valueUsername") + "";
	valueUsername = (valueUsername == null || valueUsername.equals("null")) ? "" : valueUsername;
	String error = request.getAttribute("error") + "";
	error = (error == null || error.equals("null")) ? "" : error;
	%>

	<%@include file="../header.jsp" %>
	<main class="form-signin w-100 m-auto">
		<form action="<%=url%>/customer-controller?act=sign_in" method="POST">
			<div style="text-align: center; margin-bottom: 0px;">
				<img class="mb-4" src="<%=url%>/Image/Logo/GigiandJullyLogo.png"
					alt="logo" width="120px">
			</div>
			<div>
				<h1 class="h3 mb-3 fw-normal" style="text-align: center;">Please
					Sign In</h1>
			</div>

			<div class="form-floating">
				<input type="text" class="form-control" id="floatingInput"
					placeholder="abc123" value="<%=valueUsername%>" name="username">
				<label for="floatingInput">Username</label>
			</div>
			<div class="form-floating" style="margin-bottom: 0px">
				<input type="password" class="form-control" id="floatingPassword"
					placeholder="Password" name="password"> <label
					for="floatingPassword">Password</label>
			</div>
			<p class="error"><%=error%></p>

			<div class="form-check text-start my-3">
				<input class="form-check-input" type="checkbox" value="remember-me"
					id="flexCheckDefault"> <label class="form-check-label"
					for="flexCheckDefault"> Remember me </label>
			</div>

			<button class="btn btn-primary w-100 py-2" type="submit">Sign
				in</button>
			<div style="margin-top: 5px">
				<p style="text-align: center">
					Do not have an account? <a href="<%=url%>/Customer/sign-up.jsp"
						style="text-decoration: none">Sign Up</a>
				</p>
			</div>
			<div>
				<p class="mt-5 mb-3 text-body-secondary" style="text-align: center;">&copy;
					2022–2025</p>
			</div>
		</form>
	</main>
	<div>
		<%@include file="../footer.jsp" %>
	</div>
	<script src="assets/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>