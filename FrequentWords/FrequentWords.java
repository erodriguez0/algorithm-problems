import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.HashSet;
import java.util.Collections;

public class FrequentWords {
    public static void main(String[] args) {
        String s = "north,south,east,west,northwest,northeast,southwest,southeast,north,north,east";
        String[] banned = {"north"};
        //String s = "";
        //String s = "north,south,east,west";

        System.out.printf("Most frequent word: %s\n", mostFrequentWord(s, banned));
    }

    /**
     *
     * @param s the string with
     * @return the most frequent word in the string
     */
    public static String mostFrequentWord(String s, String[] banned) {
        if(s.isBlank()) {
            return "Empty string";
        }

        //Replace all non-alphanumeric (+ space) characters with whitespace,
        //convert to lowercase, and split words into array
        String[] words = s.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase().split("\\s+");

        if(words.length <= 2) {
            return words[0];
        }

        Hashtable<String, Integer> h = new Hashtable<>();
        //Convert banned words from array to set and words to lowercase
        HashSet<String> ban = new HashSet<>();
        Arrays.stream(banned).forEach(bannedWord -> ban.add(bannedWord.toLowerCase()));

        //Fill hash table
        for(String word : words) {
            if(!ban.contains(word)) {
                h.put(word, h.getOrDefault(word, 0) + 1);
            }
        }

        return Collections.max(h.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
    
}
