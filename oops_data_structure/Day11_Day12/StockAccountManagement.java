import java.util.ArrayList;
import java.util.Scanner;

class Stock {
    private String stockName;
    private int numberOfShares;
    private double sharePrice;

    public Stock(String stockName, int numberOfShares, double sharePrice) {
        this.stockName = stockName;
        this.numberOfShares = numberOfShares;
        this.sharePrice = sharePrice;
    }

    public double getStockValue() {
        return numberOfShares * sharePrice;
    }

    public String getStockName() {
        return stockName;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public double getSharePrice() {
        return sharePrice;
    }
}

class StockPortfolio {
    private ArrayList<Stock> stockList = new ArrayList<>();

    public void addStock(Stock stock) {
        stockList.add(stock);
    }

    public double getTotalPortfolioValue() {
        double totalValue = 0;
        for (Stock stock : stockList) {
            totalValue += stock.getStockValue();
        }
        return totalValue;
    }

    public void printStockReport() {
        System.out.println("\n------ Stock Report ------");
        for (Stock stock : stockList) {
            System.out.println(
                    "Stock Name: " + stock.getStockName() +
                            ", Shares: " + stock.getNumberOfShares() +
                            ", Price: " + stock.getSharePrice() +
                            ", Value: " + stock.getStockValue()
            );
        }
        System.out.println("Total Stock Portfolio Value: " + getTotalPortfolioValue());
    }
}

public class StockAccountManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StockPortfolio portfolio = new StockPortfolio();

        System.out.print("Enter number of stocks: ");
        int numberOfStocks = scanner.nextInt();

        for (int i = 1; i <= numberOfStocks; i++) {
            System.out.println("\nEnter details for Stock " + i);

            System.out.print("Stock Name: ");
            String name = scanner.next();

            System.out.print("Number of Shares: ");
            int shares = scanner.nextInt();

            System.out.print("Share Price: ");
            double price = scanner.nextDouble();

            Stock stock = new Stock(name, shares, price);
            portfolio.addStock(stock);
        }

        portfolio.printStockReport();
        scanner.close();
    }
}
