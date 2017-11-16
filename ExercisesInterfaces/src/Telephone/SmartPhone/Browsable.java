package Telephone.SmartPhone;

public interface Browsable {

    default String browsing(String site){
        if (!site.matches("^\\D+$")) {
            return "Invalid URL!";
        }

        return "Browsing: " + site + "!";
    }
}
