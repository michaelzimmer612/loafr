
import java.io.FileNotFoundException;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		Analyzer a = new Analyzer();
		
		System.out.println("Original Data:");
		a.addLogFile("testdata2.csv");
		a.printAnalyzerData();
		System.out.println();
		
		System.out.println("Original Data with Unfiltered print function:");
		a.printUnfilteredData();
		System.out.println();
		
		
		System.out.println("Filtered for rows with sugarlevel != 15 :");
		a.addOperation("filter", "sugarLevel", 15, false);
		a.printUnfilteredData();
		
		System.out.println("Filtered for rows with sugarlevel != 5 :");
		a.addOperation("filter", "sugarLevel", 5, false);
		a.printUnfilteredData();
		
		System.out.println("Filtered for rows with sugarlevel = 350 :");
		a.addOperation("filter", "sugarLevel", 350, true);
		a.printUnfilteredData();
		
		System.out.println("Filtered for rows with sugarlevel = 5 :");
		a.addOperation("filter", "sugarLevel", 5, true);
		a.printUnfilteredData();
		
	}
}
