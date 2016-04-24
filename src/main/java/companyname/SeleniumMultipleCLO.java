package companyname;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
@Parameters(separators="|")

public class SeleniumMultipleCLO
{
		 public static final String sList = "-l";
		 public static final String List = "--list";
		 
		 public static final String sHelp  = "-h";
		 public static final String hhelp  = "--help";
		 
		 @Parameter(names =  {List, sList }, variableArity  = true, description = "Description: Pairs of URL & title."
		 		+ " Separators of Pairs are \"|\". Example: \"b|a\" ")
		 public static List<String> list;
		 
		 @Parameter(names = {sHelp, hhelp }, help =  true, hidden = true)
		 //default value
		 private static boolean help;
		 		
		 
		 public static void main(String[] args) 
		{
			 JCommander	CLI = new JCommander(new SeleniumMultipleCLO(), args);	
			 if(help)
			 {
				CLI.usage();
				System.exit(0);
			 }

			WebDriver driver = new FirefoxDriver();    // Version 1.1 :: Firefox
			
			for (int i = 0; i < list.size(); i++) 
			{

			String text_case_id = "TC-001.01" + (i + 1);
			String param[] = list.get(i).split("\\|");
			String url = param[0] ;
			String title_expected = param[1];
			
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			String title_actual = driver.getTitle();

			if (title_expected.equals(title_actual)) {
				System.out.println("__________start__________" );
				System.out.println("Test Case ID: \t\t" + text_case_id);
				System.out.println("URL: \t\t\t" + url);
				System.out.println("Title Expected: \t" + title_expected);
				System.out.println("Title Actual: \t\t" + title_actual);
				System.out.println("Test Case Result: \t" + "PASSED");
				System.out.println("___________end___________" );
			} else {
				System.out.println("__________start__________" );
				System.out.println("Test Case ID: \t\t" + text_case_id);
				System.out.println("URL: \t\t\t" + url);
				System.out.println("Title Expected: \t" + title_expected);
				System.out.println("Title Actual: \t\t" + title_actual);
				System.out.println("Test Case Result: \t" + "FAILED");
				System.out.println("___________end___________" );
			         }
			
			}
			driver.quit();
		}
}