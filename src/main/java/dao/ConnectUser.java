package dao;
import beans.Utilisateur;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
public class ConnectUser {
	private static final String ERROR_MESSAGE = "Les données fournies sont incorrectes";
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASSWORD = "password";
	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();
	private Object request;
	public String getResultat() {
		return resultat;
	}
	public Map<String, String> getErreurs() {
		return erreurs;
	}
	
	public Utilisateur connectUtilisateur(HttpServletRequest request) {
		String login = getParameter(request, CHAMP_LOGIN);
		String password = getParameter(request, CHAMP_PASSWORD);
		Utilisateur utilisateur = new Utilisateur();
		
		try {
			validerLogin(login);
		} catch (Exception e) {
			setErreur(CHAMP_LOGIN, e.getMessage());
		}
		utilisateur.setLogin(login);
		
		try {
			validerPassword(password);
			
		} catch(Exception e) {
			setErreur(CHAMP_PASSWORD, e.getMessage());
		}
		utilisateur.setPassword(password);
		
		if(erreurs.isEmpty()) {
			resultat = "La connexion a réussi";
		}
		else {
			resultat = "La connexion a échoué";
		}
		
		return utilisateur;
		
		
	}
	private void validerPassword(String password) throws Exception {
		// TODO Auto-generated method stub
		if(password != null) {
			throw new Exception("Veuillez saisir un mot de passe valide");
		}
		
	}
	private void validerLogin(String login) throws Exception{
		// TODO Auto-generated method stub
		if(login != null) {
			throw new Exception("Veuillez saisir un nom d'utilisateur valide");
		}
		
	}
	private void setErreur(String champ, String message) {
		// TODO Auto-generated method stub
		erreurs.put(champ, message);
		
	}
	private String getParameter(HttpServletRequest request, String parametre) {
		// TODO Auto-generated method stub
		String valeur = request.getParameter(parametre);
		
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		}
		else {
			return valeur;
		}
	}
	public boolean isStatus1() {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean isStatus() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	
	
	
}
