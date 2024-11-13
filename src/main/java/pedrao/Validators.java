package pedrao;

public class Validators {

    public String[] readBaseInput(String baseString) {
        if (baseString == null || baseString.isEmpty()) {
            return new String[]{"error1"};
        }
        if (!baseString.contains(" to ")) {
            return new String[]{"error2"};
        }
        String[] input = baseString.split(" to ");
        if (input[0].length() != 3 || input[1].length() != 3 || input[0].equalsIgnoreCase(input[1])) {
            return new String[]{"error3"};
        }
        return new String[]{input[0].toLowerCase(), input[1].toLowerCase()};
    }

    public double value(String input) throws NumberFormatException {
        double amount = Double.parseDouble(input);
        if (amount <= 0) {
            throw new NumberFormatException("Amount must be positive.");
        }
        return amount;
    }
}