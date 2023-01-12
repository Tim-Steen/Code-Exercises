
/* Test class, used for testing each possible rule that determines sentence validity -- same sentence is
    used for each criteria to be able to check every condition of it which may be true or false
 */

public class ValidStringTester {

    public static void main(String[] args) {
        // testing the uppercase rule
        ValidString.sentenceChecker("the two elderly gentlemen, Harold and Seth, said \"hello there, Mr Smith\".");
        System.out.println();

        // testing the punctuation rule
        ValidString.sentenceChecker("The two elderly gentlemen, Harold and Seth, said \"hello there, Mr Smith\"");
        System.out.println();

        // testing the quotation rule -- valid quotes, then invalid
        ValidString.sentenceChecker("The two elderly gentlemen, Harold and Seth, said \"hello there, Mr Smith\".");
        ValidString.sentenceChecker("The two elderly gentlemen, Harold and Seth, said \"\"hello there, Mr Smith\".");
        System.out.println();

        // testing the period rule
        ValidString.sentenceChecker("The two elderly gentlemen, Harold and Seth, said \"hello there, Mr. Smith\".");
        System.out.println();

        // testing the number rule
        ValidString.sentenceChecker("The 2 elderly gentlemen, Harold and Seth, said \"hello there, Mr Smith\".");
        System.out.println();

        // testing a fully valid sentence
        ValidString.sentenceChecker("The two elderly gentlemen, Harold and Seth, said \"hello there, Mr Smith\".");
        System.out.println();
        System.out.println("SWITCHING SENTENCES... \n");


        // A new sentence now... same testing order as above
        ValidString.sentenceChecker("it was a very windy day, because six birds were blown from the trees!");
        System.out.println();

        ValidString.sentenceChecker("It was a very windy day, because six birds were blown from the trees");
        System.out.println();

        ValidString.sentenceChecker("It was a very windy day, because six birds were \"blown from the trees\"!");
        ValidString.sentenceChecker("It was a very windy day, because six birds were \"\"blown from the trees\"!");
        System.out.println();

        ValidString.sentenceChecker("It was a very windy day. Because six birds were blown from the trees!");
        System.out.println();

        ValidString.sentenceChecker("It was a very windy day, because 6 birds were blown from the trees!");
        System.out.println();

        ValidString.sentenceChecker("It was a very windy day, because six birds were blown from the trees!");

    }
}