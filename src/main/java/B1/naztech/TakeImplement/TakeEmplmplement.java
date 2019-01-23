package B1.naztech.TakeImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import B1.naztech.Model.Employee;
import B1.naztech.Take.TakeEmployee;
import B1.naztech.dbUtil.SQLConnection;
import B1.naztech.jdbcMySQLTest.jdbcMySQL;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TakeEmplmplement implements TakeEmployee {
	
	private static final Logger logger = LoggerFactory.getLogger(jdbcMySQL.class);
	Connection con = SQLConnection.getConnection();

	@Override
	public boolean addEmp(Employee emp) {
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO T_Emp_Details VALUES (?, ?, ?, ?, ?, ?)");
	        ps.setInt(1, emp.getEId());
	        ps.setString(2, emp.getEName());
	        ps.setInt(3, emp.getESalary());
	        ps.setInt(4, emp.getEZip());
	        ps.setString(5, emp.getECity());
	        ps.setString(6, emp.getECountry());
	        int i = ps.executeUpdate();
	        log.info("Value Inserted");
	        if(i == 1) {
	        return true;
	        }
		} 
		catch (Exception e) {
			log.error("Insertion error"+e);
		}
		return false;
	}

	@Override
	public Employee delEmp(int id) {
		try {
			Statement stmt = con.createStatement();
	        int i = stmt.executeUpdate("DELETE FROM T_Emp_Details WHERE sId=" + id);
	        log.info("Value Deleted");
	        if(i == 1) {
	        return null;
	        }
		} 
		catch (Exception e) {
			log.error("Insertion error"+e);
		}
		return null;
	}

	@Override
	public boolean upEmp(Employee emp, int id) {
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE T_Emp_Details SET sName=?,sSalary=?,sZip=?,sCity=?,sCountry=? WHERE sId=" + id);
			//ps.setInt(1, emp.getEId());
	        ps.setString(1, emp.getEName());
	        ps.setInt(2, emp.getESalary());
	        ps.setInt(3, emp.getEZip());
	        ps.setString(4, emp.getECity());
	        ps.setString(5, emp.getECountry());
	        int i = ps.executeUpdate();
	        log.info("Value Updated");
	        if(i == 1) {
	        return true;
	        }
		} 
		catch (Exception e) {
			log.error("Insertion error"+e);
		}
		return false;
	}

	@Override
	public Employee empFindById(int id) {
		try {
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM T_Emp_Details WHERE sID="+id);
	        if (rs.next()) {
	        	Employee emp = new Employee();
				emp.setEId(rs.getInt("sId"));
				emp.setEName(rs.getString("sName"));
				emp.setESalary(rs.getInt("sSalary"));
				emp.setEZip(rs.getInt("sZip"));
				emp.setECity(rs.getString("sCity"));
				emp.setECountry(rs.getString("sCountry"));
				return emp;
			}
			//stmt.close();
		} catch (Exception e) {
			log.error("Connection error: " + e.getMessage());
		}
		return null;
	}

	@Override
	public int maxSalary() {
		try {
			int maxID = 0;
	        Statement stmt = con.createStatement();
	        stmt.execute("SELECT MAX(sSalary) FROM T_Emp_Details");    
			ResultSet rs = stmt.getResultSet();
			if (rs.next()) {
				  maxID = rs.getInt(1);
				}
			return maxID;
			//stmt.close();
		} catch (Exception e) {
			log.error("Connection error: " + e.getMessage());
		}
		return 0;
	}

	@Override
	public int minSalary() {
		try {
			int minID = 0;
	        Statement stmt = con.createStatement();
	        stmt.execute("SELECT MIN(sSalary) FROM T_Emp_Details");    
			ResultSet rs = stmt.getResultSet();
			if (rs.next()) {
				  minID = rs.getInt(1);
				}
			return minID;
			//stmt.close();
		} catch (Exception e) {
			log.error("Connection error: " + e.getMessage());
		}
		return 0;
	}

	@Override
	public int avgSalary() {
		try {
			int avg = 0;
	        Statement stmt = con.createStatement();
	        stmt.execute("SELECT AVG(sSalary) FROM T_Emp_Details");    
			ResultSet rs = stmt.getResultSet();
			if (rs.next()) {
				  avg = rs.getInt(1);
				}
			return avg;
			//stmt.close();
		} catch (Exception e) {
			log.error("Connection error: " + e.getMessage());
		}
		return 0;
	}

	@Override
	public int secondmaxSalary() {
		try {
			int SmaxID = 0;
	        Statement stmt = con.createStatement();
	        stmt.execute("SELECT MAX(sSalary) FROM T_Emp_Details WHERE sSalary < (SELECT MAX(sSalary) FROM T_Emp_Details)");    
			ResultSet rs = stmt.getResultSet();
			if (rs.next()) {
				  SmaxID = rs.getInt(1);				  
				}
			return SmaxID;
			//stmt.close();
		} catch (Exception e) {
			log.error("Connection error: " + e.getMessage());
		}
		return 0;
	}
}
