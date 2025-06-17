package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DepositDAO 
{
	public ApanaBankBean ab1=null;
	public int k=0;
	
	public ApanaBankBean deposit1(String accno,long amt,String pword)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps1=con.prepareStatement("update apana_bank set amount=amount+? where accno=?");
			PreparedStatement ps2=con.prepareStatement("select * from apana_bank where accno=? and pword=?");
			
			ps1.setLong(1, amt);
			ps1.setString(2, accno);
			
			k=ps1.executeUpdate();
			if(k>0)
			{
				ps2.setString(1, accno);
				ps2.setString(2, pword);
				 
				ResultSet r1 = ps2.executeQuery();
				
				if(r1.next())
				{
					ab1=new ApanaBankBean();
					ab1.setAccno(r1.getString(1));
					ab1.setUname(r1.getString(2));
					ab1.setPword(r1.getString(3));
					ab1.setBalance(r1.getLong(4));
					ab1.setAddr(r1.getString(5));
					ab1.setPhno(r1.getLong(6));
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ab1;
		
	}

}
