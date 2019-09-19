package problem_7;

import java.util.Arrays;

/**
 * This class solves problem number 7
 * @author Chauncey Brown-Castro
 * @version 1.0
 */
public class prob7 {

    private static final int[] INPUT = new int[] {2,2,2,1,1,0};
    private static final int[] EXPECTED_OUTPUT = new int[] {0,1,1,2,2,2};

    /**
     * Main method to test function output
     * @param args command line args
     */
    public static void main(String[] args) {

        int[] array = sortColors(INPUT.clone());

        System.out.println("Input: " + Arrays.toString(INPUT));
        System.out.println("Output: " + Arrays.toString(array));
        System.out.println("Expected: " + Arrays.toString(EXPECTED_OUTPUT));

        boolean isEqual = Arrays.toString(array).equals(Arrays.toString(EXPECTED_OUTPUT));

        if(isEqual) {
            System.out.println("Sorted Successfully!");
        } else {
            System.out.println("Unexpected Output.");
        }
    }

    /**
     * @param nums array of numbers representing color. 0 = red, white = 1, blue = 2
     * @return returns a sorted array, low to high
     */
    public static int[] sortColors(int[] nums) {

        //check for a valid array
        if(nums == null || nums.length <= 1) {
            return null;
        }

        //look through the length of the array, but dont start on edge case
        for(int i = 1; i < nums.length; i++) {

            //to reset index if i go back too far in comparisons
            i = isIndexLessThanOne(i) ? 1 : i;

            //if left is greater than right, switch them
            if(nums[i-1] > nums[i]) {
                swap(nums, i - 1, i);
                i = i - 2;
            }
        }
        return nums;
    }

    /**
     * @param index number of the current index
     * @return true|false if less than 1
     */
    public static boolean isIndexLessThanOne(int index) {
        return index < 1;
    }

    /**
     * This function swaps two elements located at the index's specified.
     * @param nums an array to be operated on
     * @param index1 position of element 1
     * @param index2 position of element 2
     */
    public static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}