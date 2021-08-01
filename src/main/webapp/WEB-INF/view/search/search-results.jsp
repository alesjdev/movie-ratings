<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Search results for: ${keyword}</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed text-white" style="background-image: url('${pageContext.request.contextPath}/assets/img/theatre.jpg');
              background-size: cover;
              background-attachment: fixed;
              background-position: center;">
<jsp:include page="../frame/navbar-top.jsp" />
<div id="layoutSidenav">
    <jsp:include page="../frame/navbar-side.jsp" />
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <!-- Movie results -->
                <br>
                <div class="card text-white bg-dark mb-4" style="width: 100%">
                    <div class="card-body text-center">
                        Movie results for: ${keyword}
                    </div>
                </div>
                <div class="row">
                    <!-- Movie cards -->
                    <c:forEach var="movie" items="${movies}">
                        <div class="col-xl-2 col-lg-3 col-md-4 col-sm-4 col-xs-4 col-4">
                            <div class="card text-white bg-dark mb-4" style="max-width: 20rem;">
                                <div class="card-body">
                                    <a href="${pageContext.request.contextPath}/movie/byId?movieId=${movie.id}">
                                        <img
                                        <c:if test = "${not empty movie.posterSmall}">
                                            src="${movie.posterSmall}"
                                        </c:if>
                                        <c:if test = "${empty movie.posterSmall}">
                                            src="${pageContext.request.contextPath}/assets/img/pic-not-available.png"
                                        </c:if> style="max-width: 100%; height: auto;"
                                             alt="${movie.title}">
                                    </a>
                                </div>
                                <div class="card-footer d-flex align-items-center justify-content-between">
                                    <a class="small text-white stretched-link"
                                       href="${pageContext.request.contextPath}/movie/byId?movieId=${movie.id}">${movie.title}</a>
                                    <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <!-- End of movie tags -->
                </div>
                <!-- End of movie results -->
                <br><hr><br>

                <!-- People results -->
                <div class="card text-white bg-dark mb-4" style="width: 100%">
                    <div class="card-body text-center">
                        People results for: ${keyword}
                    </div>
                </div>
                <div class="row">
                    <!-- People cards -->
                    <c:forEach var="person" items="${people}">
                        <div class="col-xl-2 col-lg-3 col-md-4 col-sm-4 col-xs-4 col-4">
                            <div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
                                <div class="card-body">
                                    <a href="${pageContext.request.contextPath}/person/byId?castId=${person.id}">
                                        <img
                                        <c:if test = "${not empty person.profileSmall}">
                                            src="${person.profileSmall}"
                                        </c:if>
                                        <c:if test = "${empty person.profileSmall}">
                                            src="${pageContext.request.contextPath}/assets/img/pic-not-available.png"
                                        </c:if> style="max-width: 100%; height: auto;" alt="${person.name}">
                                    </a>
                                </div>
                                <div class="card-footer d-flex align-items-center justify-content-between">
                                    <a class="small text-white stretched-link"
                                       href="${pageContext.request.contextPath}/person/byId?castId=${person.id}">${person.name}</a>
                                    <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <!-- End of people cards -->
                </div>
                <!-- End of people results -->
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