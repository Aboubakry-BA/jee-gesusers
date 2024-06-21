package forms;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import dao.UtilisateurDao;

public class LoginForm {
	private String CHAMP_LOGIN = "login";
	private String CHAMP_PASSWORD = "password";

	private boolean status;
	private String statusMessage;
	private Utilisateur utilisateur;
	private HttpServletRequest request;
	private String login;
	private final String WRONG_PASSWORD = "Les mots de passe ne sont pas conformes";

	public LoginForm(HttpServletRequest request) {
		this.request = request;
		this.status = false;
		this.statusMessage = "echec";
	}

	public boolean login() {
		String login = getParameter(CHAMP_LOGIN);
		String password = getParameter(CHAMP_PASSWORD);

		Utilisateur utilisateur = UtilisateurDao.getLogin(login);

		if (utilisateur != null && utilisateur.getPassword().equals(password)) {
			status = true;
			HttpSession session = request.getSession();
			session.setAttribute("isConnected", true);

		}
		return status;
	}

	public String getParameter(String parametre) {
		String valeur = request.getParameter(parametre);
		return (valeur == null || valeur.trim().isEmpty()) ? null : valeur.trim();
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public Object getLogin() {
		return login;
	}
}
