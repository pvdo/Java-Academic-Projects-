//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//public class BankDB {
//	
//	public static void main(String [] args) {
//		
//		try {
//			
//			Connection conn = DriverManager.getConnection(
//						"jdbc:sqlite://Users//pedrodocarmo//Documents//SENECA//4semester//JAC444//Workshop//Workshop10_task2//src//bank.db");
//			
//			Statement statement = conn.createStatement();
//			
//			statement.execute("CREATE TABLE IF NOT EXISTS bank (id INTEGER, balance DOUBLE, assets DOUBLE, liability DOUBLE)");
//			statement.execute("CREATE TABLE IF NOT EXISTS loan (idLoaner INTEGER, amount DOUBLE, idLoanee INTEGER)");
//			
//			statement.execute("INSERT INTO bank (id, balance, assets, liability)")
//			
//			
//			statement.close();
//			conn.close();
//		}catch(SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		
//	}
//	
//}
