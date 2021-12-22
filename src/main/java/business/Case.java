package business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import db.FileHandler;
import db.MySQLHandler;

public class Case {
	private int caseID;
	private String details;
	MySQLHandler m;
	FileHandler f;
	public static ArrayList<CaseDescription> CasesDesc; //MAI PROPOSED CASES KI DESCRIPTION KI ARRAYLIST HUN
	public ArrayList<CaseDescription> ActiveCasesDesc;

	public Case(int caseid) {
		this.caseID=caseid;
		
	} 
	
	public Case(int caseid2, String name, String description, int goal) {
		// TODO Auto-generated constructor stub
	}

	public Case() {
		// TODO Auto-generated constructor stub
	}

	public void setDetails()
	{
		
		
	}
	public String getDetails()
	{
		
		return details;
		
	}
	

	public void addProposedCase(String name,String description,int goal) throws ClassNotFoundException, SQLException
	{
		CasesDesc=new ArrayList<CaseDescription>();
		CasesDesc.add(new CaseDescription(name,description,goal));
		CaseDescription c=new CaseDescription();
		c.proposedCase(name, description,goal);
		FileHandler.appendStrToFile(name, description, goal);
	
	}
	
	public void addActiveCase(String name,String description,int goal) throws ClassNotFoundException, SQLException
	{
		ActiveCasesDesc=new ArrayList<CaseDescription>();
		ActiveCasesDesc.add(new CaseDescription(name,description,goal));
		CaseDescription c=new CaseDescription();
		c.activeCase(name, description,goal);
	
	}
	
	public void getData() throws ClassNotFoundException, SQLException
	{
		System.out.println("im in getDAta");
		ArrayList<Case> pcases=new ArrayList<Case>();
		m=new MySQLHandler();
		CasesDesc=new ArrayList<CaseDescription>();
		CaseDescription c=new CaseDescription();
		c.getAll();
		CasesDesc=c.getAll();
		pcases=m.getInCases();
		//pcases=(ArrayList<Case>)CasesDesc;
		
		for(int i=0;i<CasesDesc.size();i++) {
			System.out.println("im in loop of getDAta");

			System.out.println("Name "+CasesDesc.get(i).getTitle()+" Username "+CasesDesc.get(i).getDesc()+" email " +CasesDesc.get(i).getTarget());

		}

		//return pcases;
	}
	
	public void cases() throws ClassNotFoundException, SQLException
	{
		ArrayList<Case> pcases=new ArrayList<Case>();
		m=new MySQLHandler();
		CasesDesc=new ArrayList<CaseDescription>();
		CaseDescription c=new CaseDescription();
		c.getAll();
		CasesDesc=c.getAll();
		pcases=m.getInCases();
		
		
	}
	
	public static MySQLHandler sql1;
	public static ArrayList<CaseDescription> caseDesc;  //MAI ACTIVE CASES KI DESCRIPTION KI ARRAYLIST HUN

	public static ArrayList<CaseDescription> fetchDescription() throws ClassNotFoundException, SQLException
	{
		caseDesc=new ArrayList<CaseDescription>();
		sql1 = new MySQLHandler();
		//caseDesc =new ArrayList<CaseDescription>();
		caseDesc = sql1.getDetails();
		Collections.copy(caseDesc,sql1.getDetails());
		for (int i = 0; i < caseDesc.size(); i++) {
			System.out.println("Case ID " + caseDesc.get(i).getCaseID() + "Title " + caseDesc.get(i).getTitle() + "Description " + caseDesc.get(i).getDesc() + "Amount " + caseDesc.get(i).getTarget());
		}
	return caseDesc;
	}
	

	public boolean updateTarget(String title,int updatedTarget) throws ClassNotFoundException, SQLException
	{
		m=new MySQLHandler();
		boolean f = m.updateTarget(title,updatedTarget);
	    return f;
	}
	//MARIA
	
	public boolean addActiveCase(int id,String name,String description,int goal) throws ClassNotFoundException, SQLException
	{
		ActiveCasesDesc=new ArrayList<CaseDescription>();
		ActiveCasesDesc.add(new CaseDescription(name,description,goal));
		CaseDescription c=new CaseDescription();
		boolean f = c.activeCase(id,name, description,goal);
	
		 return f;
	}
	public boolean addProposedCase(int id,String name,String description,int goal) throws ClassNotFoundException, SQLException
	{
		CasesDesc=new ArrayList<CaseDescription>();
		CasesDesc.add(new CaseDescription(name,description,goal));
		CaseDescription c=new CaseDescription();
		boolean flag = c.proposedCase(id,name, description,goal);
		return flag;
	
	}
	public void deleteCase(String title) throws ClassNotFoundException, SQLException
	{
		m=new MySQLHandler();
		m.deleteaRow(title);
	}


	
}
