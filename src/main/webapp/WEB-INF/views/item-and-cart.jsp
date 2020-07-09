<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧</title>

</head>
<body>
<header>
<%--<jsp:include page="testHeader2.jsp" />--%>
</header>


<c:forEach items="${items}" var="item" varStatus="status">
   name: <c:out value="${item.name}"/>
   price: <c:out value="${item.price}"/>

    <form action="<%=request.getContextPath()%>/items/delete?id=<c:out value="${item.id}"/>>
    <button type="submit">DELETE</button>
    </form>
    
</c:forEach>



</body>
</html>