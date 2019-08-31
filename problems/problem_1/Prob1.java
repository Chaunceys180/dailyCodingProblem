package problem_1;

/**
 *
 * @author Chauncey Brown-Castro
 * @version 1.0
 */
public class Prob1 {

    private final static int[] TEST_ARRAY_1 = new int[] {2,1,2};
    private final static int[] TEST_ARRAY_2 = new int[] {6,2,6,0,2,1,4};

    /**
     * @param args command line arguments
     */
    public static void main(String[] args) {

        //System.out.println(countSpaces(TEST_ARRAY_1));

        System.out.println(countSpaces(TEST_ARRAY_2, TEST_ARRAY_2.length));

    }

    private static int countSpaces(int[] arr, int n) {
        //look left and look right, but watch for edge cases since we cant look
        //left on index 0, and right on array.length

        // initialize output
        int result = 0;

        // maximum element on left and right
        int leftMax = 0, rightMax = 0;

        // indices to traverse the array
        int low = 0, high = n-1;

        while(low <= high) {

            if(arr[low] < arr[high]) {

                if(arr[low] > leftMax) { // update max in left

                    leftMax = arr[low];

                } else { // water on curr element =  max - curr

                    result += leftMax - arr[low];

                }

                //increment the index
                low++;

            } else {

                if(arr[high] > rightMax) { // update right maximum

                    rightMax = arr[high];

                } else { //the remainder will fill with water, so add it to the result

                    result += rightMax - arr[high];

                }

                //decrement the index
                high--;

            }
        }
        return result;
    }
}
