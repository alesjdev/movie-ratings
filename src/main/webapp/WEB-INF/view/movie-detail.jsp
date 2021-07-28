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
<body class="sb-nav-fixed" style="background-image: url('${movie.backdropPath}');
              background-size: cover;
              background-attachment: fixed;
              background-position: center;">
<jsp:include page="frame/navbar-top.jsp" />
<div id="layoutSidenav">
    <jsp:include page="frame/navbar-side.jsp" />
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <br>
                <div class="row" style="opacity:0.85">
                    <!-- Movie image card -->
                    <div class="col-sm-3 col-3 card text-white bg-dark card-body">
                        <img src="${movie.posterPath}" style="max-width: 100%; height: auto;" alt="${movie.title}">
                    </div>
                    <!-- Details card -->
                    <div class="col-sm-9 col-9 card text-white bg-dark">
                        <div class="card-body">
                            <b class="h1">${movie.title} </b> <span style="color: lightgray"> (${movie.originalTitle})</span><br><br>
                            <i class="h5">${movie.tagline}</i>
                            <br><br><br>
                            <p>${movie.overview}</p>
                            <br>
                            <p>Duration: <span style="color: cyan">${movie.runtime} minutes</span></p>
                            <p>Status: <span style="color: yellow">${movie.status}</span></p>
                            <p>Release Date: <span style="color: orange">${movie.releaseDate}</span></p>
                            <p>Budget: <span style="color: tomato">${movie.budget}</span></p>
                            <p>Revenue: <span style="color: springgreen">${movie.revenue}</span></p>
                            <p>Original language: <span style="color: lightgray">${movie.originalLanguage}</span></p>
                            <p>Popularity: <span style="color: hotpink">${movie.popularity}</span></p><br><br>
                            <a href="${movie.imdbId}" class="btn btn-warning">IMDB Page</a><br><br>
                            <!-- Genres -->
                            <c:forEach var="genre" items="${movie.genres}">
                                <a href="moviesByGenre?genreId=${genre.id}" class="btn btn-info">${genre.name} </a>
                            </c:forEach>
                        </div>
                    </div>
                    <!-- End of movie tags -->
                </div>
                <hr>
                <!-- Cast-->
                <div class="row" style="opacity:0.85">
                    <!-- Movie image card -->
                    <c:forEach var="person" items="${movie.cast}">
                        <div class="col-xl-2 col-lg-3 col-md-3 col-sm-4 col-4">
                            <div class="card text-white bg-dark mb-4" style="max-width: 18rem;">
                                <div class="card-body">
                                    <a href="castDetail?castId=${person.id}">
                                        <img src="${person.profilePath}" alt="${person.name}"
                                             style="max-width: 100%; height: auto;">
                                    </a>
                                </div>
                                <div class="card-footer d-flex align-items-center justify-content-between">
                                    <a class="small text-white stretched-link" href="castDetail?castId=${person.id}">${person.name}</a>
                                    <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
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