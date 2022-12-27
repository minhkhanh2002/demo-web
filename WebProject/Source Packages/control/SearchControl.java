package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.Catalog_id;
import entity.Product;

/**
 * Servlet implementation class SearchControl
 */
@WebServlet(name="/SearchControl", urlPatterns = {"/search"})
public class SearchControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8"); //set search được tiếng việt
		String txtSearch = request.getParameter("txt");//lấy được dữ liệu người dùng nhập vào ở ô tìm kiếm
		DAO dao = new DAO();
		List<Product> list = dao.searchByName(txtSearch);
		List<Catalog_id> listC = dao.getAllCatalog_id();
		
		request.setAttribute("listP", list);		
		request.getRequestDispatcher("idex.html").forward(request, response);
	}   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchControl() {
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

	 
	
}
