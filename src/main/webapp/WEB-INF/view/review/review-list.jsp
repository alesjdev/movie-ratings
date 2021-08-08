<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>${movie.title}</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
</head>
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

                <!-- Latest user reviews -->
                <div class="row" style="opacity:0.9">
                    <div class="card text-white bg-dark mb-4" style="width: 100%">
                        <div class="card-body">
                            <b>Latest user reviews</b>
                        </div>
                    </div>

                    <!-- Review cards -->
                    <c:forEach var="review" items="${reviews}">
                        <div class="row mb-4">
                            <!-- Movie image -->
                            <div class="col-sm-3 col-3 card text-white bg-dark card-body" style="max-width: 180px">
                                <a href="${pageContext.request.contextPath}/movie/byId?movieId=${review.movie.id}">
                                    <img
                                    <c:if test = "${not empty review.movie.posterSmall}">
                                        src="${review.movie.posterSmall}"
                                    </c:if>
                                    <c:if test = "${empty review.movie.posterSmall}">
                                        src="${pageContext.request.contextPath}/assets/img/pic-not-available.png"
                                    </c:if> style="width: 100%; height: auto;" alt="${movie.title}">
                                </a>
                            </div>
                            <!-- Review details -->
                            <div class="col-sm-9 col-9 card text-white bg-dark card-body">
                                <!-- Score -->
                                <span>
                                <c:forEach begin="1" end="${review.score}">
                                    <i class="fas fa-star text-warning"></i>
                                </c:forEach>
                                <c:forEach begin="${review.score}" end="9">
                                    <i class="far fa-star text-warning"></i>
                                </c:forEach>
                                </span><br>

                                <!-- Detailed opinion -->
                                <p class="h6">
                                    <i>"${review.opinion}"</i><br>
                                </p>

                                <!-- User details -->
                                <small>
                                    <hr>
                                    Posted by
                                    <a class="text-info" href="${pageContext.request.contextPath}/user/byId?userId=${review.user.id}">
                                        <b>${review.user.username}</b></a>
                                    <!-- Date posted details -->
                                    on ${review.dateTime}
                                </small>
                            </div>
                        </div>
                        <br>
                    </c:forEach>
                </div>
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