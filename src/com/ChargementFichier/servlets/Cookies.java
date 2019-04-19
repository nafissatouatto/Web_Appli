package com.ChargementFichier.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Cookies
 */
@WebServlet("/Cookies")
public class Cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cookies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
         //récuperation des informations du cookies
		Cookie[] cookies =request.getCookies();
		if(cookies!=null){
			//boucle faisant une itération sur tous les cookies existants
			for(Cookie cookie:cookies) { 
				if (cookie.getName().equals("prenom")) {
					request.setAttribute("prenom", cookie.getName());
					
				}
			}
			
			
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/cookies.jsp").forward(request, response);
		//
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub//recuperation des des données du formulaire
		String nom =request.getParameter("nom");
		String prenom =request.getParameter("prenom");
		//memorisation des données d'un formulaire
		
		response.addCookie(new Cookie("prenom",prenom));
		this.getServletContext().getRequestDispatcher("/WEB-INF/cookies.jsp").forward(request, response);
		//
	}

}
