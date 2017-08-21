<%@include file="../header.jsp"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01"
            aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
        <a class="navbar-brand" href="#">Tutor Search</a>
        <div class="col-lg-6" style="margin-left: 25px;">

            <div class="input-group">
                <input type="text" class="form-control col-md-4" placeholder="Search by title...">
                <span class="input-group-btn">
					<button class="btn btn-secondary" type="button">Go!</button>
				</span>
            </div>
        </div>
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0 navbar-right ">
            <li class="nav-item ">
                <a class="nav-link" href="/redirect/url">Home <span class="sr-only">(current)</span></a>
            </li>
            <%--<li class="nav-item">--%>
                <%--<a class="nav-link " href="/jobPost/addPosition">PostJob</a>--%>
            <%--</li>--%>
            <%--<li class="nav-item">--%>
                <%--<a class="nav-link" href="/jobPost/getAllPosition">PostedJob</a>--%>
            <%--</li>--%>
            <%--<li class="nav-item">--%>
                <%--<a class="nav-link" href="/job/apply">AppliedJob</a>--%>
            <%--</li>--%>
             
            <li class="nav-item"><a class="nav-link" href="/admincontrol/displayuser">User</a></li>
            <li class="nav-item"><a class="nav-link active" href="#">${userName}</a></li>
            <li class="nav-item"><a class="nav-link" href="/logout">Logout</a>
        </ul>
    </div>
</nav>
<section class="container p-3">

	<!-- Page Content -->
	<div class="container">

		<!-- Jumbotron Header -->
		<header class="jumbotron my-4">
			<h1 class="display-3">CsTech Admin Home</h1>
			<p class="lead">Find your A+ Tutor</p>
			<a href="#" class="btn btn-primary btn-lg">Call to action!</a>
		</header>

		<!-- Page Features -->
		<div class="row text-center">
			<c:forEach var="position" items="${positionList}">
				<div class="col-lg-3 col-md-6 mb-4">
					<div class="card">
						<img class="card-img-top" src="http://placehold.it/500x325" alt="">
						<div class="card-body">
							<h4 class="card-title">${position.title}</h4>
							<p class="card-text">${position.description}</p>
						</div>
						<div class="card-footer">
							<a href="#" class="btn btn-primary">Find Out More!</a>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<%@include file="../footer.jsp"%>