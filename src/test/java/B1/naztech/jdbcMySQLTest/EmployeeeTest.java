package B1.naztech.jdbcMySQLTest;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import B1.naztech.Model.Employee;
import B1.naztech.TakeImplement.TakeEmplmplement;
import B1.naztech.dbUtil.SQLConnection;
import junit.framework.TestCase;

public class EmployeeeTest extends TestCase {
	Connection con = SQLConnection.getConnection();
	TakeEmplmplement temp = new TakeEmplmplement();
	
	@Test
	public void testConncetionTest() throws SQLException {
		String str = "DEV_TEST";
		assertEquals(str, con.getCatalog());
	}
	
	@Test
	public void testaddEmp() {
		Employee emp = new Employee(8,"Tamim",20000,1212,"Dhaka","Bangladesh");
		assertTrue(temp.addEmp(emp));
	}
	@Test
	public void testdelEmp() {
		assertNull(temp.delEmp(8));
		assertNotSame(temp.empFindById(8), temp.delEmp(8));
	}
	@Test
	public void testupEmp() {
		Employee emp = new Employee("Tanmoy",15000,1212,"Dhaka","Bangladesh");
		assertTrue(temp.upEmp(emp, 1));
		
	}
	@Test
	public void testsearchEmp() {
		String str = "Tanmoy";
		assertEquals(str, temp.empFindById(1).getEName());
	}
	@Test
	public void testmaxSalary() {
		int max = 28000;
		assertEquals(max, temp.maxSalary());
	}
	@Test
	public void testminSalary() {
		int min = 15000;
		assertEquals(min, temp.minSalary());
	}
	@Test
	public void testavgSalary() {
		int avg = 22500;
		assertEquals(avg, temp.avgSalary());
	}
	@Test
	public void testsecondmaxSalary() {
		int avg = 25000;
		assertEquals(avg, temp.secondmaxSalary());
	}
}
