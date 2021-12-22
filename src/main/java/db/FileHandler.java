package db;

import java.util.ArrayList;

import com.mchange.v2.io.FileUtils;

import java.io.*;
import business.CaseDescription;


public class FileHandler {
	// Method 1
		// TO append string into a file
		public static void appendStrToFile(String name,String description,int goal)
		{
			//CaseDescription object=new CaseDescription();
			//String convertedToString = String.valueOf(CasesDesc);  //method 1
			//System.out.println("CALLED"+convertedToString);
			
			//String convertedToString = Object.toString();  //method 3

			String s=Integer.toString(goal);
			try 
			{
		      File create_f = new File("CaseDescription.txt");
		      FileWriter fileWriter1 = new FileWriter(create_f, true);
		      BufferedWriter bufferWriter1 = new BufferedWriter(fileWriter1);
		      //bufferWriter1.write("Case#	Title	Description							Target");
		      bufferWriter1.newLine();
		      bufferWriter1.write(name+"\t");
		      bufferWriter1.write(description+"\t\t\t\t");
		      bufferWriter1.write(s);

		      bufferWriter1.newLine();
	//	      bufferWriter1.write("Flight2	Karachi	Islamabad	23-Oct-2021		7:00 pm		44");

		      bufferWriter1.close();
		      fileWriter1.close();
		      //System.out.println("Successfully wrote to the file.");
		    } 
		catch (IOException e)
			{
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
			
			
			/*
			try {
			    FileOutputStream fos = new FileOutputStream("CaseDescription.txt");
			    ObjectOutputStream oos = new ObjectOutputStream(fos);   
			    oos.writeObject(CasesDesc); // write MenuArray to ObjectOutputStream
			    oos.close(); 
			} catch(Exception ex) {
			    ex.printStackTrace();
			}
			*/
			
		}
			
			/*
			// Try block to check for exceptions
			try {

				// Open given file in append mode by creating an
				// object of BufferedWriter class
				BufferedWriter out = new BufferedWriter(
					new FileWriter(fileName, true));

				// Writing on output stream
				out.write(str);
				// Closing the connection
				out.close();
			}

			// Catch block to handle the exceptions
			catch (IOException e) {

				// Display message when exception occurs
				System.out.println("exception occurred" + e);
			}
			
		}

		// Method 2
		// main driver method
		public static void main(String[] args) throws Exception
		{
			// Creating a sample file with some random text
			String fileName = "CaseDescription.txt";

			// Try block to check for exceptions
			try {

				// Again operating same operations by passing
				// file as
				// parameter to read it
				BufferedWriter out = new BufferedWriter(
					new FileWriter(fileName));

				// Writing on. file
				out.write("Hello World:\n");

				// Closing file connections
				out.close();
			}

			// Catch block to handle exceptions
			catch (IOException e) {

				// Display message when error occurs
				System.out.println("Exception Occurred" + e);
			}

			// Now appendinggiven str to above
			// created file
			//ArrayList<CaseDescription> str = "This is GeeksforGeeks";
			String convertedToString = String.valueOf(CasesDesc);  //method 1

			// Calling the above method
			appendStrToFile(fileName, CasesDesc);
			try {
				BufferedReader in = new BufferedReader(
					new FileReader("CaseDescription.txt"));

				String mystring;
				while ((mystring = in.readLine()) != null) {
					System.out.println(mystring);
				}
			}
			catch (IOException e) {
				System.out.println("Exception Occurred" + e);
			}
		}
		*/
	


}
