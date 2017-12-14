package Utility;

public class Validator {
    public static void validatePropertyValue(int value, String propertyName) {
        if (value <= 0) {
            throw new IllegalArgumentException(String.format(Constants.INCORRECT_PROPERTY_VALUE_MESSAGE, propertyName));
        }
    }

    public static void validateBoatModelLength(String value) {
        int minModelLength = Constants.MIN_BOAT_MODEL_LENGTH;
        if (value.length() < minModelLength) {
            throw new IllegalArgumentException(String.format(Constants.INCORRECT_MODEL_LENGTH_MESSAGE, minModelLength));
        }
    }

    public static void validateEngineModelLength(String value) {
        int minModelLength = Constants.MIN_BOAT_ENGINE_MODEL_LENGTH;
        if (value.length() < minModelLength) {
            throw new IllegalArgumentException(String.format(Constants.INCORRECT_MODEL_LENGTH_MESSAGE, minModelLength));
        }
    }

    public static void validateSailEffectiveness(int value) {
        if (value < 1 || value > 100) {
            throw new IllegalArgumentException(Constants.INCORRECT_SAIL_EFFICIENCY_MESSAGE);
        }
    }
}
