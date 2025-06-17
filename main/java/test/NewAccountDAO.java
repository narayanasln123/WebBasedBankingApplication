package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NewAccountDAO 
{
	public int k=0;
	public int add(ApanaBankBean ab)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps1=con.prepareStatement("insert into APANA_BANK values(SQ1.NEXTVAL,?,?,?,?,?)");
			
			PreparedStatement ps2=con.prepareStatement("select * from apana_bank where pword=?");
			
		//	String accno="sq2.nextval";
			
			//ps1.setString(1, accno);
			ps1.setString(1, ab.getUname());
			ps1.setString(2, ab.getPword());
			ps1.setLong(3, ab.getBalance());
			ps1.setString(4, ab.getAddr());
			ps1.setLong(5, ab.getPhno());
			
			k=ps1.executeUpdate();
			if(k>0)
			{
				ps2.setString(1, ab.getPword());
				ResultSet r1 = ps2.executeQuery();
				
				if(r1.next())
				{
					ab.setAccno(r1.getString(1));
					ab.setUname(r1.getString(2));
					ab.setPword(r1.getString(3));
					ab.setBalance(Long.parseLong(r1.getString(4)));
					ab.setAddr(r1.getString(5));
					ab.setPhno(Long.parseLong(r1.getString(6)));
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}

}
