package Utility;

public class Constants {
    public static final String INCORRECT_MODEL_LENGTH_MESSAGE = "Model's name must be at least %s symbols long.\n";

    public static final String INCORRECT_PROPERTY_VALUE_MESSAGE = "%s must be a positive integer.\n";

    public static final String INCORRECT_SAIL_EFFICIENCY_MESSAGE = "Sail Effectiveness must be between [1...100].\n";

    public static final String INCORRECT_ENGINE_TYPE_MESSAGE = "Incorrect engine type.\n";

    public static final String DUPLICATE_MODEL_MESSAGE = "An entry for the given model already exists.\n";

    public static final String NON_EXISTENT_MODEL_MESSAGE = "The specified model does not exist.\n";

    public static final String RACE_ALREADY_EXISTS_MESSAGE = "The current race has already been set.\n";

    public static final String NO_SET_RACE_MESSAGE = "There is currently no race set.\n";

    public static final String INSUFFICIENT_CONTESTANTS_MESSAGE = "Not enough contestants for the race.\n";

    public static final String INCORRECT_BOAT_TYPE_MESSAGE = "The specified boat does not meet the race constraints.\n";

    public static final String SUCCESSFULLY_ADDED_BOAT = "%s boat with model %s registered successfully.";

    public static final int MIN_BOAT_MODEL_LENGTH = 5;

    public static final int MIN_BOAT_ENGINE_MODEL_LENGTH = 3;
}
