import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DBConnection {
	
	private Connection con; 
	private Statement st;
	private ResultSet rs;
	
	
	public DBConnection(){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/moneytracker","root","");
			st = con.createStatement();
			
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void getData(){
		try{
			String query = "SELECT * FROM user";
			rs = st.executeQuery(query);
			System.out.println("Results are: ");
			while(rs.next()){
				String name = rs.getString("userName");
				String pass = rs.getString("userPassword");
				System.out.println("Name :" + name + " pass: " + pass);
			}
		
		}
		catch(Exception e){
			e.printStackTrace();
	}
	}	
		
	public void addUser(String username, String password, String country){
		
		try{		
			String query = "INSERT INTO user (userName, userPassword, country) VALUES (\"" + username +"\",\"" + password + "\",\"" + country +"\")";
			String condQuery = "SELECT userName from user where userName = \"" + username + "\"";
			
			rs = st.executeQuery(condQuery);
			System.out.println(condQuery);
			
			
			if(rs.first() && rs.next())
				System.out.println("Exista!!!");
			else
				st.execute(query);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	

}

