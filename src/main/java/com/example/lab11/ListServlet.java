package com.example.lab11;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;


import static java.lang.System.out;


@WebServlet(name = "ListServlet", value = "/ListServlet")
public class ListServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        //pobranie sterownika do MySQL:
        Class.forName("com.mysql.cj.jdbc.Driver");
        //utworzenie obiektu połączenia do bazy danych MySQL:
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
        //utworzenie obiektu do wykonywania zapytań do bd:
        Statement st = conn.createStatement();
        String query = "SELECT * FROM Country WHERE Continent = 'Europe'";
        //wykonanie zapytania SQL:
        ResultSet rs = st.executeQuery(query);
        HttpSession session = request.getSession(true);
        CountryBean country;
        ArrayList<CountryBean> list = new ArrayList<CountryBean>();
        while (rs.next()){
            country = new CountryBean();
            //pobranie danych i przypisanie ich do CountryBean
            country.setName(rs.getString("name"));
            country.setCode(rs.getString("code"));
            country.setPopulation(rs.getLong("population"));
            country.setSurfaceArea(rs.getLong("surfaceArea"));
            list.add(country);

        }
        session.setAttribute("list", list);
        response.sendRedirect("countryList.jsp");




    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception e) {
            out.println("error");
        }
    }

        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        }
        catch (Exception e)
        {
            out.println("error");
        }

    }
}