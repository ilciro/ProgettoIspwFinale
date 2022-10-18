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
 * Servlet implementation class ModificaLibroServlet
 */
@WebServlet("/ModificaLibroServlet")
public class ModificaLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LibroBean lB=new LibroBean();
	private LibroDao lD=new LibroDao();
	private ExceptionBean eB=new ExceptionBean();
	private Libro l=new Libro();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaLibroServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String genera=request.getParameter("generaB");
		String indietro=request.getParameter("buttonB");
		String buttonA=request.getParameter("buttonA");
		String buttonM=request.getParameter("buttonM");
		String id=request.getParameter("idL");
		try {
			if(genera!=null && genera.equals("genera lista"))
			{
				
					lB.setMiaLista(lD.getLibriSingoloList());
					request.setAttribute("bean", lB);
					RequestDispatcher view = getServletContext().getRequestDispatcher("/modificaLibro.jsp"); 
					view.forward(request,response);
				
			}
			if(indietro!=null && indietro.equals("indietro"))
			{
				RequestDispatcher view = getServletContext().getRequestDispatcher("/admin.jsp"); 
				view.forward(request,response);
			}
			if(buttonA!=null && buttonA.equals("aggiungi"))
			{
				
				RequestDispatcher view = getServletContext().getRequestDispatcher("/aggiungiLibro.jsp"); 
				view.forward(request,response);
			}
			if(buttonM!=null && buttonM.equals("modifica"))
			{
				
				if(id==null || id=="")
				{
					eB.setE(new NullPointerException("valore nullo o vuoto"));
					
					request.setAttribute("bean1",eB);
					request.setAttribute("bean",lB);
					

					RequestDispatcher view = getServletContext().getRequestDispatcher("/modificaLibro.jsp"); 
					view.forward(request,response);
				}
				else {
					
					
					SystemBean.getIstance().setId(Integer.parseInt(id));
					l.setId(SystemBean.getIstance().getId());
					lB.setMiaLista(lD.getLibriSingoloByIdLista(l));
					request.setAttribute("bean",lB);
					request.setAttribute("bean2",SystemBean.getIstance());
					RequestDispatcher view = getServletContext().getRequestDispatcher("/modificaLibroFinale.jsp"); 
					view.forward(request,response);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
