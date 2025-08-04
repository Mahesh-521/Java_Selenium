package lab4to10;

public class Lab9 {

	public static String userChoice(String input, int choice) {
		switch (choice) {
        case 1:
            return input + input; 
        case 2:
            String res = "";
            for (int i = 0; i < input.length(); i++) {
                if(i%2==0) {
                	res+="#";
                }else {
                	res+=input.charAt(i);
                }
            }
            return res;
        case 3:
            StringBuilder unique = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (unique.indexOf(String.valueOf(ch)) == -1) {
                    unique.append(ch);
                }
            }
            return unique.toString();

        case 4:
        	String res1 = "";
            for (int i = 0; i < input.length(); i++) {
                if(i%2==0) {
                	res1+=(input.charAt(i)+"").toUpperCase();
                }else {
                	res1+=input.charAt(i);
                }
            }
            return res1;

        default:
            return "Invalid choice!";
    }
	}
	public static void main(String[] args) {
		String input = "apple";
        int choice = 4;  

        String result = userChoice(input, choice);
        System.out.println("Result: " + result);
		

	}

}
