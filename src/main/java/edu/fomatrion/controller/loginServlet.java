package edu.fomatrion.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/form.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");

		try (PrintWriter out = response.getWriter()) {

			if (prenom.equals("jean") && nom.equals("jean")) {

				HttpSession session = request.getSession();
				session.setAttribute("prenom", prenom);
				request.getRequestDispatcher("WEB-INF/final.jsp").forward(request, response);

				out.print("<p>Vous etes connecté</p>");

			} else {
				out.print("<p>Vous etes pas connecté</p>");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
