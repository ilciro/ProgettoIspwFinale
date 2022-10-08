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
import bean.SystemBean;
import it.uniroma2.ispw.database.ContrassegnoDao;
import it.uniroma2.ispw.database.LibroDao;
import it.uniroma2.ispw.database.PagamentoDao;
import it.uniroma2.ispw.model.raccolta.Libro;

/**
 * Servlet implementation class CancellaPagamentoServlet
 */
@WebServlet("/CancellaPagamentoServlet")
public class CancellaPagamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ExceptionBean eB=new ExceptionBean();
	private ContrassegnoDao fD=new ContrassegnoDao();
	private PagamentoDao pD=new PagamentoDao();
	private Libro l=new Libro();
	private LibroDao lD=new LibroDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancellaPagamentoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("idCanc");
		if(Integer.parseInt(id)<0)
		{
			eB.setE(new NumberFormatException(" id pagamento minore di 0"));
			request.setAttribute("bean",eB);
			RequestDispatcher view = getServletContext().getRequestDispatcher("/errore.jsp"); 
			view.forward(request,response);
		}
		else if(Integer.parseInt(id)>SystemBean.getIstance().getElemListaPag())
		{
			eB.setE(new NumberFormatException(" id pagamento maggiori di quello di utente"));
			request.setAttribute("bean",eB);
			RequestDispatcher view = getServletContext().getRequestDispatcher("/errore.jsp"); 
			view.forward(request,response);
		}
		else
		{
			boolean delF,delP;
			try {
				delF=fD.annullaOrdine(Integer.parseInt(id));
				delP=pD.annullaOrdine(Integer.parseInt(id));
				if(delF && delP)
				{
					l.setId(SystemBean.getIstance().getId());
					lD.aggiornaDisponibilita(l);
					
					request.setAttribute("bean", SystemBean.getIstance());
					RequestDispatcher view = getServletContext().getRequestDispatcher("/index.html"); 
					view.forward(request,response);
				}
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

}
