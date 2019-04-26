package com.kitri.jdbcTest;

public class DriverLoadingTest {

	public DriverLoadingTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		public static void main(String[] args) {
			new DriverLoadingTest();
		}
}
