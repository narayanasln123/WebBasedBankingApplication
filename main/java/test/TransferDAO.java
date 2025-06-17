package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TransferDAO 
{
	public long a=0,hBal=0,cBal=0,fbal=0,lbal=0;
	public long transfer(String accno,String pword,String taccno,long amt)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps1=con.prepareStatement("select * from apana_bank where accno=?");
			PreparedStatement ps2=con.prepareStatement("update apana_bank set amount=amount+? where accno=? and pword=?");
			PreparedStatement ps3=con.prepareStatement("update apana_bank set amount=amount+? where accno=?");
			
			ps1.setString(1, accno);
			
			ResultSet r1 = ps1.executeQuery();
	        if(r1.next())
	        {a=0;
	        	 hBal=Long.parseLong(r1.getString(4));
	        	
	        	 ps1.setString(1, taccno);
	        	 
	        	 ResultSet r2 = ps1.executeQuery();
	        	 
	        	 if(r2.next())
	        	 {a=0;
	        		  	        	 
	        	      if(amt<=hBal)
	        	      {a=0;
	        	      
	        	    	  ps2.setLong(1, -amt);
	        	    	  ps2.setString(2, accno);
	        	    	  ps2.setString(3, pword);
	        	    	  int p = ps2.executeUpdate();
	        	    	  
	        	    	  ps3.setLong(1, +amt);
	        	    	  ps3.setString(2, taccno);
	        	    	  int q=ps3.executeUpdate();
	        	    	  
	        	    	  if(p==1 && q==1)
	        	    	  {
	        	    		  fbal=hBal;
	        	    		  lbal=amt;
	        	    		  a=0;
	        	    	  }
	        	    	  else
	        	    	  {
	        	    		  a=4;
	        	    	  }
	        	    	  
	        	      }
	        	      else
	        	      {
	        	    	  a=3;
	        	      }
	        	 }
	        	 else
	        	 {
	        		 a=2;
	        	 }
	        	 
	        	
	        }
	        else
	        {
	        	a=1;
	        }
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return a;
	}
}
