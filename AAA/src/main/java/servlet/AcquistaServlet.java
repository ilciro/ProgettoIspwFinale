package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AcquistaBean;
import bean.LibroBean;

/**
 * Servlet implementation class AcquistaServlet
 */
@WebServlet("/AcquistaServlet")
public class AcquistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
	
		String id=request.getParameter("idL");
		LibroBean lB=new LibroBean();
		lB.setId(id);
		
		String quantita=request.getParameter("quantitaLabel");
		System.out.println("quantita in post :"+quantita);
		
		try {
		//controllo id 
		if(Integer.parseInt(id)>=1 && Integer.parseInt(id)<20){
			
				RequestDispatcher view = getServletContext().getRequestDispatcher("/acquista.jsp"); 
				view.forward(request,response); 
				
		}
		else {
			RequestDispatcher view = getServletContext().getRequestDispatcher("/index.html"); 
			view.forward(request,response); 
		}
	
			
			
		
		} catch (ServletException| NumberFormatException e) {
			e.printStackTrace();
		}
		//setto listaLibri di tipo lista
		
		
		
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String quantita=request.getParameter("quantitaLabel");
		System.out.println("quntita in servletAcquista"+quantita);

		AcquistaBean aB=new AcquistaBean();
		try {
			
		
		aB.setQuantita(Integer.parseInt(quantita));
		}catch(NumberFormatException e)
		{
			e.getMessage();
		}
	}
}
