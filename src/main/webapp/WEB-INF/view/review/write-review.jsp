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
    <title>Review of ${movie.title}</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed" style="background-image: url('${movie.backdropPath}');
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
                <div class="row" style="opacity:0.9">
                    <!-- Movie image card -->
                    <div class="col-sm-3 col-3 card text-white bg-dark card-body" style="max-width: 300px">
                        <img
                        <c:if test = "${not empty movie.posterSmall}">
                            src="${movie.posterSmall}"
                        </c:if>
                        <c:if test = "${empty movie.posterSmall}">
                            src="${pageContext.request.contextPath}/assets/img/pic-not-available.png"
                        </c:if> style="max-width: 100%; height: auto;" style="max-width: 100%; height: auto;" alt="${movie.title}">
                    </div>
                    <!-- Review details -->
                    <div class="col-sm-9 col-9 card text-white bg-dark card-body">
                        <div class="card-body">
                            <b class="h1">${movie.title} </b><br><br>
                            <form:form action="${pageContext.request.contextPath}/processReview"
                                       method="POST" modelAttribute="review" class="form-vertical">

                                <!-- Id, user, movieId -->
                                <form:hidden path="id" />
                                <form:hidden path="user" />
                                <form:hidden path="movieId" />

                                <!-- Rating -->
                                <p><span class="input-group-addon"><i class="fas fa-edit"></i></span> Your score</p>
                                <div style="margin-bottom: 25px" class="input-group">
                                    <c:forEach begin="1" end="10" varStatus="loop">
                                        <form:radiobutton class="form-check-input" path="score" value="${loop.index}" />
                                        <label class="form-check-label" style="padding-right:1em">
                                            &nbsp;${loop.index}
                                        </label>
                                    </c:forEach>
                                </div>
                                <hr>
                                <!-- Opinion -->
                                <p><span class="input-group-addon"><i class="fas fa-comment-alt"></i></span> Your review</p>
                                <div style="margin-bottom: 25px" class="input-group">
                                    <form:textarea path="opinion" placeholder="Write your opinion" class="form-control" />
                                </div>
                                <hr>

                                <div class="form-group">
                                    <!-- Register review button -->
                                    <div class="col-sm-6 controls">
                                        <button type="submit" class="btn btn-primary">Save review</button>
                                    </div>
                                    <br>
                                </div>
                            </form:form>

                            <!-- Delete button if updating existing review (review already had a score) -->
                            <c:if test = "${review.score > 0}">
                                <div class="col-sm-6 controls form-group">
                                    <form:form action="${pageContext.request.contextPath}/deleteReview"
                                               modelAttribute="review" class="form-vertical" method="POST">
                                        <form:hidden path="id" />
                                        <form:hidden path="user" />
                                        <form:hidden path="movieId" />
                                        <button type="submit" class="btn btn-danger">Delete review</button>
                                    </form:form>
                                </div>
                            </c:if>
                        </div>
                    </div>
                    <!-- End of movie tag -->
                </div>
                <hr>
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