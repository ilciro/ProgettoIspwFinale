package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CartaCreditoBean;
import bean.ExceptionBean;
import bean.LibroBean;
import bean.PagamentoBean;
import bean.SystemBean;
import bean.UserBean;
import it.uniroma2.ispw.database.CartaCreditoDao;
import it.uniroma2.ispw.database.LibroDao;
import it.uniroma2.ispw.database.PagamentoDao;
import it.uniroma2.ispw.model.CartaDiCredito;
import it.uniroma2.ispw.model.Pagamento;
import it.uniroma2.ispw.model.raccolta.Libro;

/**
 * Servlet implementation class ServletPagamentoCC
 */
@WebServlet("/ServletPagamentoCC")
public class ServletPagamentoCC extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ExceptionBean eB=new ExceptionBean();
	private String appoggio="";
	private boolean state=false;
	private int cont;
	private CartaCreditoBean cCB=new CartaCreditoBean();
     private CartaCreditoDao ccD=new CartaCreditoDao();
     private CartaDiCredito cc=new CartaDiCredito();
     private Libro l=new Libro();
     private LibroDao lD=new LibroDao();
     private PagamentoBean pB=new PagamentoBean();
     private LibroBean lB=new LibroBean();
     private PagamentoDao pD=new PagamentoDao();
     private Pagamento p;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPagamentoCC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
		/*
		request.setAttribute("bean2", lB);
		RequestDispatcher view = getServletContext().getRequestDispatcher("/esitoPositivo.jsp"); 
		view.forward(request,response); 
		*/
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome=request.getParameter("nomeU");
		String cognome=request.getParameter("cognomeU");
		String codice=request.getParameter("codiceU");
		String scad=request.getParameter("scadU");
		String pin=request.getParameter("pinU");
		
		if((nome==null || nome=="") || (cognome==null || cognome==""))
		{
			eB.setE(new IllegalArgumentException("nome o cognome null o vuoti"));
			request.setAttribute("bean", eB);
			RequestDispatcher view = getServletContext().getRequestDispatcher("/errore.jsp"); 
			view.forward(request,response); 
		}
		if(controllaPag(scad,codice,pin)==true)
		{
			UserBean.getInstance().setNome(nome);
			UserBean.getInstance().setCognome(cognome);
			cCB.setNomeUser(UserBean.getInstance().getNome());
			cCB.setCognomeUser(UserBean.getInstance().getCognome());
			cCB.setNumeroCC(codice);
			cCB.setCiv(pin);
			
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

		    try {
		        java.util.Date utilDate = format.parse(scad);
		        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		        System.out.println(sqlDate);
		        cCB.setScadenza(sqlDate);
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
			
			
			
			
			
			//inserisco cc
			
			cc.setNomeUser(cCB.getNomeUser());
			cc.setCognomeUser(cCB.getCognomeUser());
			cc.setNumeroCC(cCB.getNumeroCC());
			cc.setScadenza((java.sql.Date)cCB.getScadenza());
			cc.setCiv(cCB.getCiv());
			cc.setAmmontare(SystemBean.getIstance().getSpesaT());
			try {
				ccD.insCC(cc);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			//faccio pagamento
			l.setId(SystemBean.getIstance().getId());
			try {
				lB.setTitolo(lD.getTitolo(l));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			pB.setId(0);
			pB.setMetodo("cc");
			pB.setEsito(0);
			pB.setNomeUtente(UserBean.getInstance().getNome());
			pB.setAmmontare(SystemBean.getIstance().getSpesaT());
			
			p=new Pagamento(pB.getId(), pB.getMetodo(), pB.getEsito(), pB.getNomeUtente(), SystemBean.getIstance().getSpesaT(), SystemBean.getIstance().getType(), SystemBean.getIstance().getId());
			
			try {
				pD.inserisciPagamento(p);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			request.setAttribute("bean",UserBean.getInstance());
			request.setAttribute("bean1", SystemBean.getIstance());
			request.setAttribute("bean2", lB);
			RequestDispatcher view = getServletContext().getRequestDispatcher("/esitoPositivo.jsp"); 
			view.forward(request,response); 

		}

		
	}
	
	public boolean controllaPag(String d, String c,String civ) {
		int x;

		 int anno;
		 int mese;
		 int giorno;
		String[] verifica=null;


		appoggio = appoggio + d;
		  anno = Integer.parseInt((String) appoggio.subSequence(0, 4));
		  mese = Integer.parseInt((String) appoggio.subSequence(5, 7));
		  giorno = Integer.parseInt((String) appoggio.subSequence(8, 10));
		
		if (anno > 2020 && (mese >= 1 && mese <= 12) && (giorno >= 1 && giorno <= 31) && c.length() <= 20 && civ.length()==3 ) {
			
				
					 verifica= c.split("-");
					
					for ( x=0; x<verifica.length; x++) {
							if(verifica[x].length()==4)
							{
								cont++;
							}
					}
					if (cont==4)
					{
						state=true;
					}
					
				

		} 
		
		
		return state;

	}
	




}
