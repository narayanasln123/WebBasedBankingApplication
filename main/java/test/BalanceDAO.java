package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BalanceDAO 
{
	//public ArrayList<BalanceDAO> al=new ArrayList<BalanceDAO>();
	public ApanaBankBean b1;
	
	public ApanaBankBean balance(String uname,String pword)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps1=con.prepareStatement("select * from apana_bank where accno=? and pword=?");
			
			ps1.setString(1, uname);
			ps1.setString(2, pword);
			ResultSet r1 = ps1.executeQuery();
			
			if(r1.next())
			{
				b1=new ApanaBankBean();
				b1.setAccno(r1.getString(1));
				b1.setUname(r1.getString(2));
				b1.setPword(r1.getString(3));
				b1.setBalance(r1.getLong(4));
				b1.setAddr(r1.getString(5));
				b1.setPhno(r1.getLong(6));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return b1;
	}

}
