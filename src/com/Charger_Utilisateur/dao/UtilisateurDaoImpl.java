package com.Charger_Utilisateur.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Charger_Utilisateur.beans.BeanException;
import com.Charger_Utilisateur.beans.Utilisateur;
import com.Charger_Utilisateur.dao.UtilisateurDao.UtilsateurDao;

public class UtilisateurDaoImpl implements UtilsateurDao{
	private DaoFactory  daoFactory;
	//Constructrur
UtilisateurDaoImpl(DaoFactory  daoFactory){
	
	this.daoFactory=daoFactory;
}
	@Override
	public void ajouter(Utilisateur utilisateur) throws DaoException{
		Connection connection= null;
		PreparedStatement preparedStatement = null;
		try {
			connection = daoFactory.getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO Nom(Nom,Prenom) VALUES(?, ?)");
	           
            preparedStatement.setString(1, utilisateur.getNom());
            preparedStatement.setString(2, utilisateur.getPrenom());
           
            preparedStatement.executeUpdate();
            connection.commit();
		}
		catch(SQLException e) {
			
			try{
				if(connection !=null) 
				{
					connection.rollback();
				}
			}
			catch(SQLException e2){
				throw new DaoException("Impossible de communiquer avec la base de donnée");
			}
		}
		finally
		{
				try {
					if(connection!=null)
					{
						connection.rollback();
					}
					
					
				} catch (SQLException e) {
					
					throw new DaoException("Impossible de communiquer avec la base de donnée");
				}	
			}
	}

	@Override
	public List<Utilisateur> lister() throws DaoException, BeanException {
		List<Utilisateur> utilisateurs= new ArrayList<Utilisateur>();
		
		//Connexion à la base de données
		Connection connexion=null;
		Statement statement =null;
		ResultSet resultat=null;
		//String sql="Select Nom,Prenom from Nom";
		try {
		connexion = daoFactory.getConnection();
		statement= connexion.createStatement();
		
	      	//Execution de la requete
	    resultat=statement.executeQuery("Select Prenom,Nom from Nom");
	    
		while(resultat.next())
			try {
				{
				String nom= resultat.getString("nom");
				String prenom= resultat.getString("prenom");
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setNom(nom);
				utilisateur.setPrenom(prenom);
				//ajout des utilisateurs dans la liste
				utilisateurs.add(utilisateur);
						
					}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		catch(SQLException e) {
			throw new DaoException("Impossible de communiquer avec la base de donnée");
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

}
