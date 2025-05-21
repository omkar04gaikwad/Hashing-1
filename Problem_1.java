/*
 * Time Complexity - if n = length of the array and k = length of a word then Time Complexity: O(n*k)
 * Space Complexity - Hashmap of a size n then Space Complexity: O(n)
 * Approach - for each word I created a index array of 26 length and based on ASCII values,
 * I added the count for each character, so if two words are anagrams means they have this array equal.
 * I used this array as key and value is an array of words where same key words are put together.
 * 
 * This code worked successfully on Leetcode.
 */

// Group Anagrams
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.ArrayList;

public class Problem_1 {

    static Map<String, List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashmap = new HashMap<>();
        for (String word : strs) {
            int[] ch_array = new int[26];
            for (char ch : word.toCharArray()) {
                ch_array[ch - 'a'] += 1;
            }
            String hashkey = Arrays.toString(ch_array);
            if (hashmap.containsKey(hashkey)) {
                hashmap.get(hashkey).add(word);
            } else {
                hashmap.put(hashkey, new ArrayList<>(Arrays.asList(word)));
            }
        }
        return hashmap;
    }

    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        Map<String, List<String>> res = groupAnagrams(strs);
        List<List<String>> result = new ArrayList<>();
        for (List<String> wordlist : res.values()) {
            result.add(wordlist);
        }
        System.out.println(result.toString());
    }
}
