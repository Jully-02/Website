<%@page import="Model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src="<%=url%>/Image/Logo/GigiandJullyLogo1.png" alt="Bootstrap" height="50">
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="<%=url%>/index.jsp"> Home </a></li>
					<li class="nav-item"><a class="nav-link active" href="#">
							Kid </a></li>
					<li class="nav-item"><a class="nav-link active" href="#">
							Double Tote </a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Meow
							Collection </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#"> Meow Tote </a></li>
							<li><a class="dropdown-item" href="#"> Meow Outwear </a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#"> Meow Polo </a></li>
						</ul></li>
					<li class="nav-item"><a class="nav-link active" href="#">
							About </a></li>
				</ul>
				<form class="d-flex" role="search">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
				<%
				Customer customer = (Customer) session.getAttribute("customer");
				if (customer == null) {
				%>
				<a class="btn btn-primary"
					style="margin-left: 5px; margin-right: 5px; width: 78px"
					href="Customer/sign-in.jsp">Sign In</a>
				<%
				} else {
				%>
				<!--<p style="margin-left: 5px; margin-top: 12px; font-style: italic;"><b>Hi, fill name</b></p>
				<div style="margin-left: 10px; margin-right: 0px">
				<i style="margin-left: 10px"><svg xmlns="http://www.w3.org/2000/svg"
						class="icon icon-tabler icon-tabler-user-circle" width="30"
						height="30" viewBox="0 0 24 24" stroke-width="2"
						stroke="currentColor" fill="none" stroke-linecap="round"
						stroke-linejoin="round">
					   <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
					   <path d="M12 12m-9 0a9 9 0 1 0 18 0a9 9 0 1 0 -18 0"></path>
					   <path d="M12 10m-3 0a3 3 0 1 0 6 0a3 3 0 1 0 -6 0"></path>
				   		<path
							d="M6.168 18.849a4 4 0 0 1 3.832 -2.849h4a4 4 0 0 1 3.834 2.855"></path>
					</svg> </i>

					<a href="logout"
						style="text-decoration: none; display: block; text-align: center; margin-top: 0px">
						Logout </a>
				</div> -->
				<ul class="navbar-nav mb-2 mb-lg-0" style="margin-left: 10px;">
					<i style="margin-top:5px;">
						<svg xmlns="http://www.w3.org/2000/svg" class="icon icon-tabler icon-tabler-user-circle" width="30"
							height="30" viewBox="0 0 24 24" stroke-width="2"
							stroke="currentColor" fill="none" stroke-linecap="round"
							stroke-linejoin="round">
					   <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
					   <path d="M12 12m-9 0a9 9 0 1 0 18 0a9 9 0 1 0 -18 0"></path>
					   <path d="M12 10m-3 0a3 3 0 1 0 6 0a3 3 0 1 0 -6 0"></path>
				   		<path
								d="M6.168 18.849a4 4 0 0 1 3.832 -2.849h4a4 4 0 0 1 3.834 2.855"></path>
						</svg> 
					</i>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> <b><%=customer.getCustomerName()%></b>
					</a>
						<ul class="dropdown-menu dropdown-menu-end">
							<li><a class="dropdown-item" href="#"> My Order </a></li>
							<li><a class="dropdown-item" href="#"> Notification </a></li>
							<li><a class="dropdown-item" href="<%=url%>/Customer/ChangeInformation.jsp"> Change
									Information </a></li>
							<li><a class="dropdown-item" href="<%=url%>/Customer/ChangePassword.jsp"> Change Password </a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="<%=url%>/customer-controller?act=logout"> Logout </a></li>
						</ul></li>
				</ul>
				<%
				}
				%>
			</div>
		</div>
	</nav>