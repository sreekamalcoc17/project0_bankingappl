package com.revature.project0;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {
	static Customer c1 = new Customer();
	static Employee e1 = new Employee();
	@BeforeEach
	void beforeEach() {
		System.out.println("execution started");
	}
	@BeforeAll
	static void beforeAll() {
		System.out.println("STARTING");
	}
	@AfterAll
	static void afterAll() {
		System.out.println("DONE!!!");
	}
	@AfterEach
	void afterEach() {
		System.out.println("Execution done!!");
	}
	@Test
	void testOne() {
		String pass = "rsk";
		System.out.println("=======Test one Execution Started!!=======");
		Assertions.assertEquals(true,c1.login(1003,pass));
		Assertions.assertEquals(3234,c1.viewbal(1003));
		Assertions.assertEquals(true,e1.login("emp01",pass));
	}
	@Test
	void testTwo() {
		String pass = "rsk";
		System.out.println("=======Test Two Execution Started!!=======");
		Assertions.assertEquals(false,c1.login(10045,pass));
		Assertions.assertEquals(8999,c1.viewbal(1004));
		Assertions.assertEquals(false,e1.login("emp01001",pass));
	}
}
