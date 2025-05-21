/*
 * Time Complexity - if n = length of s and t we have to visit each character in s and t - O(n)
 * Space Complexity - I have created 2 Hashmap but since we are mapping each string to a pattern character Hence - O(n)
 * Approach - create two hashmaps where each word of s maps to each character of pattern and vice-versa,
 * I have created two arrays res_1 and res_2 which are generated using the hashmap, when res_1 == pattern and res_2 == s
 *  return true else false.
 * 
 * This code worked successfully on Leetcode.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem_3 {

    static boolean wordPattern(String pattern, String s) {
        String[] s_list = s.split("\\s+");
        if (s_list.length != pattern.length()) {
            return false;
        }
        Map<String, Character> s_to_p = new HashMap<>();
        Map<Character, String> p_to_s = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            s_to_p.put(s_list[i], pattern.charAt(i));
            p_to_s.put(pattern.charAt(i), s_list[i]);
        }
        StringBuilder res_1 = new StringBuilder();
        StringBuilder res_2 = new StringBuilder();
        for (int j = 0; j < pattern.length(); j++) {
            res_1.append(p_to_s.get(pattern.charAt(j)));
        }
        for (int k = 0; k < s_list.length; k++) {
            res_2.append(s_to_p.get(s_list[k]));
        }
        String joined = String.join("", s_list);
        return ((res_1.toString().equals(joined)) && (res_2.toString().equals(pattern)));
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        String pattern1 = "abba";
        String s1 = "dog cat cat fish";
        System.out.println(wordPattern(pattern, s));
        System.out.println(wordPattern(pattern1, s1));
    }

}
