package Myinit;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class MyWebInitContextListener implements ServletContextListener {

   
    public MyWebInitContextListener() {
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
    	  try {
    	ServletContext application=sce.getServletContext();
        Properties prop=new Properties();
       String path= application.getRealPath("/WEB-INF/dbconfig.properties");
			prop.load(new FileInputStream(path));
			application.setAttribute("prop", prop);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
}
