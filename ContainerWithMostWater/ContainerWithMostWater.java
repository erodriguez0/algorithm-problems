import java.util.Arrays;
import java.util.Random;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        Random r = new Random();
        int[] data = r.ints(5, 1, 10).toArray();
        int maxArea = maxArea(data);
        System.out.println("Input: " + Arrays.toString(data));
        System.out.printf("Output: %d\n", maxArea);
    }

    /**
     * Calculates the highest value using two points from the array
     * as the sides of a container (y-axis) alongside the x-axis (the difference
     * between both points).
     *
     * @param data the array containing the line heights forming the container
     * @return the maximum area calculated from two points in the array
     */
    public static int maxArea(int[] data) {
        int max = 0, i = 0, j = data.length - 1;

        /**
         * Use two pointers to iterate through array one at the beginning (i)
         * and the other in the end (j). If data[i] is smaller then i is incremented
         * else j is decremented.
         */
        while(i < j) {
            //Area calculation:
            //x = (j - i)
            //y = min(data[i], data[j])
            if((j - i) * Math.min(data[i], data[j]) > max) {
                max = (j - i) * Math.min(data[i], data[j]);
            }
            if(data[i] > data[j]) {
                j--;
            } else {
                i++;
            }
        }
        return max;
    }
}
