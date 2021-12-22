package business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import db.MySQLHandler;

public class NGO {
	public ArrayList<Account> accounts=new ArrayList<Account>();
	public ArrayList<Donor> donors=new ArrayList<Donor>();
	public ArrayList<Case> pcases;
	public ArrayList<Case> ActiveCases;

	
	synchronized void printTable(int n){//synchronized method  
		   for(int i=1;i<=5;i++){  
		     System.out.println(n*i);  
		     try{  
		      Thread.sleep(400);  
		     }catch(Exception e){System.out.println(e);}  
		   }  
		  
		 }  
		
	public void proposedCases(String name, String description, int goal) throws ClassNotFoundException, SQLException, InterruptedException
	{
		pcases=new ArrayList<Case>();
		pcases.add(new Case());
		Case pcase=new Case();
	      Thread.sleep(400);  

		pcase.addProposedCase(name, description, goal);
		
		
	}
	public void getData() throws ClassNotFoundException, SQLException
	{
		pcases=new ArrayList<Case>();

		//Print array list
				for(int i=0;i<pcases.size();i++) {
					System.out.println("Element name "+pcases.get(i).CasesDesc.get(i));
					
					
				}
		
	}
	
	public void addCases(String name, String description, int goal) throws ClassNotFoundException, SQLException
	{
		ActiveCases=new ArrayList<Case>();
		ActiveCases.add(new Case());
		Case ActiveCases=new Case();
		ActiveCases.addActiveCase(name, description, goal);
		
		
	}

	
}
