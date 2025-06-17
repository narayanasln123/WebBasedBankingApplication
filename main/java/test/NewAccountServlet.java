package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/newAcc")
@SuppressWarnings("serial")
public class NewAccountServlet extends HttpServlet
{
	public NewAccountDAO na=null;
	public ApanaBankBean ab=null;
	@Override
	public void init() throws ServletException 
	{
		na=new NewAccountDAO();
		ab=new ApanaBankBean();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String pword=req.getParameter("pword");
		String repword=req.getParameter("repword");
		
		if(pword.equals(repword))
		{
			
			ab.setUname(req.getParameter("uname"));
			ab.setPword(req.getParameter("pword"));
			ab.setBalance(Long.parseLong(req.getParameter("amt")));
			ab.setAddr(req.getParameter("addr"));
			ab.setPhno(Long.parseLong(req.getParameter("phno")));
			
			int k = na.add(ab);
			if(k>0)
			{
				req.setAttribute("abbean", ab);
				req.getRequestDispatcher("addedsucces.jsp").forward(req, res);
			}
			
			
		}
		else
		{
			req.setAttribute("msg", "password not matching with re_password!!!!!!!!!!!");
			req.getRequestDispatcher("NotAdded.jsp").forward(req, res);
		}
	}
}
