package airline;

public class InputValidator {
    public static int positiveInt(String value) throws ValidationException {
        try {
            int number = Integer.parseInt(value.trim());
            if (number <= 0) throw new ValidationException("Value must be greater than zero.");
            return number;
        } catch (NumberFormatException e) {
            throw new ValidationException("Please enter a valid integer.");
        }
    }

    public static double positiveDouble(String value) throws ValidationException {
        try {
            double number = Double.parseDouble(value.trim());
            if (number <= 0) throw new ValidationException("Value must be greater than zero.");
            return number;
        } catch (NumberFormatException e) {
            throw new ValidationException("Please enter a valid number.");
        }
    }

    public static void required(String value, String field) throws ValidationException {
        if (value == null || value.trim().isEmpty()) {
            throw new ValidationException(field + " cannot be empty.");
        }
    }
}
