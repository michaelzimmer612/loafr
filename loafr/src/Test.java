import java.io.FileNotFoundException;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		Analyzer a = new Analyzer();
		
		System.out.println("Original Data:");
		a.addLogFile("testdata1.csv");
		a.printAnalyzerData();
		System.out.println("\n");
		
		System.out.println("Original Data with Unfiltered print function:");
		a.printUnfilteredData();
		System.out.println("\n");
		
		
		System.out.println("Filtered for rows with sugarlevel = 15 :");
		a.addOperation("filter", "sugarLevel", 15, true);
		a.printUnfilteredData();

	}

}
