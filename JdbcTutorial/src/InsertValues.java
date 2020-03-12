import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertValues {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/";
		String db = "test";
		String driver = "com.mysql.jdbc.Driver";
		try {
		Class.forName(driver);
		try(java.sql.Connection con=DriverManager.getConnection(url + db, "root", "password");) {
			java.sql.Statement st = ((java.sql.Connection) con).createStatement();
			System.out.println("Inserting values in Mysql database table!");
			String sql = "INSERT into Employee(id,name,salary) VALUES(11,'patel',15000)";
			@SuppressWarnings("unused")
			int val = ((java.sql.Statement) st).executeUpdate(sql);
			System.out.println("1 row affected");
		} catch (SQLException s) {
			System.out.println("SQL statement is not executed! Error is: " + s.getMessage());
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		java.sql.Connection con=DriverManager.getConnection(url + db, "root", "password");
		java.sql.Statement st = ((java.sql.Connection) con).createStatement();
		 
		ResultSet results = ((java.sql.Statement) st).executeQuery("SELECT * FROM employee");
		 
		 
		// For each row of the result set ...
		 
		while (results.next()) {
		 
		 
		  // Get the data from the current row using the column index - column data are in the VARCHAR format
		 
		  String data = results.getString(1);
		 
		  System.out.println("Fetching data by column index for row " + results.getRow() + " : " + data);
		 
		 
		  // Get the data from the current row using the column name - column data are in the VARCHAR format
		 
		  data = results.getString("name");
		 
		  System.out.println("Fetching data by column name for row " + results.getRow() + " : " + data);
		 
		 
		}
	}
}
