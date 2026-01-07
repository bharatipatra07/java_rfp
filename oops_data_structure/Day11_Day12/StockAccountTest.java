import java.time.LocalDateTime;
import java.io.*;
import java.util.*;
 class CompanyShares {

    private String stockSymbol;
    private int numberOfShares;
    private LocalDateTime transactionTime;

    public CompanyShares(String stockSymbol, int numberOfShares) {
        this.stockSymbol = stockSymbol;
        this.numberOfShares = numberOfShares;
        this.transactionTime = LocalDateTime.now();
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public void addShares(int shares) {
        this.numberOfShares += shares;
        this.transactionTime = LocalDateTime.now();
    }

    public void removeShares(int shares) {
        this.numberOfShares -= shares;
        this.transactionTime = LocalDateTime.now();
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }
}

 class StockAccount {

    private List<CompanyShares> companySharesList = new ArrayList<>();

    public StockAccount(String filename) {
        loadFromFile(filename);
    }

    public double valueOf() {
        double totalValue = 0;
        for (CompanyShares cs : companySharesList) {
            totalValue += cs.getNumberOfShares() * getSharePrice(cs.getStockSymbol());
        }
        return totalValue;
    }
    public void buy(int amount, String symbol) {
        CompanyShares cs = findCompanyShares(symbol);

        if (cs != null) {
            cs.addShares(amount);
        } else {
            companySharesList.add(new CompanyShares(symbol, amount));
        }
        System.out.println("Bought " + amount + " shares of " + symbol);
    }

    public void sell(int amount, String symbol) {
        CompanyShares cs = findCompanyShares(symbol);

        if (cs == null) {
            System.out.println("Stock not found.");
            return;
        }

        if (cs.getNumberOfShares() < amount) {
            System.out.println("Not enough shares to sell.");
            return;
        }

        cs.removeShares(amount);
        System.out.println("Sold " + amount + " shares of " + symbol);
    }

    public void save(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (CompanyShares cs : companySharesList) {
                bw.write(cs.getStockSymbol() + "," + cs.getNumberOfShares());
                bw.newLine();
            }
            System.out.println("Account saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printReport() {
        System.out.println("\n------ Stock Account Report ------");
        for (CompanyShares cs : companySharesList) {
            System.out.println(
                    "Stock: " + cs.getStockSymbol() +
                            ", Shares: " + cs.getNumberOfShares() +
                            ", Last Transaction: " + cs.getTransactionTime()
            );
        }
        System.out.println("Total Account Value: $" + valueOf());
    }

    private CompanyShares findCompanyShares(String symbol) {
        for (CompanyShares cs : companySharesList) {
            if (cs.getStockSymbol().equalsIgnoreCase(symbol)) {
                return cs;
            }
        }
        return null;
    }

    private double getSharePrice(String symbol) {
        return 100.0; // fixed price for simplicity
    }

    private void loadFromFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                companySharesList.add(
                        new CompanyShares(data[0], Integer.parseInt(data[1]))
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class StockAccountTest {

    public static void main(String[] args) {

        StockAccount account = new StockAccount("stocks.txt");

        account.buy(10, "TCS");
        account.buy(5, "INFY");
        account.sell(2, "TCS");

        account.printReport();
        account.save("stocks.txt");
    }
}
