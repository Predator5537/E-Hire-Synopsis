package GetConnection;
import java.sql.*;
public class GetData {
static Connection cn=null;
static String driver="com.ibm.db2.jcc.DB2Driver";
static String url="jdbc:db2://localhost:50000/ehire";
static String user ="1603193";
static String pass="prasun@23";
public static Connection getCn(){
	try{
		Class.forName(driver);//*creating an instance of driver class*?//
		cn=DriverManager.getConnection(url,user,pass);
	}catch(Exception e){
		System.out.println(e);
	}
return cn;}
}
