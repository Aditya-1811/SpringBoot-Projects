import org.springframework.stereotype.Service;
import yahoofinance.YahooFinance;

@Service
public class StockService {
    public StockWrapper findStock(String stockSymbol) {
        try {
            return new StockWrapper(YahooFinance.get(stockSymbol));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
