public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};
        int sum = 0;
        System.out.println(subsetSum(arr, sum));
    }

    /**
     * Checks whether the given number can be achieved as the sum of
     * a subset from the given array.
     *
     * @param arr the array containing the values we can use
     * @param sum the number to check if it can be achieved using a subset of arr
     * @return true if sum can be achieved using the values in the array
     */
    public static boolean subsetSum(int[] arr, int sum) {
        //rows = number of elements
        //columns = 0...sum + 1 to include 0
        boolean[][] truthTable = new boolean[arr.length][sum + 1];

        //Empty or invalid array
        if(arr.length == 0 || arr == null) {
            return false;
        }

        //If sum is 0 then it's always true
        //because 0 doesn't require a sum between elements
        if(sum == 0) {
            return true;
        }

        /**
         * First column of matrix is true because
         * we can exclude any number to get a sum of 0.
         */
        for(int i = 0; i < arr.length; i++) {
            truthTable[i][0] = true;
        }

        /**
         * Fill out truth table using dynamic programming
         * to determine if the cell in the 2D array is true
         * by using previous or known/given information.
         */
        for(int i = 1; i < arr.length; i++)
            for (int j = 0; j <= sum; j++)

                //arr[i] will always be an achievable sum
                if (j == arr[i]) {
                    truthTable[i][j] = true;

                //In the first row only the 0th element in the truth table
                //and element where i = arr[i] will be true
                } else if (i == 0 && j != arr[i]) {
                    truthTable[0][j] = false;

                /**
                 * Check if excluding current element can equal i (table[i - 1][j])
                 * Check if the difference between j and current element from given array
                 * is true in the previous row (j - arr[i]).
                 *
                 * Essentially checks if the difference between j and current array element
                 * was previously possible. This is because if the difference is possible then
                 * the sum of the current array element and the difference will be equal to j.
                 *
                 * It also checks if the j was proven to be possible in the previous row.
                 */
                } else {
                    if (truthTable[i - 1][j] || truthTable[i - 1][Math.abs(j - arr[i])])
                        truthTable[i][j] = true;
                    else
                        truthTable[i][j] = false;
                }
        /**
         * If sum is achievable then the (i,j)
         * which is the sum we're searching for
         * is true.
         */
        return truthTable[arr.length - 1][sum];
    }
}
