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
                        <!-- Change password button-->
                        <div class="card-body text-warning">
                            <a class="btn btn-warning"
                               href="${pageContext.request.contextPath}/account/changePasswordForm">Modify password</a>
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
                            <form:form action="${pageContext.request.contextPath}/account/changeBio"
                                       method="POST" modelAttribute="user">
                                <form:hidden path="id" />
                                <form:errors path="aboutMe" class="text-danger" />
                                <form:textarea path="aboutMe" rows="10" class="bg-secondary text-warning"
                                               style="width: 100%; font-weight: bold;" />
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

<script>
function showDiv() {
   document.getElementById('change-pass').style.display = "block";
}

function checkPassword(form) {
    oldPass = form.oldPassword.value;
    newPass1 = form.newPassword1.value;
    newPass2 = form.newPassword2.value;

    // If old password not entered
    if (oldPass == '')
        alert ("Please enter current password.");

    // If new password not entered
    else if (newPass1 == '')
        alert ("Please enter new password.");

    // If confirmation of new password not entered
    else if (newPass2 == '')
        alert ("Please enter confirmation of new password.");

    // If Not same return False.
    else if (newPass1 != newPass2) {
        alert ("\nPasswords don't match: Please try again.")
        return false;
    }

    // If same return True.
    else{
        alert("Password change in progress. Please log-in again.")
        return true;
    }
}
</script>