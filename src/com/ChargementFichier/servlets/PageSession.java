package com.ChargementFichier.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Charger_Utilisateur.beans.BeanException;
import com.Charger_Utilisateur.beans.Utilisateur;
import com.Charger_Utilisateur.dao.DaoException;
import com.Charger_Utilisateur.dao.DaoFactory;
import com.Charger_Utilisateur.dao.UtilisateurDao.UtilsateurDao;


/**
 * Servlet implementation class PageSession
 */
@WebServlet("/PageSession")
public class PageSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilsateurDao utilisateurDao;
    
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageSession() {
        super();
        // TODO Auto-generated constructor stub
    }
public void init () throws ServletException{
	DaoFactory daoFactory= DaoFactory.getInstance();
	this.utilisateurDao= daoFactory.GetUtilsateurDao();
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Nom tabname= new Nom();
		
		//request.setAttribute("utilisateurs", tabname.recupUtilisateur());
		this.getServletContext().getRequestDispatcher("/WEB-INF/pageSession.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utilisateur utilisateur= new Utilisateur();
		try {
			utilisateur.setNom(request.getParameter("nom"));
		} catch (BeanException e) {
			request.setAttribute("erreur", e.getMessage());
		}
		try {
			utilisateur.setPrenom(request.getParameter("prenom"));
		} catch (BeanException e) {
			request.setAttribute("erreur", e.getMessage());
		}
	
		
		try {
			utilisateurDao.ajouter(utilisateur);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			request.setAttribute("utilisateurs", utilisateurDao.lister());
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BeanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			this.getServletContext().getRequestDispatcher("/WEB-INF/pageSession.jsp").forward(request, response);
	}

}
