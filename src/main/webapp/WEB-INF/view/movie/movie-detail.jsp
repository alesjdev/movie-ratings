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
                        <br>
                        <!-- Rate movie button -->
                        <a class="btn btn-danger"
                           href="${pageContext.request.contextPath}/addReview?movieId=${movie.id}" >
                            Add review
                        </a>
                        <br>
                        <a class="btn btn-success"
                           href="#Reviews" >
                            See reviews
                        </a>
                    </div>
                    <!-- Details card -->
                    <div class="col-sm-9 col-9 card text-white bg-dark card-body">
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
                                <a href="${pageContext.request.contextPath}/movie/byGenre?genreName=${genre.name}&genreId=${genre.id}"
                                   class="btn btn-info">${genre.name} </a>
                            </c:forEach>
                            <br><br>
                            <hr>
                            <p>Cast:</p>
                                <!-- Cast cards -->
                                <c:forEach var="person" items="${movie.cast}">
                                    <div class="card text-white bg-dark mb-4" style="max-width: 10rem; display:inline-block;">
                                        <div class="card-body">
                                            <a href="${pageContext.request.contextPath}/person/byId?castId=${person.id}">
                                                <img
                                                <c:if test = "${not empty person.profileSmall}">
                                                    src="${person.profileSmall}"
                                                </c:if>
                                                <c:if test = "${empty person.profileSmall}">
                                                    src="${pageContext.request.contextPath}/assets/img/pic-not-available.png"
                                                </c:if>
                                                alt="${person.name}"
                                                     style="max-width: 100%; height: auto;">
                                            </a>
                                        </div>
                                        <div class="card-footer d-flex align-items-center justify-content-between">
                                            <a class="small text-white stretched-link"
                                               href="${pageContext.request.contextPath}/person/byId?castId=${person.id}">
                                                ${person.name}<br>(<span style="color: gold">${person.character}</span>)
                                            </a>
                                        </div>
                                    </div>
                                </c:forEach>
                        </div>
                    </div>
                    <!-- End of movie tags -->
                </div>
                <hr>

                <!-- User reviews about the movie -->
                <div class="row" style="opacity:0.9" id="Reviews">
                    <div class="card text-white bg-dark">
                        <br>
                        <h5 style="margin-left: 10px"> User reviews</h5>
                        <hr>
                        <!-- Display message if no one reviewed this movie yet -->
                        <c:if test="${empty movie.reviews}">
                            <i class="text-warning">No one reviewed this movie yet. Be the first one to rate it! </i>
                            <br>
                        </c:if>
                        <!-- Review cards -->
                        <c:forEach var="review" items="${movie.reviews}">
                            <div class="card text-white bg-secondary card-body">
                                <!-- Score -->
                                <span>
                                <c:forEach begin="1" end="${review.score}">
                                    <i class="fas fa-star text-warning"></i>
                                </c:forEach>
                                <c:forEach begin="${review.score}" end="9">
                                    <i class="far fa-star text-warning"></i>
                                </c:forEach>
                                </span><br>
                                <!-- Short opinion -->

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
                            <br>
                        </c:forEach>
                    </div>

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