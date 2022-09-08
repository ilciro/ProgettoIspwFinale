package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.LibroBean;



/**
 * Servlet implementation class LibroServlet
 */
@WebServlet("/LibroServlet")
public class LibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("idL");
		LibroBean lB=new LibroBean();
		lB.setId(id);
		
		try {
		//controllo id 
		if(Integer.parseInt(id)==0)
		{
			
			
				

				RequestDispatcher view = getServletContext().getRequestDispatcher("/libri.jsp"); 
				view.forward(request,response); 
					
				
				
		}
		else if(Integer.parseInt(id)>1 && Integer.parseInt(id)<20){
			
				RequestDispatcher view = getServletContext().getRequestDispatcher("/mostraLibro.jsp"); 
				view.forward(request,response); 
				
		}
		else {
			RequestDispatcher view = getServletContext().getRequestDispatcher("/index.jsp"); 
			view.forward(request,response); 
		}
	
			
			
		
		} catch (ServletException| NumberFormatException e) {
			e.printStackTrace();
		}
		//setto listaLibri di tipo lista
		
		
		
		
	}

}
