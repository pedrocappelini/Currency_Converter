package pedrao;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

    static Map<String, Double> ExchangeRates = new HashMap<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        loadExchangeRates();
        CcUI ui = new CcUI(stage, new Validators(), new Converter(ExchangeRates));
        ui.buildUI();
    }

    public void loadExchangeRates() {
        String url = "https://api.freecurrencyapi.com/v1/latest?apikey=fca_live_gw8lgbL4CpfTLvMRc9GTYdydWEqt5z8VIx4muR9S";
        try {
            String response = CurrencyApi.sendGetRequest(url);
            ExchangeRates = CurrencyApi.parseExchangeRates(response);
        } catch (Exception e) {
            System.out.println("Error fetching exchange rates: " + e.getMessage());
        }
    }
}