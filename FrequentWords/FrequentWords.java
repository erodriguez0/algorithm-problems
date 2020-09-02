import java.util.Map;
import java.util.Collections;
import java.util.Hashtable;

public class FrequentWords {
    public static void main(String[] args) {
        String s = "north,south,east,west,northwest,northeast,southwest,southeast,north,north,east";
        //String s = "";
        //String s = "north,south,east,west";

        System.out.printf("Most frequent word: %s\n", mostFrequentWord(s));
    }

    /**
     *
     * @param s the string with
     * @return the most frequent word in the string
     */
    public static String mostFrequentWord(String s) {
        if(s.isBlank()) {
            return "Empty string";
        }

        //Replace all non-alphanumeric (+ space) characters with whitespace,
        //convert to lowercase, and split words into array
        String[] words = s.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase().split(" ");

        if(words.length <= 2) {
            return words[0];
        }

        Hashtable<String, Integer> h = new Hashtable<>();

        //Fill hash table
        for(String word : words) {
            h.put(word, h.getOrDefault(word, 0) + 1);
        }

        return Collections.max(h.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
    
}
