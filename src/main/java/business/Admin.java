package business;

import java.sql.SQLException;

import db.MySQLHandler;

public class Admin extends Moderator{

	public Admin(String firstname, String username, String email, String password) {
		super(firstname, username, email, password);
		// TODO Auto-generated constructor stub
	}

	public Admin() {
		super();

		// TODO Auto-generated constructor stub
	}
	
	public boolean addadmin(String u, String p) throws ClassNotFoundException, SQLException {
		m=new MySQLHandler();
		boolean f = m.adminDB(u, p);
		return f;
	}
	
	

}
