package TransactionAnalyzerWithClasses;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankTransactionAnalyzerWParsingMethods {
	private static final String RESOURCES = "src/main/resources/";

	public static void main(String[] args) throws IOException {
	    		    	
	    	final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();
		
		final String fileName = args[0];
	    	final Path path = Paths.get(RESOURCES + args[0]);
		final List<String> lines = Files.readAllLines(path);
		
		final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);
		final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
		
		collectSummary(bankStatementProcessor);
		
//		System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount(bankTransactions));
//		System.out.println("Transactions in January:\n" + BankTransaction.selectInMonth(bankTransactions, Month.JANUARY));		
	}
	
		private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
		    System.out.println("The total for transactions in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
		    System.out.println("The total for transactions in January is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
		    System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
		}
}
