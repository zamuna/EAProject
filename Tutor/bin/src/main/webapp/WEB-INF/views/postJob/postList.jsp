<%--
  Created by IntelliJ IDEA.
  User: Zamuna
  Date: 8/12/2017
  Time: 9:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../header.jsp"%>
<%@include file="../nav.jsp"%>
<div class="row justify-content-center">
    <c:forEach var="position" items="${positionList}">
    <div class="col-md-10">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">${position.title}</h4>
                <h6 class="card-subtitle mb-1 float-sm-right">${position.deadline}</h6>
                <p class="card-text">${position.description}</p>

                <address>
                    <h6 class="card-subtitle mb-2 text-muted">Location:</h6>
                    <p class="card-text"> ${position.jobLocation}</p>
                    <%--<p class="card-text"> ${position.locationId.street}, ${position.locationId.city}, ${position.locationId.state}</p>--%>
                </address>

                <p class="card-text">Estimated Wage :$ ${position.estimatedwage}</p>

                <a href="../jobPost/getPosition/${position.id}" class="btn btn-primary btn-sm">View Detail</a>
            </div>
        </div>
    </div>
    </c:forEach>

</div>

<%@include file="../footer.jsp"%>