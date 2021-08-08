<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<div id="layoutSidenav_nav">
    <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
        <div class="sb-sidenav-menu">
            <div class="nav">
                <!-- Movies submenu -->
                <div class="sb-sidenav-menu-heading">Movies</div>
                <a class="nav-link" href="${pageContext.request.contextPath}/movie/popular">
                    <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                    Popular
                </a>
                <a class="nav-link" href="${pageContext.request.contextPath}/movie/top">
                    <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                    Top Rated
                </a>
                <a class="nav-link" href="${pageContext.request.contextPath}/movie/upcoming">
                    <div class="sb-nav-link-icon"><i class="far fa-clock"></i></div>
                    Upcoming
                </a>

                <!-- People submenu -->
                <div class="sb-sidenav-menu-heading">People</div>
                <a class="nav-link" href="${pageContext.request.contextPath}/person/popular">
                    <div class="sb-nav-link-icon"><i class="fas fa-child"></i></div>
                    Popular
                </a>

                <!-- Reviews submenu -->
                <div class="sb-sidenav-menu-heading">Reviews</div>
                <a class="nav-link" href="${pageContext.request.contextPath}/latestReviews">
                    <div class="sb-nav-link-icon"><i class="fas fa-clipboard"></i></div>
                    Latest
                </a>

            </div>
        </div>
        <security:authorize access="isAuthenticated()">
        <div class="sb-sidenav-footer">
            <div class="small">Logged in as:
                    <security:authentication property="principal.username" />
            </div>
        </div>
        </security:authorize>
    </nav>
</div>