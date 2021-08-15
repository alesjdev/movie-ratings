<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
</head>
<body style="background-image: url('${pageContext.request.contextPath}/assets/img/theatre.jpg');
              background-size: cover;
              background-attachment: fixed;
              background-position: center;">

<div class="col-xl-4 col-lg-8 col-md-10 col-sm-10 col-xs-10 col-10"  style="padding-top: 75px; margin: auto;">
    <div class="card bg-dark mb-4 text-white mainbox">
        <div class="card-header">
            <i class="fas fa-key"></i>&nbsp; Sign in
        </div>
        <div class="card bg-dark mb-4 text-white">
            <div class="card-body text-warning">
            <!-- Login Form -->
            <form:form action="${pageContext.request.contextPath}/authenticateUser"
                  method="POST" class="form-horizontal" modelAttribute="user">

                <!-- Place for messages: error, alert etc ... -->
                <div class="form-group">
                    <div class="col-xs-15">
                        <div>
                            <!-- Check for login error -->
                            <c:if test="${param.error != null}">
                                <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                    Invalid username or password.
                                </div>
                            </c:if>
                            <!-- Check for logout -->
                            <c:if test="${param.logout != null}">
                                <div class="alert alert-success col-xs-offset-1 col-xs-10">
                                    You have been logged out.
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>

                <!-- Email -->
                <div style="margin-top: 10px card-body">
                    Email <br>
                    <form:input path="email" placeholder="Email" class="bg-secondary text-white"
                                style="width:100%;" />
                </div>
                <br>
                <!-- Password -->
                <div style="margin-top: 10px card-body">
                    Password <br>
                    <form:password path="password" placeholder="Password" class="bg-secondary text-white"
                                   style="width:100%;" />
                </div>
                <br>
                <!-- Login/Submit Button -->
                <div style="margin-top: 10px card-body">
                    <input type="submit" class="btn btn-success" value="Login" />
                </div>

            </form:form>
            </div>
        </div>
    </div>

    <!-- Go to 'Register new user' view page -->
    <div class="text-white text-center">
        Don't have an account yet?
        <a href="${pageContext.request.contextPath}/register/show" class="btn btn-primary" role="button" aria-pressed="true">Register New User</a>
    </div>

</div>
<div class="container-fluid" style="position: absolute; bottom: 0px;">
    <jsp:include page="../frame/footer.jsp" />
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/js/scripts.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/assets/demo/chart-area-demo.js"></script>
<script src="${pageContext.request.contextPath}/assets/demo/chart-bar-demo.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/js/datatables-simple-demo.js"></script>
</body>
</html>