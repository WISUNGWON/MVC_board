<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
    <table width="500" cellpadding="0" cellspacing="0" border="1">
        <tr>
            <td>number</td>
            <td>name</td>
            <td>title</td>
            <td>date</td>
            <td>hit</td>
        </tr>
        <c:forEach items="${list}" var="dto">
        <tr>
            <td>${dto.bId}</td>
            <td>${dto.bName}</td>
            <td>
                <c:forEach begin="1" end="${dto.bIndent}">-</c:forEach>
                <a href="content_view.do?bId=${dto.bId}">${dto.bTitle}</a></td>
            <td>${dto.bDate}</td>
            <td>${dto.bHit}</td>
        </tr>
        </c:forEach>
        <tr>
            <td colspan="5"> <a href="write_view.do">write</a> </td>
        </tr>
    </table>

</body>
</html>


