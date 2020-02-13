package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Formulaire
 */
@WebServlet("/Formulaire")
public class Formulaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public int count;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Formulaire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		getFormulaire(request, response);
		enregistrerUtilisateur(request, response);
		PrintWriter Afficher = response.getWriter();
		afficherUtilisateur(request, Afficher);

	}
	 
	
	protected void getFormulaire (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		count++;
		
		response.setContentType("text/html");
		PrintWriter Afficher = response.getWriter();
		
		String A = request.getParameter("Cv");
		String B = request.getParameter("Prenom");
		String C = request.getParameter("Nom");  
		
		Afficher.println("<!DOCTYPE html>");
	    Afficher.println("<html>");
	    Afficher.println("<head>");
	    Afficher.println("<body style=\"background-color:orange;\">");
	    Afficher.println("<h1 style=\"color:yellow\"> Enregistrement de vos coordonees</h1>");
	    Afficher.println("<p style=\"color:yellow\"> Bonjour "+A+" "+B+" "+C+"</p><br>");
	    Afficher.println("<p style=\"color:yellow\"> Vous etes utilisateur Numero :"+count+"</p>");
	    
	}
	
	protected void enregistrerUtilisateur (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String A = request.getParameter("Cv");
		String B = request.getParameter("Prenom");
		String C = request.getParameter("Nom"); 
        
        Cookie CookieCv = new Cookie("Cv", A);
        Cookie CookiePrenom = new Cookie("Prenom", B);
        Cookie CookieNom = new Cookie("Nom", C);
        
        CookieCv.setMaxAge(60 * 60 * 24 * 30);
        CookiePrenom.setMaxAge(60 * 60 * 24 * 30);
        CookieNom.setMaxAge(60 * 60 * 24 * 30);
        
        response.addCookie(CookieCv);	
        response.addCookie(CookiePrenom);	
        response.addCookie(CookieNom);	
        
		//afficherUtilisateur(request, null);
	}
	
protected void afficherUtilisateur (HttpServletRequest request, PrintWriter Afficher) throws ServletException, IOException {
	Cookie[] AllCookies = request.getCookies();
	
    if (AllCookies != null) {
    	Afficher.println("<p style=\"color:yellow\"> L'utilisateur Precedent est : </p>");
        for (int i = 0 ;i<AllCookies.length;i++) {
            Cookie cookie = AllCookies[i];
   			String A = cookie.getValue();
   			
   			Afficher.println(A);
            }
        }
    }
		
}
