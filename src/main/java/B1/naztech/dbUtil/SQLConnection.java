package B1.naztech.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class SQLConnection {
	private static final Logger logger = LoggerFactory.getLogger(SQLConnection.class);

	public static final String URL = "jdbc:sqlserver://vNTDACWSSQLD002:1433";
    public static final String USER = "dev_test_dbo";
    public static final String PASS = "dev_test_dbo123";
    public static Connection conn;
	
	
	public static Connection getConnection() {
		try {
			conn = DriverManager.getConnection(URL,USER,PASS);
			log.info("connection created.");
			// conn.close();
		} catch (SQLException e) {
			log.error("Connection error: " + e.getMessage());
		}
		return conn;
	}	
}
