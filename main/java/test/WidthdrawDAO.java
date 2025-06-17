package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WidthdrawDAO 
{
	public ApanaBankBean ab=null;
	public int k=0;
	
	public ApanaBankBean widthdraw(String accno,String pword,Long amt)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps1=con.prepareStatement("update apana_bank set amount=amount-? where accno=? and pword=?");
			PreparedStatement ps2=con.prepareStatement("select * from apana_bank where accno=? and pword=?");
			ps1.setLong(1, amt);
			ps1.setString(2, accno);
			ps1.setString(3, pword);
			
			k=ps1.executeUpdate();
			if(k>0)
			{
				ps2.setString(1, accno);
				ps2.setString(2, pword);
				ResultSet r1 = ps2.executeQuery();
				
				if(r1.next())
				{
					ab=new ApanaBankBean();
					ab.setAccno(r1.getString(1));
					ab.setUname(r1.getString(2));
					ab.setPword(r1.getString(3));
					ab.setBalance(r1.getLong(4));
					ab.setAddr(r1.getString(5));
					ab.setPhno(r1.getLong(6));
				}
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ab;
	}
}
