import java.util.Hashtable;

public class FrequentWords {
    public static void main(String[] args) {
        String s = "north,south,east,west,northwest,northeast,southwest,southeast,north,north,east";
        //String s = "";
        //String s = "north,south,east,west";

        if(s.isBlank()) {
            System.out.println("String is empty");
            System.exit(0);
        }

        String[] words;
        words = s.split(",");
        Hashtable<String, Integer> h = new Hashtable<>();

        //Fill hash table
        for(String word : words) {
            word = word.toLowerCase();
            if(h.containsKey(word)) {
                h.replace(word, h.get(word) + 1);
            } else {
                h.put(word, 1);
            }
        }

        //Get max value and key
        int max = 0;
        String max_key = "";
        for(String k : h.keySet()) {
            if(h.get(k) > max) {
                max = h.get(k);
                max_key = k;
            }
        }

        System.out.printf("Most frequent word: %s repeated %d time(s)\n", max_key, h.get(max_key));
    }
    
}
