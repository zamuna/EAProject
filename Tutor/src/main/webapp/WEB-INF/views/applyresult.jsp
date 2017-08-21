<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Tutor</title>

<c:url value="/design/css/heroic-features.css" var="heroic_css" />
<c:url value="/design/vendor/bootstrap/css/bootstrap.min.css"
	var="boost_css" />
<c:url value="/css/custom.css" var="main_css" />
<!-- Custom styles for this template -->
<link href="${heroic_css}" rel="stylesheet" />
<!-- Bootstrap core CSS -->
<link href="${boost_css}" rel="stylesheet" />
<!-- Main CSS -->
<link href="${main_css}" rel="stylesheet" />
</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<a class="navbar-brand" href="#">CsTech</a>
		<!--<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>-->
		<div class="col-lg-6" style="margin-left: 25px;">
			<form:form method="POST" action="/searchPosition">
				<div class="input-group">
					<input type="text" name="keyword" class="form-control"
						placeholder="Search by title..."> <span
						class="input-group-btn">
						<button class="btn btn-secondary" type="submit">Go!</button>
					</span>
				</div>
			</form:form>
		</div>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link" href="/redirect/url">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link active" href="#">connected:${user.username}</a></li>
				<li class="nav-item"><a class="nav-link" href="/job/apply">JobApplied</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/jobPost/getAllPosition">Posted ob</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/jobPost/addPosition">PostJob</a></li>
				<li class="nav-item"><a class="nav-link" href="/logout">logout</a>
				</li>
			</ul>
		</div>
	</nav>
	<section class="container p-1">
		<!-- Page Content -->
		<div class="container">

			<h5>Thank you ${user.username} for applying to this job!</h5>
		</div>

		<!-- Bootstrap core JavaScript -->
		<script src="/design/vendor/jquery/jquery.min.js"></script>
		<script src="/design/vendor/popper/popper.min.js"></script>
		<script src="/design/vendor/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>