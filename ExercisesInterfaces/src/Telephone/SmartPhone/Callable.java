package Telephone.SmartPhone;

public interface Callable {

    default String calling(String number){
        if (!number.matches("^\\d+$")) {
            return "Invalid number!";
        }

        return "Calling... " + number;
    }
}
