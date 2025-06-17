package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/bal")
public class BalanceServlet extends HttpServlet
{
	public BalanceDAO bd1;
	//public ApanaBankBean a;
	@Override
	public void init() throws ServletException
	{
		bd1=new BalanceDAO();
		//a=new ApanaBankBean();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
				ApanaBankBean a1 = bd1.balance(req.getParameter("accno"), req.getParameter("pword"));
				
				if(a1==null)
				{
					req.setAttribute("msg", "please check username and pasword!!!");
					req.getRequestDispatcher("NoBalance.jsp").forward(req, res);
					
				}
				else
				{
					req.setAttribute("abbean", a1);
					req.getRequestDispatcher("Balance.jsp").forward(req, res);
				}
	}
}
