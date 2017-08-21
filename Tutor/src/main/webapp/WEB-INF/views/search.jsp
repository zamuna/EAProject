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
						<button class="btn btn-secondary" type="button">Go!</button>
					</span>
				</div>
			</form:form>
		</div>
		<div class="collapse navbar-collapse" id="navbarResponsive">

			<ul class="navbar-nav ml-auto">

				<li class="nav-item active"><a class="nav-link" href="/">Home
						<span class="sr-only">(current)</span>
				</a></li>

				<li class="nav-item"><a class="nav-link" href="/login">Sign-in</a></li>
				<li class="nav-item"><a class="nav-link" href="/registration">Register</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/jobPost/addPosition">Post a Position</a></li>
			</ul>
		</div>
	</nav>
<section class="container p-3">
	<!-- Page Content -->
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Title</th>
					<th>Owner</th>
					<th>description</th>
					<th>Deadline</th>
					<th>Action</th>
				</tr>
			</thead>

			<c:forEach var="position" items="${positionList}">
				<tr>
					<td>${position.title}</td>
					<td>${position.postedBy}</td>
					<td>${position.description}</td>
					<td>${position.deadline}</td>
					<td>  <form:form action="/job/apply/${position.id}/${keyword}" method="post" >
                <button class="btn btn-info btn-small float-right" value="Apply" type="submit">Apply</button>
            </form:form></td>
					<!--<td><spring:url value="/users/${user.id}" var="userUrl" /> <spring:url
							value="/users/${user.id}/delete" var="deleteUrl" /> <spring:url
							value="/users/${user.id}/update" var="updateUrl" />

						<button class="btn btn-info" onclick="location.href='${userUrl}'">Query</button>
						<button class="btn btn-primary"
							onclick="location.href='${updateUrl}'">Update</button>
						<button class="btn btn-danger"
							onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
					</td>-->
				</tr>
			</c:forEach>
		</table>

	</div>

	<!-- Bootstrap core JavaScript -->
	<script src="/design/vendor/jquery/jquery.min.js"></script>
	<script src="/design/vendor/popper/popper.min.js"></script>
	<script src="/design/vendor/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>