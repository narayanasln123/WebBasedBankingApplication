package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/wdt")
public class WidthdrawServlet extends HttpServlet
{
	public WidthdrawDAO wd;
	@Override
	public void init() throws ServletException 
	{
		wd=new WidthdrawDAO();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		ApanaBankBean ab = wd.widthdraw(req.getParameter("accno"), req.getParameter("pword"), Long.parseLong(req.getParameter("amt")));
		
		if(ab==null)
		{
			req.getRequestDispatcher("NotWidthdraw.jsp").forward(req, res);
		}
		else
		{
			req.setAttribute("abbean", ab);
			req.getRequestDispatcher("Widthdraw.jsp").forward(req, res);
		}
	}
}
