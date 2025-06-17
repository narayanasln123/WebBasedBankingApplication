package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/dpt")
@SuppressWarnings("serial")
public class DepositServlet extends HttpServlet
{
	public DepositDAO d=null;
	@Override
	public void init() throws ServletException
	{
		d=new DepositDAO();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		ApanaBankBean ab = d.deposit1(req.getParameter("accno"), Long.parseLong(req.getParameter("amt")),req.getParameter("pword"));
		
		if(ab==null)
		{
			req.setAttribute("msg", "password or accno worng please re-entet!!!!!");
			req.getRequestDispatcher("NotDeposit.jsp").forward(req, res);
		}
		else
		{
			HttpSession hs = req.getSession();
			hs.setAttribute("bank01", ab);
			req.setAttribute("abbean1", ab);
			req.getRequestDispatcher("deposit.jsp").forward(req, res);
		}
	}
	

}
