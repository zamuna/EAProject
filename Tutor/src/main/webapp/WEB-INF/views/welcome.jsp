<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Welcome</title>


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
	<div class="container">

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<form id="logoutForm" method="POST" action="/">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>

			<h2>
				Welcome ${pageContext.request.userPrincipal.name}
			</h2>

		</c:if>

	</div>
	<!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="/design/vendor/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
