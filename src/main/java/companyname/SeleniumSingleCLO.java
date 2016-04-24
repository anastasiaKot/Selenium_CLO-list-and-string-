package companyname;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
@Parameters(separators="|")
	
public class SeleniumSingleCLO 
{
		//CLO
		 public static final String surl = "-u";
		 public static final String lurl = "--url";

		 public static final String sexpected  = "-e";
		 public static final String expected  = "--expected";
		 
		 public static final String stestcaseID = "-tc";
		 public static final String testcaseID = "--testcase";
		 
		 public static final String sHelp  = "-h";
		 public static final String hhelp  = "--help";
	
		
		 @Parameter(names = {surl, lurl}, description = "URL of the web site")
	       //default value
	        private static String  uniformResourceIdentifier = "http://learn2test.net/";
	      	
		 @Parameter(names={sexpected, expected}, description ="Expected title of Web Site")
			//Default value, required=true
			private static String expTitle ="learn2test.net";
		 
		 @Parameter(names={stestcaseID, testcaseID}, description ="Test case ID")
			//Default value, required=true
			private static String testcase ="01-001";
		 @Parameter(names={sHelp, hhelp}, help=true, hidden=true)
			//Default value
			private static boolean help;
		 
		 
 public static void main(String[] args) 
 {
	        //new JCommander(new SeleniumSingleCLO(), args);
	
		        JCommander CLO = new JCommander(new SeleniumSingleCLO(), args);
		            if (help)
		            {
		            	CLO.usage();
		        		System.exit(0);
		            }
	
		 WebDriver driver = new FirefoxDriver();    // Version 1.1  :: Firefox

			driver.get(uniformResourceIdentifier);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			String title_actual = driver.getTitle();

			if (expTitle.equals(title_actual)) {
				System.out.println("__________start__________" );
				System.out.println("Test Case ID: \t\t" + testcase );
				System.out.println("URL: \t\t\t" + uniformResourceIdentifier);
				System.out.println("Title Expected: \t" + expTitle);
				System.out.println("Title Actual: \t\t" + title_actual);
				System.out.println("Test Case Result: \t" + "PASSED");
				System.out.println("_________summary_________" );
			} else {
				System.out.println("_________start_________" );
				System.out.println("Test Case ID: \t\t" + testcase);
				System.out.println("URL: \t\t\t" + uniformResourceIdentifier);
				System.out.println("Title Expected: \t" + expTitle);
				System.out.println("Title Actual: \t\t" + title_actual);
				System.out.println("Test Case Result: \t" + "FAILED");
				System.out.println("_________summary_________" );
			}
			driver.quit();
			System.out.println();
		    System.out.println("Test case ID = "+ testcase + ", URL = "+uniformResourceIdentifier +","
		    		+ " Expected title of the URL ="+expTitle);
		    System.out.println("___________end___________" );
		} 
}

