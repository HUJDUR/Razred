package razred;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnect {
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public DBConnect() {
	
	}
	
	public void connection(String imeBazePodataka) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost/" +  imeBazePodataka + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "toor");
			st = con.createStatement();
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	public void insert(String ime, String prezime) {
		
		try {
			
			String query = "INSERT INTO IIb (ime, prezime) VALUES (\"" + ime + "\", \"" + prezime + "\")";
			st.executeUpdate(query);
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	public void getData() {
		
		try {
			
			String query = "SELECT * FROM IIb";
			rs = st.executeQuery(query);			
			while (rs.next()) {
				String ime = rs.getString("ime");
				String prezime = rs.getString("prezime");
				System.out.println(ime + " " + prezime);
			}
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
