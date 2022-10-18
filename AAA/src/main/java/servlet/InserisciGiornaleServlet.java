package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ExceptionBean;
import bean.GiornaleBean;
import bean.SystemBean;
import it.uniroma2.ispw.database.GiornaleDao;
import it.uniroma2.ispw.model.raccolta.Giornale;

/**
 * Servlet implementation class InsertisciGionaleServlet
 */
@WebServlet("/InserisciGiornaleServlet")
public class InserisciGiornaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  java.util.Date utilDate;
    private java.sql.Date sqlDate;
    private GiornaleBean gB=new GiornaleBean();
    private GiornaleDao gD=new GiornaleDao();
    private Giornale g=new Giornale();
    private ExceptionBean eB=new ExceptionBean();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserisciGiornaleServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SystemBean.getIstance().setType("giornale");

		String titolo=request.getParameter("titoloG");
		String tipo=request.getParameter("tipoG");
		String lingua=request.getParameter("linguaG");
		String editore=request.getParameter("editoreG");
		String data=request.getParameter("dataG");
		String copieG=request.getParameter("copieG");
		String disp=request.getParameter("dispG");
		String prezzo=request.getParameter("prezzoG");
		String buttonC=request.getParameter("confermaB");
		String buttonA=request.getParameter("annullaB");
		
		if(buttonC!=null && buttonC.equals("conferma"))
		{
			
			if(data!=null)
			{
				gB.setTitolo(titolo);
				gB.setTipologia(tipo);
				gB.setLingua(lingua);
				gB.setEditore(editore);
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
	
			    try {
			         utilDate = format.parse(data);
			        sqlDate = new java.sql.Date(utilDate.getTime());
			        System.out.println(sqlDate);
			        gB.setDate(sqlDate);
			    } catch (ParseException e) {
			        e.printStackTrace();
			    }
			    gB.setCopieRimanenti(Integer.parseInt(copieG));
			    gB.setDisponibilita(Integer.parseInt(disp));
			    gB.setPrezzo(Float.parseFloat(prezzo));
			    
			    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/d");
				  String date = data;
	
				  //convert String to LocalDate
				  LocalDate localDate = LocalDate.parse(date, formatter);
				  
				  g.setTitolo(gB.getTitolo());
				  g.setTipologia(gB.getTipologia());
				  g.setLingua(gB.getLingua());
				  g.setEditore(gB.getEditore());
				  g.setDataPubb(localDate);
				  g.setCopieRimanenti(gB.getCopieRimanenti());
				  g.setDisponibilita(gB.getDisponibilita());
				  g.setPrezzo(gB.getPrezzo());
				  
				  try {
					if(gD.creaGiornale(g)==true)
					{
						gB.aggiornaData(g, sqlDate);
						request.setAttribute("bean", gB);
						RequestDispatcher view = getServletContext().getRequestDispatcher("/modificaGiornale.jsp"); 
						view.forward(request,response); 
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			else {
				eB.setE(new Exception(" data nulla"));
				RequestDispatcher view = getServletContext().getRequestDispatcher("/aggiungiGiornale.jsp"); 
				view.forward(request,response); 
			}
		}
		if(buttonA!=null && buttonA.equals("indietro"))
		{
			RequestDispatcher view = getServletContext().getRequestDispatcher("/modificaGiornale.jsp"); 
			view.forward(request,response); 
		}
		
	}

}
