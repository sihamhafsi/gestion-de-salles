<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" %> 


<% 
        String code_a = request.getParameter("code_a");
        String id_e = request.getParameter("id_e");
        String num_salle = request.getParameter("num_salle");
        Connection con;
        PreparedStatement pst;
        PreparedStatement pst1;
        PreparedStatement pst2;
        ResultSet rs;
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_des_salles","root","");
        pst = con.prepareStatement("delete from admin where code_a = ?");
        pst1 = con.prepareStatement("delete from evenement where id_e = ?");
        pst2 = con.prepareStatement("delete from salle where num_salle = ?");
        pst.setString(1, code_a);
        pst1.setString(1, id_e);
        pst2.setString(1, num_salle);
        pst.executeUpdate();  
        pst1.executeUpdate(); 
        pst2.executeUpdate(); 
        
        %>