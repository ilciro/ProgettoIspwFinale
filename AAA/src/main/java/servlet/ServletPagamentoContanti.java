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
import bean.FatturaBean;
import bean.LibroBean;
import bean.PagamentoBean;
import bean.SystemBean;
import bean.UserBean;
import it.uniroma2.ispw.database.ContrassegnoDao;
import it.uniroma2.ispw.database.LibroDao;
import it.uniroma2.ispw.database.PagamentoDao;
import it.uniroma2.ispw.model.Fattura;
import it.uniroma2.ispw.model.Pagamento;
import it.uniroma2.ispw.model.raccolta.Libro;

/**
 * Servlet implementation class ServletPagamentoContanti
 */
@WebServlet("/ServletPagamentoContanti")
public class ServletPagamentoContanti extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ExceptionBean bE=new ExceptionBean();
	private PagamentoBean pB=new PagamentoBean();
	private FatturaBean fB=new FatturaBean();
	private PagamentoDao pD=new PagamentoDao();
	private ContrassegnoDao fD=new ContrassegnoDao();
	private Pagamento p;
	private Fattura f;
	private LibroBean lB=new LibroBean();
	private LibroDao lD=new LibroDao();
	private Libro l=new Libro();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPagamentoContanti() {
        super();
        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome=request.getParameter("nomeU");
		String cognome=request.getParameter("cognomeU");
		String via=request.getParameter("viaU");
		String com=request.getParameter("comunicaU");
		
		UserBean.getInstance().setNome(nome);
		UserBean.getInstance().setCognome(cognome);
		UserBean.getInstance().setVia(via);
		UserBean.getInstance().setCom(com);
		
		if(((nome==null || nome=="")||(cognome==null || cognome=="") || (via==null || via=="")))
		{
			bE.setE(new Exception("dati non corretti "));
			request.setAttribute("bean1",bE);
			RequestDispatcher view = getServletContext().getRequestDispatcher("/errore.jsp"); 
			view.forward(request,response); 
			
		}
		else {
			//faccio pagamento
			l.setId(SystemBean.getIstance().getId());
			try {
				lB.setTitolo(lD.getTitolo(l));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			pB.setId(0);
			pB.setMetodo("cash");
			pB.setEsito(0);
			pB.setNomeUtente(UserBean.getInstance().getNome());
			pB.setAmmontare(SystemBean.getIstance().getSpesaT());
			
			p=new Pagamento(pB.getId(), pB.getMetodo(), pB.getEsito(), pB.getNomeUtente(), SystemBean.getIstance().getSpesaT(), SystemBean.getIstance().getType(), SystemBean.getIstance().getId());
			
			//faccio fattura
			fB.setNome(nome);
			fB.setCognome(cognome);
			fB.setVia(via);
			fB.setCom(com);
			fB.setNumero("0");
			fB.setAmmontare(SystemBean.getIstance().getSpesaT());
			
			f=new Fattura(fB.getNome(),fB.getCognome(),fB.getVia(),fB.getCom(),fB.getNumero(),SystemBean.getIstance().getSpesaT());
			
			try {
				pD.inserisciPagamento(p);
				fD.inserisciFattura(f);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("bean",UserBean.getInstance());
			request.setAttribute("bean1", SystemBean.getIstance());
			request.setAttribute("bean2", lB);
			RequestDispatcher view = getServletContext().getRequestDispatcher("/esitoPositivo.jsp"); 
			view.forward(request,response); 
			
		}
		
	}

}
