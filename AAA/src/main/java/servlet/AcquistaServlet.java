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
//import bean.AcquistaBean;
import bean.LibroBean;
import bean.SystemBean;
import it.uniroma2.ispw.database.LibroDao;
import it.uniroma2.ispw.model.raccolta.Libro;

/**
 * Servlet implementation class AcquistaServlet
 */
@WebServlet("/AcquistaServlet")
public class AcquistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LibroDao lD=new LibroDao();
	private Libro lib=new Libro();
	private LibroBean lB=new LibroBean();
	private ExceptionBean bE=new ExceptionBean();
	//private AcquistaBean aB=new AcquistaBean();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcquistaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		try {
			String id=request.getParameter("idL");
			lB.setId(id);		

			
			String nome;
			float costo;
			int disp;
			
			lib.setId(Integer.parseInt(lB.getId()));
			System.out.println("id :" +lB.getId());
		//controllo id 
			
		if(Integer.parseInt(id)>=1 && Integer.parseInt(id)<SystemBean.getIstance().getElemLista()){
			
			nome=lD.getNome(lib);
			costo=lD.getCosto(lib);
			disp=lD.getDisp(lib);
			
			lB.setTitolo(nome);
			lB.setPrezzo(costo);
			lB.setDisponibilita(disp);
			
			
			

			
			SystemBean.getIstance().setId(Integer.parseInt(id));
			
	        System.out.println("id del libro in acquista servlet dopo :"+SystemBean.getIstance().getId());

			

			 request.setAttribute("bean",lB);  
			 request.setAttribute("bean1", SystemBean.getIstance());
				RequestDispatcher view = getServletContext().getRequestDispatcher("/acquista.jsp"); 
				view.forward(request,response); 
				
		}
		else {
			bE.setE(new NumberFormatException("elemento non in lista"));
			 request.setAttribute("bean1",bE);
			RequestDispatcher view = getServletContext().getRequestDispatcher("/errore.jsp"); 
			view.forward(request,response); 
			
		}
		
		} catch (ServletException| NumberFormatException |SQLException e) {
			bE.setE(e);
			 request.setAttribute("bean1",bE);
			RequestDispatcher view = getServletContext().getRequestDispatcher("/errore.jsp"); 
			view.forward(request,response); 
		}
		

		
		
		
	}

}
