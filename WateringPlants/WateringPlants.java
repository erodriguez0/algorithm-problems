public class WateringPlants {
    public static void main(String[] args) {
        //Google | OA 2019 | Watering Flowers 2.0
        int[] plants = {2, 4, 5, 1, 2}; // returns 3
//        int[] plants = {5, 5, 5, 5, 5, 7, 7, 7, 7, 7}; // returns 10
//        int[] plants = {5, 5, 5, 5, 5, 7, 7, 7, 7, 7, 7}; // returns 11
//        int[] plants = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}; // returns 3
        int capacity1 = 5, capacity2 = 7;
        System.out.printf("Refills: %d\n", numOfRefills(plants, capacity1, capacity2));
    }

    /**
     * Calculate how many refills it will take to water all plants
     * between you and your friend. If the bucket has less water than required
     * then it will be refilled. The last plant, if the number of plants is odd,
     * can be watered by the sum of both buckets if greater than or equal to its
     * required water.
     *
     * @param plants array with water requirements per plant
     * @param capacity1 your bucket's capacity
     * @param capacity2 your friend's bucket capacity
     * @return the numbers of refills it takes to water plants
     */
    public static int numOfRefills(int[] plants, int capacity1, int capacity2) {
        int refills = 0, cap1 = capacity1, cap2 = capacity2;
        int half = (int) Math.ceil(plants.length / 2.0);
        boolean even = (plants.length % 2 == 0) ? true : false;
        if(!even) {
            half--;
        }

        //
        if(plants == null || plants.length == 0) {
            return 0;
        }

        //If only one element and can be watered by single bucket
        if(plants.length == 1 && Math.max(capacity1, capacity2) >= plants[0]) {
            return 1;
        }

        //Minimum refills
        refills = 2;

        for(int i = 0; i < half; i++) {
            //If plant requires more than available water
            //refill else use up water
            if (plants[i] > cap1) {
                refills++;
                cap1 = capacity1 - plants[i];
            } else {
                cap1 -= plants[i];
            }

            if(plants[plants.length - i - 1] > cap2) {
                refills++;
                cap2 = capacity2 - plants[plants.length - i - 1];
            } else {
                cap2 -= plants[plants.length - i - 1];
            }
        }

        //If # of plants is odd check the last plant
        if(!even) {
            //Check if cap1 + cap2 > plants[i]
            if(plants[half] > (cap1 + cap2)) {
                refills++;
            }
        }

        return refills;
    }
}
