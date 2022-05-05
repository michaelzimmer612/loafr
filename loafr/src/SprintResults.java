
public class SprintResults {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

		//create new analyzer object to hold log file data and allow for operations ot be performed
		Analyzer a = new Analyzer();
		
		//import log file from csv and display contents
		System.out.println("Original Data:");
		a.addLogFile("testdata2.csv");
		a.printAnalyzerData();
		System.out.println("count");
		System.out.println(a.count());
		System.out.println("average blood sugar");
		System.out.println(a.average());
		System.out.println();
		
		System.out.println("Original Data with Unfiltered print function:");
		a.printUnfilteredData();
		System.out.println("count");
		System.out.println(a.count());
		System.out.println("average blood sugar");
		System.out.println(a.average());
		System.out.println();
		
		
		
		//apply a filter to imported data based on sugar level and display results
		System.out.println("Filtered for rows with sugarlevel != 15 :");
		a.addOperation("filter", "sugarLevel", 15, false);
		a.printUnfilteredData();
		System.out.println("count");
		System.out.println(a.count());
		System.out.println("average blood sugar");
		System.out.println(a.average());
		System.out.println();
		
		
		
		//apply a filter to imported data based on sugar level, while previous filter is still in effect, and display results
		System.out.println("Filtered for rows with sugarlevel != 5 :");
		a.addOperation("filter", "sugarLevel", 5, false);
		a.printUnfilteredData();
		System.out.println("count");
		System.out.println(a.count());
		System.out.println("average blood sugar");
		System.out.println(a.average());
		System.out.println();
		
		
		
		//apply a filter to imported data based on sugar level, while previous filter is still in effect, and display results
		System.out.println("Filtered for rows with sugarlevel = 350 :");
		a.addOperation("filter", "sugarLevel", 350, true);
		a.printUnfilteredData();
		System.out.println("count");
		System.out.println(a.count());
		System.out.println("average blood sugar");
		System.out.println(a.average());
		System.out.println();
		
		
		//apply a filter to imported data based on sugar level, while previous filter is still in effect, and display results
		System.out.println("Filtered for rows with sugarlevel = 5 :");
		a.addOperation("filter", "sugarLevel", 5, true);
		a.printUnfilteredData();
		System.out.println("count");
		System.out.println(a.count());
		System.out.println("average blood sugar");
		System.out.println(a.average());
		System.out.println();
		
		
		
		
		//create new analyzer object to hold log file data and allow for operations to be performed
		Analyzer b = new Analyzer();
				
		//import log file from csv and display contents
		//This next block of code demonstrates the count and average functions on a larger initial data set
		System.out.println("Larger Data Set Data:");
		b.addLogFile("testdata3.csv");
		b.printAnalyzerData();
		System.out.println("count (expected value = 35)");
		System.out.println(b.count());
		System.out.println("average blood sugar (expected value = 97) ");
		System.out.println(b.average());
		System.out.println();
		
		
		
		System.out.println("Filtered for rows with sugarlevel != 7 :");
		b.addOperation("filter", "sugarLevel", 7, false);
		b.printUnfilteredData();
		System.out.println("count");
		System.out.println(b.count());
		System.out.println("average blood sugar");
		System.out.println(b.average());
		System.out.println();
		
		
		
		//apply a filter to imported data based on sugar level, while previous filter is still in effect, and display results
		System.out.println("Filtered for rows with sugarlevel != 45 :");
		b.addOperation("filter", "sugarLevel", 45, false);
		b.printUnfilteredData();
		System.out.println("count");
		System.out.println(b.count());
		System.out.println("average blood sugar");
		System.out.println(b.average());
		System.out.println();
		
		
		
		//apply a filter to imported data based on sugar level, while previous filter is still in effect, and display results
		System.out.println("Filtered for rows with sugarlevel = 350 :");
		b.addOperation("filter", "sugarLevel", 350, true);
		b.printUnfilteredData();
		System.out.println("count");
		System.out.println(b.count());
		System.out.println("average blood sugar");
		System.out.println(b.average());
		System.out.println();
		
		
		//apply a filter to imported data based on sugar level, while previous filter is still in effect, and display results
		System.out.println("Filtered for rows with sugarlevel = 5 :");
		b.addOperation("filter", "sugarLevel", 5, true);
		b.printUnfilteredData();
		System.out.println("count");
		System.out.println(b.count());
		System.out.println("average blood sugar");
		System.out.println(b.average());
		System.out.println();
		

		
		
		

	}

}
