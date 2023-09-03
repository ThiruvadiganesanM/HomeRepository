package JDBCDemo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadConnection {
public static void main(String[] args) {
	ExecutorService es=Executors.newFixedThreadPool(2);
	es.execute(()->{
		try {
			Connection con=ConnectionUtility.getConnection();
			System.out.println("Thread 1"+con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	});
	
	es.execute(()->{
		try {
			Connection con=ConnectionUtility.getConnection();
			System.out.println("Thread 2"+con);
			
			Connection con1=ConnectionUtility.getConnection();
			System.out.println("Thread 3"+con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	});
	es.shutdown();
}
}
