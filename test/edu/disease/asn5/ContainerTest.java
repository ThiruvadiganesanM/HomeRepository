package edu.disease.asn5;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ContainerTest {
	String s="Ganesh";
	String i="Naren";
	Container<String> c1=new Container<>(s,i);
@Test
public void testConstructor() {
	assertThrows(IllegalArgumentException.class, ()->{Container<String> c=new Container<>();});
	
}

@Test
public void testSize() {
	
	System.out.println(c1.size());
	assertNotNull(c1.size());
}

@Test
public void testGet() {
	assertNotNull(c1.get(0));
	assertThrows(IllegalArgumentException.class, ()->c1.get(8));
}
}
