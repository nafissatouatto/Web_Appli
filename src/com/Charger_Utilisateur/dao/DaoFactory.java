package com.Charger_Utilisateur.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
static String URL="jdbc:oracle:thin:@localhost:1521:xe";
static String User="system";
static String Pass="manager";
/*
private String url;
private String username;
private String password;*/
//Constructeur
 DaoFactory(String URL,String User,String Pass)
{
	this.URL=URL;
	this.User=User;
	this.Pass=Pass;
}
 
 public static DaoFactory getInstance() {
	 try {
     	
     	Class.forName("oracle.jdbc.driver.OracleDriver");
     } catch (ClassNotFoundException e) {
     }
	 
	 DaoFactory instance= new DaoFactory(URL, User, Pass);
    
	return instance;
	
 
    }
 
 public Connection getConnection() throws SQLException {
     Connection connexion = DriverManager.getConnection(URL, User, Pass);
     connexion.setAutoCommit(false);
     return connexion; 
 }

 
 //recuperation du Dao
 public UtilisateurDaoImpl GetUtilsateurDao() {
 return new UtilisateurDaoImpl(this);
 }
}
