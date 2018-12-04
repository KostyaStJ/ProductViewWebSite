<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="content/header.jsp"/>

<div class="nav navbar-left">
    <ul class="nav nav-pills nav-stacked">
        <li role="presentation" class="active"><a href="/home">Home</a></li>
        <li role="presentation" class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="admin/categories" role="button" aria-haspopup="true"
               aria-expanded="false">
                Categories <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
                <li role="presentation"><a href="/admin/addcategory">Add category</a></li>
                <li role="presentation"><a href="/admin/allcategories">Show all categories</a></li>
            </ul>
        </li>
        <li role="presentation"><a href="#">Users</a></li>
    </ul>
</div>

<jsp:include page="content/footer.jsp"/>