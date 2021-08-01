<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>${person.name}</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed" style="background-image: url('${person.profilePath}');
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
                    <!-- Person image card -->
                    <div class="col-sm-3 col-3 card text-white bg-dark card-body" style="max-width: 300px">
                        <img
                        <c:if test = "${not empty person.profileSmall}">
                            src="${person.profileSmall}"
                        </c:if>
                        <c:if test = "${empty person.profileSmall}">
                            src="${pageContext.request.contextPath}/assets/img/pic-not-available.png"
                        </c:if>
                        style="max-width: 100%; height: auto;" alt="${person.name}">
                    </div>
                    <!-- Details card -->
                    <div class="col-sm-9 col-9 card text-white bg-dark card-body">
                        <div class="card-body">
                            <!-- Person details -->
                            <b class="h1">${person.name} </b>
                            <c:if test = "${not empty person.originalName}">
                                <span style="color: lightgray"> (${person.originalName})</span>
                            </c:if>

                            <c:if test = "${not empty person.placeOfBirth}">
                                <br><br>
                                <i class="fas fa-map-marker-alt"></i> <i class="h5"> ${person.placeOfBirth}</i>
                                <br>
                            </c:if>
                            <br><br><br>

                            <p>${person.biography}</p>
                            <br>

                            <c:if test = "${not empty person.alsoKnownAs}">
                                <p>Also known as: <span style="color: gold">${person.alsoKnownAs}</span></p>
                            </c:if>

                            <c:if test = "${not empty person.birthday}">
                                <p>Birthday: <span style="color: cyan">${person.birthday}</span></p>
                            </c:if>

                            <c:if test = "${not empty person.deathday}">
                                <p>Death: <span style="color: tomato">${person.deathday}</span></p>
                            </c:if>
                            <p>Popularity: <span style="color: hotpink">${person.popularity}</span></p><br>
                            <c:if test = "${not empty person.homepage}">
                                <a href="${person.homepage}" class="btn btn-info">Homepage</a><br><br>
                            </c:if>

                            <a href="${person.imdbId}" class="btn btn-warning">IMDB Page</a><br><br>
                            <!-- End of person details -->
                            <hr>
                            
                            <p>Known for movies:</p>
                            <!-- Known for movies -->
                            <c:forEach var="movie" items="${person.movies}">
                                <div class="card text-white bg-dark mb-4" style="max-width: 10rem; display:inline-block;">
                                    <div class="card-body">
                                        <a href="${pageContext.request.contextPath}/movie/byId?movieId=${movie.id}">
                                            <img
                                            <c:if test = "${not empty movie.posterSmall}">
                                                src="${movie.posterSmall}"
                                            </c:if>
                                            <c:if test = "${empty movie.posterSmall}">
                                                src="${pageContext.request.contextPath}/assets/img/pic-not-available.png"
                                            </c:if>
                                            style="max-width: 100%; height: auto;"
                                                 alt="${movie.title}">
                                        </a>
                                    </div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a href="${pageContext.request.contextPath}/movie/byId?movieId=${movie.id}"
                                           class="small text-white stretched-link">
                                            ${movie.title}<br>
                                            <c:if test = "${not empty movie.character}">
                                                (<span style="color: cyan">${movie.character}</span>)
                                            </c:if>
                                        </a>
                                    </div>
                                </div>
                            </c:forEach>
                            <!-- End of movies known for -->
                        </div>
                    </div>
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