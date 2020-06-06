package main.java.com;

public class MainApplication {

    public static void main(String... args) throws Exception {

        final BankStatementAnalyzer bankStatementAnalyzer
                = new BankStatementAnalyzer();

        final BankStatementParser bankStatementParser
                = new BankStatementCSVParser();

        bankStatementAnalyzer.analyze("resources.csv", bankStatementParser);

    }
}
