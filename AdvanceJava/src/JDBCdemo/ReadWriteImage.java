package JDBCdemo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class ReadWriteImage {
public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vastpro","root","Uiq@#123");
	PreparedStatement pstmt=con.prepareStatement("insert into myimages(image) values(?)");
	pstmt.setBytes(1, getImageToByte("bird.png"));
	pstmt.execute();
	
	
}
private static byte[] getImageToByte(String path) throws IOException {
	FileInputStream fis=new FileInputStream(path);
	byte[] b=new byte[fis.available()];
	return b;
}
}










