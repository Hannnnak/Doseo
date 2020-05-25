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
      if (pstmt != null) {
         try {
            pstmt.close();
         } catch (SQLException e) {
         }
      }
      if (conn != null) {
         try {
            conn.close();
         } catch (SQLException e) {
         }
      }
   }

   public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
      if (rs != null) {
         try {
            rs.close();
         } catch (SQLException e) {
         }
      }
      if (pstmt != null) {
         try {
            pstmt.close();
         } catch (SQLException e) {
         }
      }
      if (conn != null) {
         try {
            conn.close();
         } catch (SQLException e) {
         }
      }
   }
}