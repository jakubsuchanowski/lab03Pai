<%@ page import="com.example.lab11.CountryBean" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: kubas
  Date: 04.11.2022
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kraje Europy</title>
</head>
<body>
<h1>Kraje Europy</h1>
<% ArrayList<CountryBean> list =
        (ArrayList<CountryBean>)session.getAttribute("list");
    for(CountryBean country:list){
        out.println(country.getName());
//        out.println(country.getCode());
//        out.println(country.getPopulation());
        out.println("<a href='details.jsp?i=" + list.indexOf(country)+"'>Details</a>");
        out.println("<br>");

    }

%>


</body>
</html>
