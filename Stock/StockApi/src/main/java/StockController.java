import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@EnableAutoConfiguration
public class StockController {
    @GetMapping(value = "/api/stockDetails/{stockSymbol}")
    @ResponseBody
     String home(@PathVariable("stockSymbol") String stockSymbol) throws IOException {
        StockService stockService = new StockService();
        return stockSymbol + " " + stockService.findStock(stockSymbol).stock().getQuote().getAvgVolume();
    }

    @RequestMapping(
            value = "api/request",
            params = {"stockSymbol"},
            method = RequestMethod.GET
    )
    @ResponseBody
    String getDetails(String stockSymbol) {
        StockService stockService = new StockService();
        return stockSymbol + " price: " + stockService.findStock(stockSymbol).stock().getQuote().getPrice();
    }

    public static void main(String[] args) {
        SpringApplication.run(StockController.class, args);
    }
}
