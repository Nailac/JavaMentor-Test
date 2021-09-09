import java.util.Arrays;

public class InputParser {
    public static void parse( String input ) {
        // "V" или "10"
    }

    public boolean isArab(String value) {
        String[] arabs = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        if(Arrays.stream(arabs).anyMatch(x -> value.equals(x))) {
            return true;
        }
        return false;
    }
    public boolean isRoman(String value) {
        String[] romans = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        if(Arrays.stream(romans).anyMatch(x -> value.equals(x))) {
            return true;
        }
        return false;
    }
}
