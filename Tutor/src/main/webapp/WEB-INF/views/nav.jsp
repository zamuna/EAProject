<%--
  Created by IntelliJ IDEA.
  User: Zamuna
  Date: 8/7/2017
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01"
            aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
        <a class="navbar-brand" href="/redirect/url">Tutor Search</a>
        <div class="col-lg-6" style="margin-left: 25px;">

            <div class="input-group">
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
        </div>
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0 navbar-right ">
            <li class="nav-item ">
                <a class="nav-link" href="/redirect/url">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="/jobPost/addPosition">PostJob</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/jobPost/getAllPosition">Posted Job</a>
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
<section class="container p-3">

