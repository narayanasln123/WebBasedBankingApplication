package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/transfer")
@SuppressWarnings("serial")
public class TransferServlet extends HttpServlet
{
	public TransferDAO td=null;
	@Override
	public void init() throws ServletException
	{
		td=new TransferDAO();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String accno=req.getParameter("accno");
		String uname=req.getParameter("uname");
		String pword=req.getParameter("pword");
		String taccno=req.getParameter("taccno");
		long amt=Long.parseLong(req.getParameter("amt"));
		
		long a = td.transfer(accno, pword, taccno, amt);
		
		if(a==0)
		{
			req.setAttribute("fbal", td.fbal);
			req.setAttribute("lbal", td.lbal);
			req.getRequestDispatcher("Transfer.jsp").forward(req, res);
		}
		else if(a==1)
		{
			req.setAttribute("msg", "Sender Acount Not available");
			req.getRequestDispatcher("NotTransfer.jsp").forward(req, res);
		}
		else if(a==2)
		{
			req.setAttribute("msg", "Reciver Acount Not available");
			req.getRequestDispatcher("NotTransfer.jsp").forward(req, res);
		}
		else if(a==3)
		{
			req.setAttribute("msg", "Balance  Not Sufficent in Sender Account");
			req.getRequestDispatcher("NotTransfer.jsp").forward(req, res);
		}
		else
		{
			req.setAttribute("msg", "Balance not Transfer");
			req.getRequestDispatcher("NotTransfer.jsp").forward(req, res);
		}
	}
}
