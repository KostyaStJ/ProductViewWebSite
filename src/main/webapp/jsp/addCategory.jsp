<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="content/header.jsp"/>
<jsp:include page="admin.jsp"/>

<div>
    <div class="nav navbar-form">
        <form:form method="POST" action="/admin/addcategory" modelAttribute="category">
        <form:input path="name" cssClass="form-control" placeholder="Category name"/>
        <form:input path="description" cssClass="form-control" placeholder="Category description"/>
        <form:input path="id" type="hidden" value="${category.id}"/>
        <div class="form-group row">
            <div class="col-sm-10">
                <input type="submit" value="Submit" class="btn btn-primary"/>
            </div>
        </div>
    </div>
    </form:form>

</div>


<jsp:include page="content/footer.jsp"/>