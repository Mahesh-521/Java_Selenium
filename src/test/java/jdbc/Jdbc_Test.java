package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc_Test {

	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3306/java11";
		String user="root";
		String password="4038";
		
		try (Connection con=DriverManager.getConnection(url,user,password)){
			
			System.out.println("Db connected");
			String qry="insert into students values(?,?,?)";
			try(PreparedStatement ps=con.prepareStatement(qry)) {
				ps.setInt(1, 2);
				ps.setString(2, "rahul");
				ps.setInt(3, 32);
				int rows=ps.executeUpdate();
				System.out.println("Inserted "+rows+" rows");
			}
			
			String qry="select * from students";
			try(Statement st=con.createStatement()){
				
				ResultSet rs=st.executeQuery(qry);
				
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
				}
			}
			
			String qry="update students set age=? where id=?";
			try(PreparedStatement ps=con.prepareStatement(qry)){
				
				ps.setInt(1, 28);
				ps.setInt(2, 2);
				int rows=ps.executeUpdate();
				
				System.out.println("Updated "+rows);
			}
			
			String qry="delete from students where id=?";
			
			try(PreparedStatement ps=con.prepareStatement(qry)){
				ps.setInt(1, 2);
				ps.execute();
				System.out.println("deleted successfully");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
