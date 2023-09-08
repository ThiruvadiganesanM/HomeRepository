package Myinit;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ActionClasses.MyAction;

public class MyRequestProcessor {
	public void process(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServletContext ctx = request.getServletContext();
			Properties prop = new Properties();
			prop = (Properties) ctx.getAttribute("prop");
			String formId = request.getParameter("formid");
			String actionClass = prop.getProperty(formId);
			System.out.println(actionClass);
			MyAction myAction = (MyAction) Class.forName(actionClass).getConstructor().newInstance();
			String result = myAction.execute(request, response);
			String nextPage = prop.getProperty(result);
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException | ServletException
				| IOException e) {
			e.printStackTrace();
		}
	}
}
