package problem_5;

import java.util.ArrayList;
import java.util.List;

public class Prob5 {

    private static String[] array = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
    private static final int CHAR_CAP = 16;

    public static void main(String[] args) {

        //first lets create the phrases
        List<String> phrases = new ArrayList<>();
        StringBuilder words = new StringBuilder();

        for(int i = 0; i < array.length; i++) {

            if(array[i].length() + words.length() < CHAR_CAP) { //if it wont go over the cap, add it
                words.append(array[i] + " ");
            } else if(array[i].length() + words.length() > CHAR_CAP) { //it breaks the cap, so add the current words and start on a new words
                phrases.add(words.toString().trim());
                words = new StringBuilder();
                words.append(array[i] + " ");
            }

            if(i+1 >= array.length) {
                phrases.add(words.toString().trim());
            }
        }

        //now i have the phrases, check if theyre spaced right
        for(String s : phrases) {
            System.out.println(buildPhrase(s));
        }
    }

    private static String buildPhrase(String phrase) {

        //init varible to build final string
        StringBuilder newPhrase = new StringBuilder();

        //make a copy with no spaces to calc how many spaces can be added
        String phraseCopy = phrase.replaceAll(" ", "");

        int numOfSpacesToBeAdded = CHAR_CAP - phraseCopy.length();

        //get the words themselves.
        String[] words = phrase.split(" ");

        //find out the number of words
        int numOfWords = words.length;

        //find out the number of spaces in between words
        int spacesBetweenTwoWords = numOfWords - 1;

        int remainder = numOfSpacesToBeAdded % spacesBetweenTwoWords;

        if(remainder == 1) { //there's a leftoverspace so make it get added on the left
            int spaceLength = numOfSpacesToBeAdded / spacesBetweenTwoWords;

            String regex = buildSpaces(spaceLength);
            String leftMostRemainder = regex + " ";

            for(int i = 0; i < 1; i++) {
                phrase = phrase.replace(" ", buildSpaces(spaceLength));
            }

            phrase = phrase.replaceFirst(regex, leftMostRemainder);

        } else { //no leftover space

            phrase = phrase.replace(" ", buildSpaces(numOfSpacesToBeAdded / spacesBetweenTwoWords));

        }

        return phrase.toString();
    }

    private static String buildSpaces(int spaceLength) {
        StringBuilder spaces = new StringBuilder();;

        for(int i = 0; i < spaceLength; i++) {
            spaces.append(" ");
        }

        return spaces.toString();
    }
}
