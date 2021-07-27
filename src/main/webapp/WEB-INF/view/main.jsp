<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Dashboard - SB Admin</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="css/styles.css" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
    <jsp:include page="frame/navbar-top.jsp" />
    <div id="layoutSidenav">
        <jsp:include page="frame/navbar-side.jsp" />
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">Movies</h1>

                    <!-- Popular movies -->
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item active">Popular</li>
                    </ol>
                    <div class="row">
                        <!-- Movie cards -->
                        <c:forEach var="movie" items="${popularMovies}">
                            <div class="col-xl-2 col-lg-3 col-md-4 col-sm-4 col-4">
                                <div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
                                    <div class="card-body">
                                        <a href="#"><img src="${movie.posterPath}" style="max-width: 100%; height: auto;" alt="${movie.title}"></a>
                                    </div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">${movie.title}</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        <!-- End of movie tags -->
                    </div>
                    <!-- End of popular movies -->
                    <br><hr><br>

                    <!-- Top-rated movies -->
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item active">Top rated</li>
                    </ol>
                    <div class="row">
                        <!-- Movie cards -->
                        <c:forEach var="movie" items="${topRatedMovies}">
                            <div class="col-xl-2 col-lg-3 col-md-4 col-sm-4 col-4">
                                <div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
                                    <div class="card-body">
                                        <a href="#"><img src="${movie.posterPath}" style="max-width: 100%; height: auto;" alt="${movie.title}"></a>
                                    </div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">${movie.title}</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        <!-- End of movie tags -->
                    </div>
                    <!-- End of top-rated movies -->
                    <br><hr><br>

                    <!-- Upcoming movies -->
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item active">Upcoming</li>
                    </ol>
                    <div class="row">
                        <!-- Movie cards -->
                        <c:forEach var="movie" items="${upcomingMovies}">
                            <div class="col-xl-2 col-lg-3 col-md-4 col-sm-4 col-4">
                                <div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
                                    <div class="card-body">
                                        <a href="#"><img src="${movie.posterPath}" style="max-width: 100%; height: auto;" alt="${movie.title}"></a>
                                    </div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">${movie.title}</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        <!-- End of movie tags -->
                    </div>
                    <!-- End of upcoming movies -->

                </div>
            </main>
            <jsp:include page="frame/footer.jsp" />
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="js/scripts.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
    <script src="assets/demo/chart-area-demo.js"></script>
    <script src="assets/demo/chart-bar-demo.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
    <script src="js/datatables-simple-demo.js"></script>
</body>
</html>
