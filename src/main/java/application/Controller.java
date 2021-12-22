/*
 * 
 *       					CHARITY MANAGEMENT SYSTEM
 *       						CONTRIBUTORS:
 *       					  I190478- MARIA HASSAN
 *       					  I190502- VARA ALI
 *      					  I190597- AZKA ALI
 * 
 */


package application;

import java.io.File;

import java.io.FileInputStream;
	import javafx.scene.Node;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.net.URL;
	import java.sql.SQLException;
	import java.util.ResourceBundle;
import java.util.regex.Pattern;

import business.Account;
	import business.CaseDescription;
	import business.Donor;
	import business.NGO;
	import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.beans.value.ChangeListener;
	import javafx.beans.value.ObservableValue;
	import javafx.collections.FXCollections;
	import javafx.collections.ObservableList;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.fxml.FXMLLoader;
	import javafx.fxml.Initializable;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


class InvalidAccountException  extends Exception
{
	public InvalidAccountException (String str)
	{
		super(str);
	}
}
class InvalidAmountException  extends Exception
{
	public InvalidAmountException (String str)
	{
		super(str);
	}
}
	public class Controller  {
		  private Stage stage;
		  private Scene scene;
		  private Parent root;
		  Account acc=new Account(); 
		  NGO ngo=new NGO();  

		@FXML
		//final ObservableList<String> listItems = FXCollections.observableArrayList("HELLO :'(");        

		MediaPlayer mediaPlayer;
		public Label l1=new Label();
		public Label desc=new Label();
		public Button ok;
		public Button signup;
		public Button addModerator;
		public Button addCase;
		public Button proposeCase;
		public TextField newCaseName=new TextField();
		public TextArea newCaseDescription=new TextArea();
		public TextField newCaseGoal=new TextField();
		public TextField adminUsername=new TextField();
		public TextField caseName=new TextField();
		public TextField newModeratorName=new TextField();
		public TextField newModeratorUsername=new TextField();
		public TextField newModeratorCNIC=new TextField();
		public TextField newModeratorEmail=new TextField();
		public PasswordField newModeratorPassword=new PasswordField();
		public TextField caseGoal=new TextField();
		public TextArea caseDescription=new TextArea();
		public PasswordField adminPassword=new PasswordField();
		public TextField donorUsername=new TextField();
		public PasswordField donorPassword=new PasswordField();
		public TextField newUsername=new TextField();
		public TextField newName=new TextField();
		public TextField newEmail=new TextField();
		public PasswordField newPassword=new PasswordField();
		public TextField moderatorUsername=new TextField();
		public TextField moderatorPassword=new TextField();

		public String newDonorUsername;
		public String newDonorEmail;
		public String newDonorName;
		public String newDonorPass;
		public String donor;
		public String donorPass;
		public String admin;
		public String adminPass;
		public String caseID;
		public RadioButton c1=new RadioButton();
	
		public void afterStart(ActionEvent e) throws IOException
		{
			root=FXMLLoader.load(getClass().getResource("FirstPage.fxml"));
			stage=(Stage)((Node)e.getSource()).getScene().getWindow();
			scene=new Scene(root);
			stage.setScene(scene);
			stage.show();
			stage.setTitle("Login Options");

		}


		//////////////////////////////-----------DONOR--------///////////////////////////////////////////////////
		public void donorSelected(ActionEvent e) throws IOException
		{
			    root=FXMLLoader.load(getClass().getResource("DonorLogin.fxml"));
		        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
		        scene=new Scene(root);
		        stage.setScene(scene);
		        stage.show();
		        stage.setTitle("Donor Login");
			
		}
		
		public void donorSignUp(ActionEvent e) throws IOException
		{
			 	root=FXMLLoader.load(getClass().getResource("DonorSignup.fxml"));
		        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
		        scene=new Scene(root);
		        stage.setScene(scene);
		        stage.show();
		        stage.setTitle("Donor Login");
			
		}
		
		public void donorAfterSignup(ActionEvent e) throws IOException, ClassNotFoundException, SQLException
		{
			newDonorName=newName.getText();
			System.out.println(newDonorName);
			newDonorUsername=newUsername.getText();
			System.out.println(newDonorUsername);
			newDonorEmail=newEmail.getText();
			System.out.println(newDonorEmail);
			newDonorPass=newPassword.getText();
			System.out.println(newDonorPass);
			
			acc.signUp(newDonorName,newDonorUsername, newDonorEmail, newDonorPass);
			root=FXMLLoader.load(getClass().getResource("DonorMenu.fxml"));
	        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
	        scene=new Scene(root);
	        stage.setScene(scene);
	        stage.setTitle("Donations Proposal Addition");
	        stage.show();   
			
		}
		
		public void donorAfterLogin(ActionEvent e) throws IOException, ClassNotFoundException, SQLException 
		{
			donor=donorUsername.getText();
			System.out.println(donor);
			donorPass=donorPassword.getText();
			System.out.println(donorPass);


			try {
				if (acc.signIn(donor, donorPass)) {
					root = FXMLLoader.load(getClass().getResource("DonorMenu.fxml"));
					stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
					scene = new Scene(root);
					stage.setScene(scene);
					stage.setTitle("Donations Proposal Addition");
					stage.show();

				} else {
					Stage stage = new Stage();
					FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("DonorLoginFailed.fxml"));
					Scene scene = new Scene(fxmlLoader.load(), 800, 400);
					stage.setTitle("Donor login failed");
					stage.setScene(scene);
					stage.show();
					throw new InvalidAccountException("The specified account number does not exist");
				}
			}

			catch(InvalidAccountException ex)
			{
				System.out.println("This is the exception");
				System.out.println("The exception was : " + ex);
			}
			
			
		}
		
		public void proposeDonationForm(ActionEvent e) throws IOException
		{
			root=FXMLLoader.load(getClass().getResource("ProposeDonationForm.fxml"));
	        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
	        scene=new Scene(root);
	        stage.setScene(scene);
	        stage.setTitle("Donations Proposal Addition");
	        stage.show();   
		}


		//I AM NEW
		public void backToDonorMenu(ActionEvent e) throws IOException, ClassNotFoundException, SQLException
		{
			root=FXMLLoader.load(getClass().getResource("DonorMenu.fxml"));
			stage=(Stage)((Node)e.getSource()).getScene().getWindow();
			scene=new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Donations Proposal Addition");
			stage.show();

		}

		//I AM NEW

		public void logOut(ActionEvent e) throws IOException, ClassNotFoundException, SQLException
		{
			root=FXMLLoader.load(getClass().getResource("FirstPage.fxml"));
			stage=(Stage)((Node)e.getSource()).getScene().getWindow();
			scene=new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Donations Proposal Addition");
			stage.show();

		}


		
		public void onProposition(ActionEvent e) throws IOException
		{	
			root=FXMLLoader.load(getClass().getResource("ProposeDonationForm.fxml"));
	        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
	        scene=new Scene(root);
	        stage.setScene(scene);
	        stage.setTitle("Donations Proposal Addition");
	        stage.show();   
		}
		
		public void onProposalSubmission(ActionEvent e) throws IOException, ClassNotFoundException, SQLException, InterruptedException
		{	
			String cname=caseName.getText();
			System.out.println(cname);
			String cdesc=caseDescription.getText();
			System.out.println(cdesc);
			String goal=caseGoal.getText();
			System.out.println(goal);
			int cgoal=Integer.parseInt(goal);
			System.out.println("I am now an integer "+cgoal);
			
			ngo.proposedCases(cname, cdesc, cgoal);
			
			root=FXMLLoader.load(getClass().getResource("ProposalSuccessful.fxml"));
	        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
	        scene=new Scene(root);
	        stage.setScene(scene);
	        stage.setTitle("Donations Proposal Submission Successful");
	        stage.show();   
		}
		
	
		 public boolean isValidEmailAddress(String email) {
	           String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
	           java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
	           java.util.regex.Matcher m = p.matcher(email);
	           return m.matches();
	    }
		
		@FXML
		public void validateDonorinfo() {		
			
			//			String regex = "[^(.+)@(.+)$]"; 
			boolean x=isValidEmailAddress(newEmail.getText());
			newEmail.focusedProperty().addListener((arg0, oldValue, newValue) -> {
		            if(x==true){
	            	signup.setDisable(false);
		            }
		            else {
		            	signup.setDisable(true);
		            }
		       // }

		    });
			
		}
		
		


		public void makeDonationFirst(ActionEvent e) throws IOException
		{
			//playHitSound("C:\\Users\\S F\\Downloads\\nasheed.mp3");
			root=FXMLLoader.load(getClass().getResource("ActiveDonations.fxml"));
	        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
	        scene=new Scene(root);
	        stage.setScene(scene);
	        stage.setTitle("Donations Dashboard");
	        stage.show();   
		}

		public void selectCase(ActionEvent e) throws IOException
		{
			root=FXMLLoader.load(getClass().getResource("caseDescription.fxml"));
	        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
	        scene=new Scene(root);
	        stage.setScene(scene);
	        stage.setTitle("Donations Dashboard");
	        stage.show();   
		}
	
		
		
		
		
		//////////////////////////////-----------MODERATOR--------///////////////////////////////////////////////////
		 public boolean isValidAmount(String email) {
			 String pattern = "^[1-9]\\d*$";
			 java.util.regex.Pattern p = java.util.regex.Pattern.compile(pattern);
	           java.util.regex.Matcher m = p.matcher(email);
	           return m.matches();
	    }
		
		@FXML
		public void validateAmount() {		
			boolean x=isValidAmount(caseGoal.getText());
			caseGoal.focusedProperty().addListener((arg0, oldValue, newValue) -> {
		            if(x==true){
		            	proposeCase.setDisable(false);
		            }
		            else {
		            	proposeCase.setDisable(true);
		            }
		       // }

		    });
			
		}
		
		public boolean isValid(String email) {
			 String pattern = "^[1-9]\\d*$";
			 java.util.regex.Pattern p = java.util.regex.Pattern.compile(pattern);
	           java.util.regex.Matcher m = p.matcher(email);
	           return m.matches();
	    }
		
		@FXML
		public void validateTarget() {		
			boolean x=isValid(newCaseGoal.getText());
			newCaseGoal.focusedProperty().addListener((arg0, oldValue, newValue) -> {
		            if(x==true){
		            	addCase.setDisable(false);
		            }
		            else {
		            	addCase.setDisable(true);
		            }
		       // }

		    });
			
		}
		
		public void moderatorSelected(ActionEvent e) throws IOException
		{
			    root=FXMLLoader.load(getClass().getResource("ModeratorLogin.fxml"));
		        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
		        scene=new Scene(root);
		        stage.setScene(scene);
		        stage.show();
		        stage.setTitle("Moderator Login");
			
		}

		public void BacktomoderatorMenu(ActionEvent e) throws IOException, ClassNotFoundException, SQLException
		{
			root=FXMLLoader.load(getClass().getResource("ModeratorMenu.fxml"));
			stage=(Stage)((Node)e.getSource()).getScene().getWindow();
			scene=new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Moderator Menu");
			stage.show();
		}

		public void tomoderatorMenu(ActionEvent e) throws IOException, ClassNotFoundException, SQLException
		{
				String moderator=moderatorUsername.getText();
				System.out.println(moderator);
				String moderatorPass=moderatorPassword.getText();
				System.out.println(moderatorPass);
				
				try {
					if (acc.moderatorsignIn(moderator, moderatorPass)) {
						root = FXMLLoader.load(getClass().getResource("ModeratorMenu.fxml"));
						stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
						scene = new Scene(root);
						stage.setScene(scene);
						stage.setTitle("Moderator Menu");
						stage.show();

					} else {
						Stage stage = new Stage();
						FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("ModeratorLoginFailed.fxml"));
						Scene scene = new Scene(fxmlLoader.load(), 800, 400);
						stage.setTitle("Moderator Login Failed");
						stage.setScene(scene);
						stage.show();
						throw new InvalidAccountException("The specified account does not exist");

					}
				}

				catch (InvalidAccountException ex)
				{
					System.out.println("This is the exception");
					System.out.println("The exception was : " + ex);
				}
			
		}
		
		
		public void toProposedCases(ActionEvent e) throws IOException
		{
			root=FXMLLoader.load(getClass().getResource("CasesPendingApproval.fxml"));
	        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
	        scene=new Scene(root);
	        stage.setScene(scene);
	        stage.setTitle("Cases Pending Approval");
	        stage.show(); 
		}

		
		
		public void toAddCase(ActionEvent e) throws IOException
		{
			    root=FXMLLoader.load(getClass().getResource("CaseAdditionForm.fxml"));
		        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
		        scene=new Scene(root);
		        stage.setScene(scene);
		        stage.show();
		        stage.setTitle("Adding a new Case");
			
		}
		
		public void caseAdditionSuccessful(ActionEvent e) throws IOException, ClassNotFoundException, SQLException
		{
			String newcase=newCaseName.getText();
			System.out.println(newcase);
			String newCaseDesc=newCaseDescription.getText();
			System.out.println(newCaseDesc);
			String newgoal=newCaseGoal.getText();
			System.out.println(newgoal);
			int newGoal=Integer.parseInt(newgoal);
			System.out.println("IM NOW AN INTEGER"+newGoal);
		
				ngo.addCases(newcase, newCaseDesc, newGoal);
				
				
			    root=FXMLLoader.load(getClass().getResource("CaseAdditionSuccessfulMesage.fxml"));
		        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
		        scene=new Scene(root);
		        stage.setScene(scene);
		        stage.show();
		        stage.setTitle("Successful Case Addition");
			
			
			
		}
		
		
		
		
		//////////////////////////////-----------ADMIN--------///////////////////////////////////////////////////

	
		
		@FXML
		public void validateModeratorinfo() {		
			boolean x=isValidEmailAddress(newModeratorEmail.getText());
			newModeratorEmail.focusedProperty().addListener((arg0, oldValue, newValue) -> {
		            if(x==true){
		            	addModerator.setDisable(false);
		            }
		            else {
		            	addModerator.setDisable(true);
		            }
		    });
			
		}
		
		
		@FXML
	    protected void adminSelected(ActionEvent e) throws IOException {

	        root=FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
	        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
	        scene=new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	    }
		
		public void getCredentials(ActionEvent e)  throws IOException
		{
			System.out.println(adminUsername.getText());

			System.out.println(adminPassword.getText());	
		}
		//from successful moderator back to admin menu
		public void backtoAdminMenu(ActionEvent e) throws IOException
		{
			root=FXMLLoader.load(getClass().getResource("AdminMenu.fxml"));
			stage=(Stage)((Node)e.getSource()).getScene().getWindow();
			scene=new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Admin Menu");
			stage.show();
		}


		public void toAdminMenu(ActionEvent e) throws IOException
		{
			admin=adminUsername.getText();
			System.out.println(admin);
			adminPass=adminPassword.getText();
			System.out.println(adminPass);
			try {
				if ((admin.equalsIgnoreCase("azka") || admin.equalsIgnoreCase("vara") ||admin.equalsIgnoreCase("maria") || admin.equalsIgnoreCase("usman") || admin.equalsIgnoreCase("shanzay")) && adminPass.equalsIgnoreCase("1234")) {
					root = FXMLLoader.load(getClass().getResource("AdminMenu.fxml"));
					stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
					scene = new Scene(root);
					stage.setScene(scene);
					stage.setTitle("Admin Menu");
					stage.show();
				} else {
					Stage stage = new Stage();
					FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("AdminLoginFailed.fxml"));
					Scene scene = new Scene(fxmlLoader.load(), 520, 440);
					stage.setTitle("Admin Login Failed");
					stage.setScene(scene);
					stage.show();
					throw new InvalidAccountException("The specified account does not exist");
				}
			}

			catch (InvalidAccountException ex)
			{
				System.out.println("This is the exception");
				System.out.println("The exception was : " + ex);
			}
			
		}
		public void toAddModerator(ActionEvent e) throws IOException
		{
			    root=FXMLLoader.load(getClass().getResource("ModeratorAdditionForm.fxml"));
		        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
		        scene=new Scene(root);
		        stage.setScene(scene);
		        stage.show();
		        stage.setTitle("Adding a new Moderator");
			
		}
		
		public void moderatorAdditionSuccessful(ActionEvent e) throws IOException, ClassNotFoundException, SQLException
		{
			
			String newMName=newModeratorName.getText();
			String newMUsername=newModeratorUsername.getText();
			String newMCNIC=newModeratorCNIC.getText();
			String newMEmail=newModeratorEmail.getText();
			String newMPassword=newModeratorPassword.getText();//PasswordField();
			
			acc.moderatorAddition(newMName,newMUsername,newMEmail,newMPassword);
			    root=FXMLLoader.load(getClass().getResource("ModeratorAdditionSuccessful.fxml"));
		        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
		        scene=new Scene(root);
		        stage.setScene(scene);
		        stage.show();
		        stage.setTitle("Adding a new Moderator");
			
		}
		
		public void loginFailed(ActionEvent e) throws IOException
		{
			
			Stage stage=(Stage) ok.getScene().getWindow();
		    stage.close();
			
		}
		
		
	}
