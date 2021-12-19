package donor;

import static org.junit.Assert.assertNotEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import business.Case;
import business.CaseDescription;
import business.Donor;

public class CaseTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;
	//Case c=new Case();
	
	
	
	@Before
	public void setUpStreams() {
		
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	

	
	@After
	public void tearDown() throws Exception {
		
		
		//a.display();
	} 
	
	
	
	/*@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	    System.setErr(originalErr);
	}

	*/

	//ARRAY
	@Test
	public void fetchDescription() throws Exception {
		Case c=new Case();
        assertNotEquals(Arrays.asList("Customer1", "Customer2", "Customer3"), Case.fetchDescription());
		
		}
	
	
	
	
	
}
