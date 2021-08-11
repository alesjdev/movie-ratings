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

                <!-- Account details -->
                <div class="card bg-dark mb-4 text-white">
                    <div class="card-header">
                        <i class="fas fa-address-card"></i>
                        Account details
                    </div>

                    <!-- Username -->
                    <div class="card bg-dark mb-4 text-white">
                        <div class="card-header">
                            Username:
                        </div>
                        <div class="card-body text-warning">
                            <b>${user.username}</b>
                        </div>
                    </div>

                    <!-- Password -->
                    <div class="card bg-dark mb-4 text-white">
                        <div class="card-header">
                            Password:
                        </div>
                        <div class="card-body text-warning">
                            <!-- TODO: Link to 'change password' form -->
                        </div>
                    </div>

                    <!-- Email -->
                    <div class="card bg-dark mb-4 text-white">
                        <div class="card-header">
                            Email:
                        </div>
                        <div class="card-body text-warning">
                            <b>${user.email}</b>
                        </div>
                    </div>

                    <!-- About -->
                    <div class="card bg-dark mb-4 text-white">
                        <div class="card-header">
                            Bio:
                        </div>
                        <div class="card-body text-warning">
                            <form:form action="${pageContext.request.contextPath}/account/changeBio" method="POST" modelAttribute="user">
                                <form:hidden path="id" />
                                <form:hidden path="password" />
                                <form:hidden path="username" />
                                <form:hidden path="email" />
                                <form:hidden path="enabled" />
                                <form:textarea path="aboutMe" rows="5" cols="70" class="bg-dark text-warning" />
                                <br>
                                <input type="submit" value="Change (Max 500 characters)" class="btn btn-warning" />
                            </form:form>

                        </div>
                    </div>

                </div>
                <br><hr><br>
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