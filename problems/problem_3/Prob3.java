package problem_3;

import java.util.*;

public class Prob3 {

    private static final String TEST_STRING = "HFVGSBVSHDGGGGSFRHBSNNNSHHSGG";
    private static final String EXPECTED = "1H1F1V1G1S1B1V1S1H1D4G1S1F1R1H1B1S3N1S2H1S2G";

    public static void main(String[] args) {

        int counter = 0;
        Stack<String> letterSet = new Stack<>();
        StringBuilder result = new StringBuilder();

        for(int i = 0; i <= TEST_STRING.length(); i++) { //i loop 1 past the length to i know i've reached the end

            String currLetter = "";

            if(i < TEST_STRING.length()) {
                currLetter = String.valueOf(TEST_STRING.charAt(i)); //getting the current letter if not at the end
            }

            if(letterSet.contains(currLetter)) { //if its consecutive, increment the counter

                counter++;

            } else if(!letterSet.contains(currLetter)) { //not consecutive, new letter

                if(!letterSet.isEmpty()) { //first letter?

                    result.append(counter);
                    result.append(letterSet.pop()); //add prev letter since we're done keeping
                                                    // track of it instead of currLetter

                } else if(i == TEST_STRING.length() - 1) { //last letter?

                    result.append(counter);
                    result.append(currLetter);

                }

                counter = 1; //reset counter
                letterSet.clear(); //clear the old letter
                letterSet.add(currLetter); //add new letter
            }

        }

        System.out.println("DOES OUTPUT MATCH THE EXPECTED OUTPUT?: ");
        System.out.println(EXPECTED.equals(result.toString()));
        System.out.println("RESULT: " + result + " EXPECTED: " + EXPECTED);

    }


}
