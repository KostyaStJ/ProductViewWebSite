<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<jsp:include page="content/header.jsp"/>

<div>
    <form:form method="POST" action="/registration" modelAttribute="user">
        <div class="form-group row">
            <label for="name" class="col-sm-2 col-form-label">Name</label>
            <div class="col-sm-5">

                <form:input path="name" cssClass="form-control" placeholder="User name"/>

            </div>
        </div>
        <div class="form-group row">
            <label for="lastName" class="col-sm-2 col-form-label">Lastname</label>
            <div class="col-sm-5">

                <form:input path="lastName" cssClass="form-control" placeholder="User lastname"/>

            </div>
        </div>
        <div class="form-group row">
            <label for="email" class="col-sm-2 col-form-label">E-mail</label>
            <div class="col-sm-5">

                <form:input path="email" cssClass="form-control" placeholder="User email"/>

            </div>
        </div>
        <div class="form-group row">
            <label for="password" class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-5">

                <form:input path="password" cssClass="form-control" placeholder="User password"/>

            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-10">

                <input type="submit" value="Submit" class="btn btn-primary"/>

            </div>
        </div>


    </form:form>


</div>

<jsp:include page="content/footer.jsp"/>

