<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"
    %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("utf-8");
%>

<head>
<meta charset="utf-8">
<link href="${contextPath}/resources/css/main.css" rel="stylesheet" type="text/css">
<link href="${contextPath}/resources/css/login.css" rel="stylesheet" type="text/css">
<link href="${contextPath}/resources/css/join_us.css" rel="stylesheet" type="text/css">




	<title><tiles:insertAttribute name="title" /></title>
	
</head>
<body>
	<div id="outer_wrap">
		<div id="wrap">
			<header>
				   <tiles:insertAttribute name="header" />
			</header>

			
			<section>
				   <tiles:insertAttribute name="section" />
			</section>

			<main>
			 	<tiles:insertAttribute name="body" />
			</main>
			
			<footer>
        		<tiles:insertAttribute name="footer" />
        	</footer>
    	</div>
    </div>        	

<script src="${contextPath}/resources/js/mainpage.js"></script>
</body>
      
        
        