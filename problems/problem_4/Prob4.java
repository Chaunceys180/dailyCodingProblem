package problem_4;

import java.util.Arrays;

public class Prob4 {

    private static int[] array = new int[] {0,1,0,3,12};
    private static final int[] EXPECTED = new int[] {1,3,12,0,0};

    public static void main(String[] args) {

        for(int i = 0; i < array.length; i++) {
            if(array[i] == 0) {
                array = sortZeros(array, i);
            }
        }

        System.out.println("INITIAL ARRAY: [0,1,0,3,12]");
        System.out.println("EXPECTED: [1,3,12,0,0]");
        System.out.println("DO THEY MATCH?: " + Arrays.toString(array).equals(Arrays.toString(EXPECTED)));
        System.out.println("ACTUAL: " + Arrays.toString(array).replaceAll(" ", ""));

    }

    private static int[] sortZeros(int[] array, int index) {

        for(int i = index; i < array.length; i++) {
            if(array[i] == 0 && i+1 != array.length) {
                int temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
            }
        }
        return array;
    }
}
