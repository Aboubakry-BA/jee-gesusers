package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import dao.ConnectUser;

/**
 * Servlet implementation class UserAuthentification
 */
@WebServlet("/authentifierUser")
public class UserAuthentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_USER = "/WEB-INF/connexion.jsp";
	private static final String ATT_FORM = "form";
	private static final String ATT_USER = "utilisateur";
	private static final String ATT_SESSION_USER = "sessionUser";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserAuthentification() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher(VUE_USER).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ConnectUser form = new ConnectUser();
		Utilisateur utilisateur = form.connectUtilisateur(request);
		HttpSession session = request.getSession();

		if (form.isStatus()) {
			request.setAttribute(ATT_FORM, form);
			response.sendRedirect("list");
		} else {

			request.setAttribute(ATT_SESSION_USER, null);
			request.setAttribute(ATT_FORM, form);
			request.setAttribute(ATT_USER, utilisateur);

		}

		this.getServletContext().getRequestDispatcher(VUE_USER).forward(request, response);
	}

}
