<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="content/header.jsp"/>

<div class="col-md-6 col-md-offset-3">
    <form action="/login" method="POST">
        <div class="form-group row">
            <label for="email" class="col-sm-2 col-form-label">Email</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" id="email" name="email" placeholder="Email">
            </div>
        </div>
        <div class="form-group row">
            <label for="password" class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-5">
                <input type="password" class="form-control" id="password" name="password" placeholder="Password">
            </div>
        </div>

        <div class="form-group row">
            <div class="col-sm-10">
                <input name="submit" type="submit" value="Submit" class="btn btn-primary"/>
                <a href="<c:url value="/registration"/>" class="btn btn-outline-info" role="button" aria-pressed="true">Create
                    an account</a>
            </div>
        </div>

        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>
</div>
<jsp:include page="content/footer.jsp"/>
