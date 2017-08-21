<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Zamuna
  Date: 8/12/2017
  Time: 10:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../header.jsp"%>
<%@include file="../nav.jsp"%>
<div class="row justify-content-center">
    <div class="card col-md-8">
        <div class="card-body">
            <h4 class="card-title">${position.title}</h4>
            <p class="card-text float-right">Deadline: ${position.deadline}</p>
            <h6 class="card-subtitle mb-2 text-muted">${position.description}</h6>
            <p class="card-text">Estimated Wage: $ ${position.estimatedwage}</p>
            <p class="card-text">Duration: ${position.duration} months</p>
            <p class="card-text">Category: ${position.category}</p>


            <address>
                <h6 class="card-subtitle mb-2 text-muted">Location:</h6>
                <p class="card-text">${position.jobLocation}</p>
                <%--<p class="card-text"> ${position.locationId.street}, ${position.locationId.city}, ${position.locationId.state}</p>--%>
            </address>

            <a href="../updatePosition/${position.id}" class="btn btn-info btn-sm float-right"><i class="icon-edit-sign">&nbsp;Update</i></a>
            <form action="../deletePosition/${position.id}" method="get">
                <button class="btn btn-danger btn-sm float-right" value="Delete" type="submit"><i class="icon-trash">&nbsp;Delete</i>
                    </button>
            </form>
            <%--TODO form --%>
            <form:form action="../../job/apply/${position.id}" method="post" >
                <button class="btn btn-info btn-small float-right" value="Apply" type="submit">Apply</button>
            </form:form>

        </div>
    </div>
</div>
<h4 class="text-center">Tutors who applied</h4>
<%--Available tutor section starts--%>
    <section class="d-flex flex-row  justify-content-center">
        <c:forEach var="appliedUser" items="${appliedUsers}">
            <div class="col-sm-4 col-md-3 col-lg-2 mt-4">
                <div class="card">
                    <img class="card-img-top" src="https://www.lacartedescolocs.fr/assets/fallbacks/profile_woman_medium_fallback-a7f0361efd57b6d193bef198dacdaaf2a0ac1aa17f23cd9613540c05f2c6bac6.png">
                    <div class="card-block">

                        <p class="card-title mt-3" style="font-size: 0.75rem">${appliedUser.email}</p>
                        <div class="meta">
                            <p>${appliedUser.addressId.city}</p>

                        </div>

                    </div>
                    <div class="card-footer">

                        <div class="icon pull-right d-flex flex-row justify-content-center align-baseline">
                            <form:form method="post" action="../../job/approve/${position.id}/${appliedUser.id}">
                                <%--<input type="submit" value="Submit" class="btn btn-link"/>--%>
                                <button type="submit" class="btn btn-link">
                                    <i class="icon-gittip" aria-hidden="true" data-toggle="tooltip" data-placement="top" title="confirm this tutor"></i>
                                </button>

                            </form:form>
                            <form:form method="post" action="../../job/approve/${position.id}/${appliedUser.id}">
                            <button type="submit" class="btn btn-link">
                                <i class="icon-envelope" aria-hidden="true" data-toggle="tooltip" data-placement="top" title="Message this tutor"></i>
                                <button type="submit" class="btn btn-link">
                                </form:form>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>

    <%--end of section of available tutorss--%>

<%@include file="../footer.jsp"%>