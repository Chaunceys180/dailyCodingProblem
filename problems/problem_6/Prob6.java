package problem_6;

import java.util.Stack;

/**
 * @author Chauncey Brown-Castro
 * @version 1.0
 */
public class Prob6 {

    private static final String BRACKET = "([])[]({})";
    private static final String BAD_BRACKET_1 = "([)]";
    private static final String BAD_BRACKET_2 = "((()";

    /**
     * @param args command line args
     */
    public static void main(String[] args) {
        System.out.println("Is " + BRACKET + " a good bracket?: " + areBracketsMatching(BRACKET));
        System.out.println("Is " + BAD_BRACKET_1 + " a good bracket?: " + areBracketsMatching(BAD_BRACKET_1));
        System.out.println("Is " + BAD_BRACKET_2 + " a good bracket?: " + areBracketsMatching(BAD_BRACKET_2));
    }

    /**
     * This function tells you if a string of brackets are formatted correctly
     * @param param the string to be checked
     * @return true if valid
     */
    public static boolean areBracketsMatching(String param) {

        if(!isStringEvenLength(param)) { //if it's odd, its wrong dont check further
            return false;
        }

        //convert the chars to an array
        char[] brackets = param.toCharArray();

        //make a stack to keep track of things
        Stack<Character> bracketStack = new Stack<>();

        for(char bracket : brackets) { //cycle through the brackets

            if(isOpeningBracket(bracket)) {
                //keep track of openings, so that when we reach a closing, we know it matches the last opening
                bracketStack.add(bracket);
            } else if(bracketStack.isEmpty() || !isMatchingPair(bracketStack.pop(), bracket)) {
                //if it starts with a closing, its wrong.
                //if the next closing doesnt match the last opening checked, wrong
                return false;
            }
        }
        //if all opening's haven't been removed, there wasn't a closing bracket for each one so it's wrong.
        return bracketStack.isEmpty();
    }

    /**
     * This function returns false if a string is of odd length
     * @param param the string to be checked
     * @return true if even, false if odd
     */
    public static boolean isStringEvenLength(String param) {
        return param.length() % 2 == 0;
    }

    /**
     * This function will tell you if brackets (){}[] are passed the opening bracket
     * @param bracket (, {, or [
     * @return true if (, [, {, false otherwise
     */
    public static boolean isOpeningBracket(char bracket) {
        return bracket == '[' || bracket == '{' || bracket == '(';
    }

    /**
     * This function will tell you if the brackets in param 1&2 complete each other (, [, { and ), ], }
     * @param bracket1 opening bracket
     * @param bracket2 closing bracket
     * @return true or false if they match and are of same type
     */
    public static boolean isMatchingPair(char bracket1, char bracket2) {
        if(bracket1 == '[' && bracket2 == ']') {
            return true;
        } else if(bracket1 == '{' && bracket2 == '}') {
            return true;
        } else {
            return bracket1 == '(' && bracket2 == ')';
        }
    }
}
