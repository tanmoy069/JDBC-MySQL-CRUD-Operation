package B1.naztech.Take;

import B1.naztech.Model.Employee;

public interface TakeEmployee {
	boolean addEmp(Employee emp);
	public Employee delEmp(int id);
	public boolean upEmp(Employee emp,int id);
	public Employee empFindById(int id);
	public int maxSalary();
	public int minSalary();
	public int avgSalary();
	public int secondmaxSalary();
}
