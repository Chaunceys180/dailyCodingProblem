package problem_2;

public class Prob2 {

    private static final int[] TEST_ARRAY = new int[] {3,5,2,4,6,8};

    public static void main(String[] args) {

        //find the k-th largest element in the list

        System.out.println(findKthElm(TEST_ARRAY, 5));

    }

    public static int findKthElm(int[] array, int num) {

        int largest = 0;

        for(int i = 0; i < num; i++) {
            if(array[i] > largest) {
                largest = array[i];
            }
        }
        return largest;
    }
}
