package main.java.com;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class FinancialAnalyzerSimple {
    private static final String RESOURCES = "src/main/resources/";
    private static final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();


    public static void main(final String... args) throws Exception {

        final String filename = "resources.csv";
        final Path path = Paths.get(RESOURCES + filename);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transactions is "
                + bankStatementProcessor.calculateTotalAmout());

        System.out.println("The total for transactions in January is "
                + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));

        System.out.println("The total for transactions in January is "
                + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));

        System.out.println("The toatl salary received is "
                + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}
