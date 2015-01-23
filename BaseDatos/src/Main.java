import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {

	private static void leer() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.88.151/demo","root", "123456");
			
			Statement statement = connection.createStatement();
			
			String sql = "SELECT * FROM user;";
			
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()){
				System.out.println(rs.getString("id") + " \t " + rs.getString("name"));
			}
			
			rs.close();
			statement.close();
			connection.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		
		leer();
		System.out.println("-------------");
		crear("Juan");
		System.out.println("-------------");
		modificar("1", "Gerardo");
		System.out.println("-------------");
		eliminar("13");
		System.out.println("-------------");
		leer();
		
	}


	private static void eliminar(String id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/demo","root", "123456");
			
			Statement statement = connection.createStatement();
			
			String sql = "DELETE FROM user WHERE id='" + id + "';";
			
			statement.execute(sql);
			
			statement.close();
			connection.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	private static void modificar(String id, String nombre) {
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/demo","root", "123456");
			
			Statement statement = connection.createStatement();
			
			String sql = "UPDATE user SET name='" + nombre + "' WHERE id='" + id + "';";
			
			statement.execute(sql);
			
			statement.close();
			connection.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	private static void crear(String nombre) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/demo","root", "123456");
			
			Statement statement = connection.createStatement();
			
			String sql = "INSERT INTO user (name) VALUES ('" + nombre  + "')";
			
			statement.execute(sql);
			
			statement.close();
			connection.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
