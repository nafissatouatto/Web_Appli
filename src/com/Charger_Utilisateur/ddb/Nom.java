package com.Charger_Utilisateur.ddb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Charger_Utilisateur.beans.BeanException;
import com.Charger_Utilisateur.beans.Utilisateur;

public class Nom {
	 private Connection connexion;
	String URL="jdbc:oracle:thin:@localhost:1521:xe";
	String User="system";
	String Pass="manager";
	
	public List<Utilisateur> recupUtilisateur(){
	
		List<Utilisateur> utilisateurs= new ArrayList<Utilisateur>();
		try {
        	
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	
            } 
		catch (ClassNotFoundException e) 
		{
			
        }

		//Connexion à la base de données
		
		Statement statement =null;
		ResultSet resultat=null;
		//String sql="Select Nom,Prenom from Nom";
		
		loadDatabase();
		 try {
	        	
	        	statement = connexion.createStatement();
	        
	      	//Execution de la requete
	        	
			   resultat=statement.executeQuery("Select Prenom,Nom from Nom");
			  
						while(resultat.next()) {
				
				String nom= resultat.getString("nom");
				
				String prenom= resultat.getString("prenom");
				Utilisateur utilisateur =new Utilisateur();
				try {
					utilisateur.setNom(nom);
				} catch (BeanException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				utilisateur.setPrenom(prenom);
				
				//ajout des utilisateurs dans la liste
				utilisateurs.add(utilisateur);
			
			}
			
		}
		catch(SQLException e) {
			
		} catch (BeanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
				try {
					if(resultat!=null)
					{
						resultat.close();
					}
					
					if(statement!=null)
					{
						statement.close();
					}
					
					if(connexion!=null)
					{
						connexion.close();
					}
					
				} catch (SQLException ignore) {
					
				}	
			}
	
		return utilisateurs;
		
		
	}
	 private void loadDatabase() {
	        // Chargement du driver
	        try {
	        	
	        	Class.forName("oracle.jdbc.driver.OracleDriver");
	        } catch (ClassNotFoundException e) {
	        }

	        try {
	        	connexion = DriverManager.getConnection(URL, User, Pass);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	       
	    }
	

	    public void ajouterUtilisateur(Utilisateur utilisateur) {
	  
	    	loadDatabase();
	        
	        try {
	            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO Nom(Nom,Prenom) VALUES(?, ?)");
	           
	            preparedStatement.setString(1, utilisateur.getNom());
	            preparedStatement.setString(2, utilisateur.getPrenom());
	           
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	         
	        }
	    }

}
