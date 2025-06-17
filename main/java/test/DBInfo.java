package test;

//public interface DBInfo 
//{
//	public static final String driver="oracle.jdbc.driver.OracleDriver";
//	public static final String dbUrl="jdbc:oracle:thin:@localhost:1521:orcl";
//	public static final String uName="system";
//	public static final String pword="1234";
//}
//public interface DBInfo {
//    String driver = "oracle.jdbc.driver.OracleDriver";
//    String dbUrl  = "jdbc:oracle:thin:@//localhost:1521/orcl";  // Use Service Name here
//    String uName  = "system";
//    String pword  = "1234";
//}
// my sql
public interface DBInfo 
{
	public static final String driver="com.mysql.cj.jdbc.Driver";
	public static final String dbUrl="jdbc:mysql:///db01";
	public static final String uName="root";
	public static final String pword="mydb9am";
}