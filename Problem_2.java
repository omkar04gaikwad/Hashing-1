/*
 * Time Complexity - if n = length of s and t we have to visit each character in s and t - O(n)
 * Space Complexity - I have created 2 Hashmap but since we are mapping each alphabet to another alphabet
 * so the maximum size of the hashmap will be of 26 because only lowercase alphabets are in the input, Hence - O(1)
 * Approach - create two hashmaps where each character of s maps to each character of t and vice-versa,
 * each character will map only to one character, I have two pointers s_length, and t_length increase each pointer.
 * when s_to_t[s_char] = t_char vice-versa, return true if s_length == len(s) and t_length == len(t)
 * 
 * This code worked successfully on Leetcode.
 */

import java.util.HashMap;
import java.util.Map;

public class Problem_2 {
    static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s_to_t = new HashMap<>();
        Map<Character, Character> t_to_s = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            s_to_t.put(s.charAt(i), t.charAt(i));
            t_to_s.put(t.charAt(i), s.charAt(i));
        }
        int len_s = 0;
        int len_t = 0;
        for (int i = 0; i < s.length(); i++) {
            Character s_char = s.charAt(i);
            Character t_char = t.charAt(i);
            if ((s_char != null) && (s_to_t.get(s_char) == t_char)) {
                len_s += 1;
            }
            if ((t_char != null) && (t_to_s.get(t_char) == s_char)) {
                len_t += 1;
            }
        }
        return ((len_s == s.length()) && (len_t == t.length()));
    }

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        System.out.println(isIsomorphic(s, t));
        String s_1 = "foo";
        String t_1 = "bar";
        System.out.println(isIsomorphic(s_1, t_1));
    }

}
