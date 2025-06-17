package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CloseAccDAO 
{
	public int k=0;
	
	public int delete(String accno,String pword)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps1=con.prepareStatement("delete from apana_bank where accno=? and pword=?");
			ps1.setString(1, accno);
			ps1.setString(2, pword);
			
			k=ps1.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
}
