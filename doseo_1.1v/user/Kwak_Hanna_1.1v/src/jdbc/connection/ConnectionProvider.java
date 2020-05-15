package jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionProvider {

	//외부에서는
	//Connection 변수명= ConnectionProvider.getConnection();
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:apache:commons:dbcp:doseo");
	}

	public static void close(Connection conn, PreparedStatement pstmt) {
		System.out.println("DB접속 종료");
		
	}

	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		System.out.println("DB접속 종료");
		
	}
}









