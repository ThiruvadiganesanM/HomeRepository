package JDBCdemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ReadWriteText {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vastpro","root","Uiq@#123");
	String str="Hai my name is ganesh";
	Character a=18;
	byte[] b=str.getBytes();
	writeBLOB(b,con);
	writeCLOB(str,con);
	readBLOB(con);
}
public static void writeBLOB(byte[] b,Connection con) throws SQLException {
	PreparedStatement pstmt=con.prepareStatement("insert into myfiles(file1) values (?) ");
	pstmt.setBytes(1, b);
	pstmt.execute();
}
public static void writeCLOB(String s,Connection con) throws SQLException {
	PreparedStatement pstmt=con.prepareStatement("insert into myfiles(file2) values (?)");
	pstmt.setString(1,s);
	pstmt.execute();
}
public static void readBLOB(Connection con) throws SQLException {
	PreparedStatement pstmt=con.prepareStatement("select * from myfiles");
	ResultSet rs=pstmt.executeQuery();
	while(rs.next()) {
		System.out.println(rs.getInt(1));
		byte[] b=rs.getBytes(2);
		if(b!=null) {
			String s=new String(b);
			System.out.println(s);
		}
		System.out.println(rs.getString(3));
	}
}
}
