package B1.naztech.dbUtil;

import java.sql.Connection;

import B1.naztech.Model.Employee;
import B1.naztech.TakeImplement.TakeEmplmplement;

//use this method for just testing purpose before junit test
public class Operation {
	public static void main(String[] args) {
		TakeEmplmplement temp = new TakeEmplmplement();
		Employee emp1 = new Employee(6,"Dhaly",20000,1212,"Dhaka","Bangladesh");
		temp.addEmp(emp1);
		Employee empup = new Employee("Dhaly",20000,1212,"Dhaka","Bangladesh");
		temp.upEmp(empup, 6);
		temp.delEmp(5);
		temp.empFindById(6);
		Employee semp = temp.empFindById(6);
		System.out.println(semp);
	}
}
