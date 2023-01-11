<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.sql.SQLException" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>projet</title>
</head>
<body>
<%
        int code_u = Integer.parseInt(request.getParameter("code_u"));
        String nom_u = request.getParameter("nom_u");
		String prenom_u = request.getParameter("prenom_u");
		String email_u = request.getParameter("email_u");
		String type_u = request.getParameter("type_u");
		int id_e = Integer.parseInt(request.getParameter("id_e"));
		String date_e = request.getParameter("date_e");
		int num_salle = Integer.parseInt(request.getParameter("num_salle"));
		int num_bloc = Integer.parseInt(request.getParameter("num_bloc"));
		int nbr_chaise = Integer.parseInt(request.getParameter("nbr_chaise"));
		int nbr_table = Integer.parseInt(request.getParameter("nbr_table"));
		int capacite = Integer.parseInt(request.getParameter("capacite"));
		
	%>
	
	<%
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
    		
    		PreparedStatement PStat = Con.prepareStatement("CREATE DATABASE IF NOT EXISTS gestion_des_salles");
    		PStat.execute();
    		PreparedStatement PStat1 = Con.prepareStatement("CREATE DATABASE IF NOT EXISTS gestion_des_salles");
    		PStat.execute();
    		PreparedStatement PStat2 = Con.prepareStatement("CREATE DATABASE IF NOT EXISTS gestion_des_salles");
    		PStat.execute();
    		Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_des_salles", "root", "");
    		
    		PStat = Con.prepareStatement("CREATE TABLE IF NOT EXISTS utilisateur(code_u INT NOT NULL,"
    				                    +"nom_u VARCHAR(20) NOT NULL, "
    									+"prenom_u VARCHAR(20) NOT NULL, "
    									+"email_u VARCHAR(30) NOT NULL, "
    									+"type_u VARCHAR(20) NOT NULL)");
    		PStat.execute();
    		PStat1 = Con.prepareStatement("CREATE TABLE IF NOT EXISTS evenement(id_e INT NOT NULL,"
					+"date_e date NOT NULL)");
    		PStat1.execute();
    		PStat2 = Con.prepareStatement("CREATE TABLE IF NOT EXISTS salle(num_salle INT NOT NULL,"
                    +"num_bloc INT NOT NULL, "
					+"nbr_chaise INT NOT NULL, "
					+"nbr_table INT NOT NULL, "
					+"capacite INT NOT NULL)");
            PStat2.execute();
    		PStat = Con.prepareStatement("INSERT INTO utilisateur VALUES (?, ?, ?, ?, ?)");
    		PStat.setInt(1,code_u);
    		PStat.setString(2,nom_u);
    		PStat.setString(3, prenom_u);
    		PStat.setString(4, email_u);
    		PStat.setString(5, type_u);
    		PStat.executeUpdate();
    		
    		PStat.close();
    		
    		PStat1 = Con.prepareStatement("INSERT INTO evenement VALUES (?, ?)");
    		PStat1.setInt(1,id_e);
    		PStat1.setString(2, date_e);
    		PStat1.executeUpdate();
    		
    		PStat1.close();
    		PStat2 = Con.prepareStatement("INSERT INTO salle VALUES (?, ?, ?, ?, ?)");
    		PStat2.setInt(1,num_salle);
    		PStat2.setInt(2,num_bloc);
    		PStat2.setInt(3,nbr_chaise);
    		PStat2.setInt(4,nbr_table);
    		PStat2.setInt(5,capacite);
    		PStat2.executeUpdate();
    		
    		PStat.close();
    		Con.close();
		}
		catch(SQLException Ex)
		{
			out.println(Ex.getMessage());
		}
	
		out.println("Votre informations ont été ajoutées ");
	%>
</body>
</html>