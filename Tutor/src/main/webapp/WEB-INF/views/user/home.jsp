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
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0 navbar-right ">
            <li class="nav-item ">
                <a class="nav-link" href="/redirect/url">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="/jobPost/addPosition">PostJob</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/jobPost/getAllPosition">Posted ob</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/job/apply">AppliedJob</a>
            </li>
             
           <!--<li class="nav-item"><a class="nav-link" href="/admincontrol/displayuser">User</a></li>-->
            <li class="nav-item"><a class="nav-link active" href="#">${userName}</a></li>
            <li class="nav-item"><a class="nav-link" href="/logout">Logout</a>
        </ul>
    </div>
</nav>
		</div>
	</nav>
<section class="container p-3">
<!-- Page Content -->
<div class="container">

    <!-- Jumbotron Header -->
    <header class="jumbotron my-4">
        <h1 class="display-3">CsTech User Home</h1>
        <p class="lead">Find your A+ Tutor</p>
        <a href="#" class="btn btn-primary btn-lg">Call to action!</a>
    </header>

    <!-- Page Features -->
    <section class="row text-center">
        <c:forEach var="position" items="${positionList}">
        <div class="col-lg-3 col-md-6 mb-4">
        <div class="card">
        <img class="card-img-top" src="http://placehold.it/500x325" alt="">
        <div class="card-body">
        <h4 class="card-title">${position.title}</h4>
        <p class="card-text">${position.description}</p>
        <p class="card-text">${position.postedBy}</p>
        </div>
        <div class="card-footer">
            <form method="post" action="/job/apply/${position.id}">
            <button type="submit" class="btn btn-link btn-primary">Apply
            </button>
                    </form>
        </div>
        </div>
        </div>
        </c:forEach>
    </section>


    <%--</div>--%>
    <!-- /.row -->

</div>
<!-- /.container -->

<!-- Footer -->
<%@include file="../footer.jsp" %>