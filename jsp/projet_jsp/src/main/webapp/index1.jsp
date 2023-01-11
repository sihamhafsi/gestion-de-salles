<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Espace direction</title>
</head>
<body bgcolor=#D0D3D4>
<h1 align="center" style="color:#D4AC0D">Gestion des salles</h1>
<form action="connection1.jsp" >
<fieldset>
<legend style="color:#7D6608">Administrateur</legend>
<table>
<tr><th align="left">Code:</th><td><input name="code_a" type="text"><br/></td></tr>
<tr><th align="left">Nom:</th><td><input name="nom_a" type="text"><br/></td></tr>
<tr><th align="left">Email:</th><td><input name="email_a" type="email"><br/></td></tr> 
</table>
</fieldset>
<fieldset>
<legend style="color:#7D6608" >Evenement</legend>
<table>
<tr><th align="left">Id even:</th><td><input name="id_e" type="text"><br/></td></tr>
<tr><th align="left">Date even:</th><td><input name="date_e" type="date"><br/></td></tr>
</table>
</fieldset>
<fieldset>
<legend style="color:#7D6608" >Salle</legend>
<table>
<tr><th align="left">n salle:</th><td><input name="num_salle" type="text"><br/></td></tr>
<tr><th align="left">n bloc:</th><td><input name="num_bloc" type="text"><br/></td></tr>
<tr><th align="left">nbr chaise:</th><td><input name="nbr_chaise" type="text"><br/></td></tr>
<tr><th align="left">nbr table:</th><td><input name="nbr_table" type="text"><br/></td></tr>
<tr><th align="left">capacite:</th><td><input name="capacite" type="text"><br/></td></tr>
</table>
</fieldset>
<table >
<tr ><td ><input type="submit" value="Ajouter" ></td><td><input type="reset" value="Annuler" ></td></tr>
</table>
</form>
<div >
<div >
<table  border = "1" width ="900">
<thead>
<tr>
<th>code</th>
<th>nom</th>
<th>email</th>
<th>id even</th> 
<th>date even</th>
<th>num salle</th>
<th>num bloc</th>
<th>nbr chaise</th>
<th>nbr table</th>
<th>capacite</th>  
<th>action</th>                                                                 
</tr>  
 <%   

Connection con;
PreparedStatement pst;
ResultSet rs;
ResultSet rs1;
ResultSet rs2;
        
Class.forName("com.mysql.cj.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_des_salles","root","");
                                
String query = "select * from admin";
Statement st = con.createStatement();
rs =  st.executeQuery(query);
                                    
String query1 = "select * from evenement";
Statement st1 = con.createStatement(); 
rs1 =  st1.executeQuery(query1);
                                      
String query2 = "select * from salle";
Statement st2 = con.createStatement();
rs2 =  st2.executeQuery(query2);
                                    
while(rs.next() && rs1.next() && rs2.next())
{
	String code_a = rs.getString("code_a");
    String id_e = rs1.getString("id_e");
    String num_salle = rs2.getString("num_salle");
    %>
             
    <tr>
    <td><%=rs.getString("code_a") %></td>
    <td><%=rs.getString("nom_a") %></td>
    <td><%=rs.getString("email_a") %></td>
     <td><%=rs1.getString("id_e") %></td>
     <td><%=rs1.getString("date_e") %></td>
     <td><%=rs2.getString("num_salle") %></td>
     <td><%=rs2.getString("num_bloc") %></td>
     <td><%=rs2.getString("nbr_chaise") %></td>
     <td><%=rs2.getString("nbr_table") %></td>
     <td><%=rs2.getString("capacite") %></td>
     <td><a href="delete1.jsp?code_a=<%=code_a%>&id_e=<%=id_e%>&num_salle=<%=num_salle%>">Supprimer</a></td>
                                 
     </tr> 
                             
                             
      <%
                                 
       }
      %>
                             
</table>    
</div>

</div> 
</body>
</html>