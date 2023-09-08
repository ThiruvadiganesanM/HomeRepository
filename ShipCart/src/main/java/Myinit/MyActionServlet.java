package Myinit;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/MyActionServlet","*.do"})
public class MyActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MyRequestProcessor mrp;
    public MyActionServlet() {
        super();
    }
    public void init(ServletConfig config) {
    	mrp=new MyRequestProcessor();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		mrp.process(request, response);
	}

}
