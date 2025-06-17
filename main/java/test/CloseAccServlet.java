package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/close")
@SuppressWarnings("serial")
public class CloseAccServlet extends HttpServlet
{
	public CloseAccDAO ca=null;
	
	@Override
	public void init() throws ServletException 
	{
		ca=new CloseAccDAO();		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		int k = ca.delete(req.getParameter("accno"), req.getParameter("pword"));
		
		if(k==0)
		{
			req.getRequestDispatcher("NotDeleted.jsp").forward(req, res);
		}
		else
		{
			req.setAttribute("accno", req.getParameter("accno"));
			req.setAttribute("aname", req.getParameter("uname"));
			req.getRequestDispatcher("Deleted.jsp").forward(req, res);
		}
		
	}
}
