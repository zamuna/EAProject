<%--
  Created by IntelliJ IDEA.
  User: Zamuna
  Date: 8/14/2017
  Time: 7:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../header.jsp"%>
<%@include file="../nav.jsp"%>
<h1>Hello There</h1>
<div class="row justify-content-center">
    <c:forEach var="position" items="${positionList}">
        <div class="col-md-10">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">${position.title}</h4>
                    <h6 class="card-subtitle mb-1 float-sm-right">${position.deadline}</h6>
                    <p class="card-text">${position.description}</p>
                    <p class="card-text">Duration: ${position.duration} months</p>
                    <p class="card-text">Category: ${(position.category)?position.category:'Not Specified'}</p>
                    <p class="card-text">PostedBy: ${position.postedBy}</p>

                    <address>
                        <h6 class="card-subtitle mb-2 text-muted">Location:</h6>
                        <p class="card-text"> ${position.jobLocation}</p>
                    </address>

                    <p class="card-text">Estimated Wage :$ ${position.estimatedwage}</p>
                    <%--TODO selectedUSer--%>
                    <c:if test="${position.selectedUser == uemail}">
                        <p class="alert alert-success">You are selected for this job</p>
                    </c:if>
                    <%--<a href="../jobPost/getPosition/${position.id}" class="btn btn-primary btn-sm">View Detail</a>--%>
                </div>
            </div>
        </div>
    </c:forEach>

</div>

<%@include file="../footer.jsp"%>

