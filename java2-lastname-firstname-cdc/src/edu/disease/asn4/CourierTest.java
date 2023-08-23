package Assignments;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class CourierTest {
	
	@Test
	public void testConstructor() {
		Courier c1=new Courier();
	}
	
	@Test
	public void testGetDeliveryTime() {
		Courier c2=new Courier();
		assertNotNull(c2.getDeliveryTime(LocalDateTime.of(2023,8,23,22,00)));
		assertNotNull(c2.getDeliveryTime(LocalDateTime.of(2023,8,25,22,00)));
		
	}
	@Test
	public void testGetDeliveryTime2(){
		Courier c3=new Courier();
		assertNotNull(c3.getDeliveryTime(LocalDateTime.of(2023,8,26,2,00)));
	}
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
