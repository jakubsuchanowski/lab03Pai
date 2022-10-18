<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="static java.lang.Math.pow" %>
<%@ page import="java.text.DecimalFormat" %><%--
  Created by IntelliJ IDEA.
  User: kubas
  Date: 18.10.2022
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Kalkulator</title>
</head>
<body>

<%
DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
Date now = new Date();
String date = dateFormat.format(now);
//out.println(date);
%>
<%=date%>
<h2>Kalkulator rat</h2><br>
<form action="calc.jsp" method="POST">
<label>Kwota pożyczki: </label>
<input type ="text" id="kwota" name="kwota"><br>
<label>Oprocentowanie roczne: </label>
<input type= "text" id="oprocentowanie" name="oprocentowanie"><br>
<label>Liczba rat: </label>
<input type="text" id="ileRat" name="ileRat"><br>
<input type = "submit" value="Wyślij" id = "wyslij" name="wyslij" ><br><br>
</form>
<%if (request.getParameter("wyslij") != null){
    String res="";
    try{
        Double k;
        Double pr;
        Double n;
        Double p;
        Double wynik;

        k = Double.parseDouble(request.getParameter("kwota"));
        pr = Double.parseDouble(request.getParameter("oprocentowanie"));
        n = Double.parseDouble(request.getParameter("ileRat"));
        p = pr/12;

        Double licznik=k*p;
        Double mianownik= 1-(1/pow((1+p),n));
        Double wynik = licznik/mianownik;
        DecimalFormat df = new DecimalFormat("#.00");
        String rata = df.format(wynik);
        res = rata;
    }
    catch (Exception e){}
    out.println("Rata:"+res);
//   out.println(rata);
}
%>
</body>
</html>
