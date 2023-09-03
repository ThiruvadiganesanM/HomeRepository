package Topics;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ReadPropertiesFile {
	public static void main(String[] args) {
		File f1=new File("C:\Users\ELCOT\Desktop\myfile.txt");
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(f1);
			
			Properties props=new Properties();
			props.load(fis);
			
			System.out.println(props);
			System.out.println(props.getProperty("user"));
			System.out.println(props.getProperty("pass","Uiq@#123"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if(fis!=null) {
				try {
					fis.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
