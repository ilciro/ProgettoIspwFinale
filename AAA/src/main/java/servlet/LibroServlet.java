package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ExceptionBean;
import bean.LibroBean;
import bean.SystemBean;
import it.uniroma2.ispw.database.LibroDao;
import it.uniroma2.ispw.model.raccolta.Libro;



/**
 * Servlet implementation class LibroServlet
 */
@WebServlet("/LibroServlet")
public class LibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LibroBean lB=new LibroBean();
	private LibroDao lD=new LibroDao();
	private Libro lib=new Libro();
	private ExceptionBean bE=new ExceptionBean();
	

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
		lB.setId(id);
		
		
		try {
			
		

		 
			
		
		
		//controllo id 
		if(Integer.parseInt(id)==0)
		{
			
			
			
				lB.setMiaLista(lD.getLibriSingoloList());
			

			SystemBean.getIstance().setType("libro");
			SystemBean.getIstance().setElemLista(lB.getMiaLista().size());
			request.setAttribute("bean1",SystemBean.getIstance());
	        request.setAttribute("bean",lB); 
	        


				RequestDispatcher view = getServletContext().getRequestDispatcher("/libri.jsp"); 
				view.forward(request,response); 
		

		 
				
		}
		else if(Integer.parseInt(id)>1 ){
			lib.setId(Integer.parseInt(lB.getId()));
			
			
			lB.setMiaLista(lD.getLibriSingoloByIdLista(lib));
			
			if( Integer.parseInt(id)<lB.getMiaLista().size())
			{
			
				request.setAttribute("bean",lB);  

			
				RequestDispatcher view = getServletContext().getRequestDispatcher("/mostraLibro.jsp"); 
				view.forward(request,response); 
			}
			else {
				//i maggiore di dimensione lista
				bE.setE(new NumberFormatException("numero eccede la lista"));
				request.setAttribute("bean1",bE);
				RequestDispatcher view = getServletContext().getRequestDispatcher("/errore.jsp"); 
				view.forward(request,response); 
			}
				
		}
		
		
		
		else {
			bE.setE(new NumberFormatException("numero minore di 0 "));
			request.setAttribute("bean1",bE);
			RequestDispatcher view = getServletContext().getRequestDispatcher("/errore.jsp"); 
			view.forward(request,response); 
		}
	
		
			
		
		
			
		} catch (SQLException| ServletException| NumberFormatException e) {
			bE.setE(e);
		
			request.setAttribute("bean1",bE);
			RequestDispatcher view = getServletContext().getRequestDispatcher("/errore.jsp"); 
			view.forward(request,response); 
		}
		
		
		
		
	}

}
