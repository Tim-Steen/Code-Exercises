import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidString {
    public static void sentenceChecker(String sentence) {
        boolean isValid = false;
        int quoteCounter = 0; // Initializing my counter as 0 for now, until used

        if (Character.isUpperCase(sentence.charAt(0))) {
            if (sentence.endsWith("?") || sentence.endsWith(".") || sentence.endsWith("!")) {
                for (int i = 0; i < sentence.length(); i++) {
                    if (sentence.charAt(i) == '"') {
                        quoteCounter++;
                    }
                }
                if (quoteCounter % 2 == 0) { // this must mean that the quotes are even
                    isValid = true; // This happens if all criteria is met so far for a valid sentence
                }
            }
        }
        for (int i = 0; i < sentence.length() - 1; i++) {
            if (sentence.charAt(i) == '.') { // This is also evaluated before the final verdict is reached
                isValid = false;
                break;
            }
        }

        /* Here a pattern is made use of; if a number is seen, following code is performed to assess if
        it meets the number criterion, otherwise the sentence is fine
         */
        Pattern pat = Pattern.compile("[0-9]");
        Matcher mc = pat.matcher(sentence);
        if (mc.find()) {
            sentence = sentence.replaceAll("[^0-9]", " ");
            sentence = sentence.trim();
            sentence = sentence.replaceAll(" + ", " ");
            int number = Integer.parseInt(sentence);

            if (number <= 13) {
                isValid = false;
            }
        }
        if (isValid) { // shorthand true
            System.out.println("This is a valid sentence.");
        } else {
            System.out.println("This is not a valid sentence.");
        }
    }

    public static void main(String[] args) {
        // Within this main method a scanner is used, as the user can choose what sentence to test
        Scanner input = new Scanner(System.in);
            System.out.print("Enter a sentence\t>>\t ");
            String sentence = input.nextLine();
            while (sentence.isEmpty()) { // it is to take care of empty input...
                System.out.print("Enter a sentence\t>>\t ");
                sentence = input.nextLine();
            }
            sentenceChecker(sentence);
    }
}