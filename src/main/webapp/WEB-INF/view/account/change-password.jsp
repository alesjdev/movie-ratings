<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en" xmlns:form="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>${user.username} - Account settings</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
</head>
<style>
    .separation {
        margin-left: 25px;
    }
</style>
<body class="sb-nav-fixed" style="background-image: url('${pageContext.request.contextPath}/assets/img/theatre.jpg');
              background-size: cover;
              background-attachment: fixed;
              background-position: center;">
<jsp:include page="../frame/navbar-top.jsp" />
<div id="layoutSidenav">
    <jsp:include page="../frame/navbar-side.jsp" />
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <br>
                <!-- Place for messages: error, alert etc ... -->
                <c:if test="${registrationError != null}">
                    <div class="form-group">
                        <div class="col-xs-15">
                            <div>
                                <!-- Check for registration error -->
                                    <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                        ${registrationError}
                                    </div>
                            </div>
                        </div>
                    </div>
                    <br>
                </c:if>

                <!-- Account details -->
                <div class="card bg-dark mb-4 text-white">
                    <div class="card-header">
                        <i class="fas fa-key"></i>
                        Change password
                    </div>

                    <!-- Password -->
                    <div class="card bg-dark mb-4 text-white">
                        <div class="card-body text-warning">
                            <!-- Change password form -->
                            <form:form action="${pageContext.request.contextPath}/account/changePassword"
                                       method="POST" modelAttribute="passwordValidation" >

                                Old password: <br>
                                <form:password path="password" class="bg-secondary text-warning"
                                               style="font-weight: bold;" />
                                <br>
                                <form:errors path="password" class="text-danger" />
                                <br><br>

                                New password: <br>
                                <form:password path="newPassword1" class="bg-secondary text-warning"
                                               style="font-weight: bold;" />
                                <br>
                                <form:errors path="newPassword1" class="text-danger" />
                                <br><br>

                                Confirm new password: <br>
                                <form:password path="newPassword2" class="bg-secondary text-warning"
                                               style="font-weight: bold;" />
                                <br>
                                <form:errors path="newPassword2" class="text-danger" />
                                <br><br>

                                <input type="submit" value="Change password" class="btn btn-danger" />
                            </form:form>

                        </div>
                    </div>
                </div>
                <br>
            </div>
        </main>
        <jsp:include page="../frame/footer.jsp" />
    </div>
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