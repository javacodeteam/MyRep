<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<c:choose>
	<c:when test="${!empty files}">
		<table border="2">
			<c:forEach var="file" items="${files}">
				<tr>
					<td>${file}</td>
					<td><a href="downloadd.do?fname=${file}">Download</a>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<h3>No Files Found</h3>
	</c:otherwise>
</c:choose>
</html>