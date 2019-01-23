package B1.naztech.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	private int eId;
	private String eName;
	private int eSalary;
	private int eZip;
	private String eCity;
	private String eCountry;
	
	
	public Employee(String n, int s, int z, String c, String co) {
		this.eName = n;
		this.eSalary = s;
		this.eZip = z;
		this.eCity = c;
		this.eCountry = co;
	}	
}
