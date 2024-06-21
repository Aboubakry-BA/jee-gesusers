package forms;

import beans.Utilisateur;
import dao.UtilisateurDao;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class AddUserForm {
	// Constantes
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASSWORD = "password";
	private static final String CHAMP_PASSWORD_BIS = "passwordBis";
	private static final String FIELD_MESSAGE = "Veuillez renseigner ce champ";
	private static final String WRONG_PASSWORD = "Les mots de passe ne correspondent pas";

	private HttpServletRequest request;
	private Map<String, String> erreurs;
	private boolean status;
	private String statusMessage;
	private Utilisateur utilisateur;

	public AddUserForm(HttpServletRequest request) {

		this.status = false;
		this.request = request;
		this.erreurs = new HashMap<String, String>();
	}

	public boolean ajouter() {
		String nom = getParameter(CHAMP_NOM);
		String prenom = getParameter(CHAMP_PRENOM);
		String login = getParameter(CHAMP_LOGIN);
		String password = getParameter(CHAMP_PASSWORD);

		this.utilisateur = new Utilisateur(nom, prenom, login, password);
		validerChamps(CHAMP_NOM, CHAMP_PRENOM, CHAMP_LOGIN, CHAMP_PASSWORD, CHAMP_PASSWORD_BIS);
		validerPassword();

		if (erreurs.isEmpty()) {
			status = true;
			statusMessage = "L'ajout a été effectué avec succès";
			UtilisateurDao.ajouter(utilisateur);

		}

		else {
			status = false;
			statusMessage = "L'ajout a échoué ! Réessayer";

		}

		return status;
	}

	private String getParameter(String parametre) {
		// TODO Auto-generated method stub
		String valeur = request.getParameter(parametre);

		return (valeur == null || valeur.trim().isEmpty()) ? null : valeur.trim();

	}

	private void validerChamps(String... parametres) {
		for (String parametre : parametres) {
			if (this.getParameter(parametre) == null) {
				erreurs.put(parametre, FIELD_MESSAGE);
			}
		}

	}

	private void validerPassword() {
		String password = this.getParameter(CHAMP_PASSWORD);
		String passwordBis = this.getParameter(CHAMP_PASSWORD_BIS);

		if (password != null && !password.equals(passwordBis)) {
			erreurs.put(CHAMP_PASSWORD, WRONG_PASSWORD);
			erreurs.put(CHAMP_PASSWORD_BIS, WRONG_PASSWORD);

		}

	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public boolean getStatus() {
		return status;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

}
