<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="layout/header.jsp"%>

<div class="container">
  <h2>Post List</h2>
  <table class="table">
    <thead class="thead-dark">
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성일</th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach var="post" items="${posts}">
      <tr>
        <td>${post.id}</td>
        <td><a href="/post/${post.id}">${post.title}</a></td>
        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${post.createDate}"/></td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
  </div>

<%@ include file="layout/footer.jsp"%>