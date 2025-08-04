package lab4to10;

public class Lab10 {

    public static boolean isPositiveString(String str) {
        str = str.toUpperCase();

        for (int i = 0; i < str.length() - 1; i++) {
            
            if (str.charAt(i) > str.charAt(i + 1)) {
                return false;
            }
        }

        return true; 
    }

    public static void main(String[] args) {
        String input = "ANT";
        if (isPositiveString(input)) {
            System.out.println(input + " is a Positive String.");
        } else {
            System.out.println(input + " is NOT a Positive String.");
        }
    }
}
