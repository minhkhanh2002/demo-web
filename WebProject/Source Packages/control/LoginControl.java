package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.Account;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet(name="/LoginControl", urlPatterns = {"/login"})
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void processRequset (HttpServletRequest request, HttpServletResponse response)
		       throws ServletException, IOException{
			response.setContentType("text/html;charset=UTF-8");
			String username = request.getParameter("uname");
			String password = request.getParameter("pass");
			DAO dao = new DAO();
			Account a = dao.login(username, password);
			if (a== null) {
				request.getRequestDispatcher("login.html").forward(request, response);
			} else {
				request.getRequestDispatcher("home").forward(request, response);
			}
			
			
			
}
}