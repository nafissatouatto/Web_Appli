package com.Charger_Utilisateur.dao;

import java.util.List;

import com.Charger_Utilisateur.beans.BeanException;
import com.Charger_Utilisateur.beans.Utilisateur;

public class UtilisateurDao {
	public interface UtilsateurDao{
		
		void ajouter(Utilisateur utilisateur) throws DaoException;
		List<Utilisateur> lister() throws DaoException, BeanException;
	}

}
