package com.Charger_Utilisateur.beans;

public class Utilisateur {
	private String nom;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) throws BeanException{
		if(nom.isEmpty())
		{			
        throw new BeanException ("Le nom est vide veillez renseigner le champs nom SVP!!");	
       }

		else {
			this.nom = nom;
		}
	}
	private String prenom;
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) throws BeanException {
		if (prenom.isEmpty()) {
			 throw new BeanException ("Le prenom est vide veillez renseigner le champs prenom SVP!!");	
		}
		
		else	{	
		
		this.prenom = prenom;
		}
	}

}
