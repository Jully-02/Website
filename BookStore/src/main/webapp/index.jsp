<%@page import="Model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gigi Store</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<link rel="icon" type="image/png" href="Image/Logo/GigiandJullyLogo.png">
<link rel="stylesheet" type="text/css" href="CSS/style.css">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
	integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
	crossorigin="anonymous"></script>

<style>
* {
	font-family: inherit;
}
</style>
</head>
<body>
	<%
		String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	%>
	<!-- Navbar -->
	<%@include file="header.jsp" %>
	<!-- End Navbar -->

	<!-- Carousel -->
	<div id="carouselExampleAutoplaying" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img
					src="https://file.hstatic.net/200000312481/file/dacbiet_7c9134bbbea44077b081bbdcaa2a4b33.jpg"
					class="d-block w-100" alt="...">
			</div>
			<div class="carousel-item">
				<img
					src="https://file.hstatic.net/200000312481/file/2mat_3469760b49bb4176864116189169f7b1.jpg"
					class="d-block w-100" alt="...">
			</div>
			<div class="carousel-item">
				<img
					src="https://file.hstatic.net/200000312481/file/polo_aaf8947f65484e6c9dec8d63d72e266c.jpg"
					class="d-block w-100" alt="...">
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>
	<!-- End Carousel -->
	<div class="heading">
		<h1>MEOW COLLECTION</h1>
	</div>
	<!-- Product -->
	<div></div>
	<div class="container text-center">
		<div class="row">
			<div class="col-lg-3 col-md-5 mt-5">
				<div class="card text-center mb-3" style="width: 18rem;">
					<img
						src="Image/Product/Outerity Double Tee Collection - Blue Heart.jpg"
						class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Outerity Double Tee Collection - Blue
							Heart</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">Add To Cart</a>
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-5 mt-5">
				<div class="card text-center mb-3" style="width: 18rem;">
					<img src="Image/Product/Outerity Double Tee Collection - Corgi.jpg"
						class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Outerity Double Tee Collection - Corgi</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">Add To Cart</a>
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-5 mt-5">
				<div class="card text-center mb-3" style="width: 18rem;">
					<img
						src="Image/Product/Outerity Double Tee Collection - DJ Bear.jpg"
						class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Outerity Double Tee Collection - DJ
							Bear</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">Add To Cart</a>
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-5 mt-5">
				<div class="card text-center mb-3" style="width: 18rem;">
					<img
						src="Image/Product/Outerity Double Tee Collection - Fried Egg.jpg"
						class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Outerity Double Tee Collection - Fried
							Egg</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">Add To Cart</a>
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-5">
				<div class="card text-center mb-3" style="width: 18rem;">
					<img src="Image/Product/Outerity Meow's Garden tee.jpg"
						class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Outerity Meow's Garden Tee</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">Add To Cart</a>
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-5">
				<div class="card text-center mb-3" style="width: 18rem;">
					<img src="Image/Product/Outerity MeowFam Tee - Meow.jpg"
						class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Outerity MeowFam Tee - Meow</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">Add To Cart</a>
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-5">
				<div class="card text-center mb-3" style="width: 18rem;">
					<img src="Image/Product/Outerity Sweater Collection TÉ - Black.jpg"
						class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Outerity Sweater Collection TÉ - Black</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">Add To Cart</a>
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-5">
				<div class="card text-center mb-3" style="width: 18rem;">
					<img src="Image/Product/Polo Outerity Collection TÉ - Black.jpg"
						class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Polo Outerity Collection TÉ - Black</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">Add To Cart</a>
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-5">
				<div class="card text-center mb-3" style="width: 18rem;">
					<img
						src="Image/Product/Outerity Double Tee Collection - Blue Heart.jpg"
						class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Outerity Double Tee Collection - Blue
							Heart</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">Add To Cart</a>
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-5">
				<div class="card text-center mb-3" style="width: 18rem;">
					<img src="Image/Product/Outerity Double Tee Collection - Corgi.jpg"
						class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Outerity Double Tee Collection - Corgi</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">Add To Cart</a>
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-5">
				<div class="card text-center mb-3" style="width: 18rem;">
					<img
						src="Image/Product/Outerity Double Tee Collection - DJ Bear.jpg"
						class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Outerity Double Tee Collection - DJ
							Bear</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">Add To Cart</a>
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-5">
				<div class="card text-center mb-3" style="width: 18rem;">
					<img
						src="Image/Product/Outerity Double Tee Collection - Fried Egg.jpg"
						class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Outerity Double Tee Collection - Fried
							Egg</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">Add To Cart</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Product -->

	<!-- Footer -->
	<%@include file="footer.jsp" %>
	<!-- End Footer -->
</body>
</html>