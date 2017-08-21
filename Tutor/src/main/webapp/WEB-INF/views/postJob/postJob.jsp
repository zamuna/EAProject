<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Zamuna
  Date: 8/11/2017
  Time: 11:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../header.jsp" %>
<%@include file="../nav.jsp" %>
<%--Form start--%>
<h5 class="bg-light text-gray-dark">Add Job Post</h5>
<form:form action="/jobPost/addPosition/${pos.id}" method="post" modelAttribute="pos">
    <c:if test="${param.error != null}">
        <div class="alert alert-danger">
            <p>Invalid Fields</p>
        </div>
    </c:if>
    <div class="form-row">
        <div class="form-group  col-md-6">
            <label class="col-form-label">Title</label>
            <form:input path="title" cssClass="form-control form-control-sm"/>
            <form:errors path="title" cssClass="alert alert-danger"></form:errors>
        </div>
        <div class="form-group col-md-6">
            <label class="col-form-label">Description</label>
            <form:input path="description" cssClass="form-control form-control-sm"/>
            <form:errors path="description" cssClass="alert alert-danger">should be less than 255</form:errors>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-4">
            <label class="col-form-label form-control-sm">Duration</label>
            <div class="input-group input-group-sm ">
                <form:input path="duration" cssClass="form-control form-control-sm"/>
                <span class="input-group-addon form-control-sm">Months</span>
            </div>
            <form:errors path="duration" cssClass="alert alert-danger">should be less than 255</form:errors>
        </div>
        <div class="form-group col-md-4">
            <label class="col-form-label form-control-sm">Estimated Wage</label>
            <div class="input-group input-group-sm ">
                <span class="input-group-addon form-control-sm">$</span>
                <form:input path="estimatedwage" cssClass="form-control form-control-sm"/>
                <form:errors path="estimatedwage" cssClass="alert alert-danger">should be less than 255</form:errors>
            </div>
        </div>
        <div class="form-group col-md-4">
            <label class="col-form-label form-control-sm">Category</label>
            <form:select path="category" cssClass="form-control form-control-sm">
                <form:options items="${categories}"/>
            </form:select>
            <form:errors path="category" cssClass="alert alert-danger"></form:errors>
        </div>
    </div>
    <hr/>
    <h5>Job Location </h5>
    <div class="form-row">
        <div class="form-group col-md-5">
            <label class="col-form-label">Full Address</label>
            <form:input path="jobLocation" cssClass="form-control form-control-sm" placeholder="Full Address"/>
            <form:errors path="jobLocation" cssClass="alert alert-danger">should be less than 255</form:errors>
        </div>
        <div class="form-group col-md-3">
            <label class="col-form-label">DeadLine</label>
            <form:input path="deadline" cssClass="form-control form-control-sm" placeholder="yyyy-MM-dd"/>
            <form:errors path="deadline" cssClass="alert alert-danger">should be less than 255</form:errors>
        </div>
    </div>
    <form:button value="Post Job" class="btn btn-success">
        Save Job
    </form:button>


</form:form>

<%--form end--%>
<%@include file="../footer.jsp" %>
