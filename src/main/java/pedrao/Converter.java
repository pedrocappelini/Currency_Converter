package pedrao;

import java.util.Map;

public class Converter {

    private final Map<String, Double> rates;

    public Converter(Map<String, Double> rates) {
        this.rates = rates;
    }

    public double convert(double amount, String from, String to) {
        double fromRate = rates.getOrDefault(from, -1.0);
        double toRate = rates.getOrDefault(to, -1.0);
        if (fromRate == -1 || toRate == -1) {
            return -1;
        }
        return Math.round((amount * toRate / fromRate) * 100.0) / 100.0;
    }
}