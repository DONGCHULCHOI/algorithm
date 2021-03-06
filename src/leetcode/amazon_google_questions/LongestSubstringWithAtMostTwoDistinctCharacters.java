package leetcode.amazon_google_questions;

import java.util.Collections;
import java.util.HashMap;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
    // Consider differnt my opinion: W/ 904. Fruit Into Baskets also
    //  Recognize this is map which is key and value
    //  Expand a window till invalid
    //  When invalid, then contract the window till valid
    //  Do not move back the pointers
    //  Clean the 904. Fruit Into Baskets also
    // T.C: O(n) where n is the length of string s
    // S.C: O(m) where m is the size of the charset
    // the valid window is when the window includes 3 different char type
    // Valid is counter = 3
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] map = new int[128];
        int counter = 0, start = 0, end = 0, maxLen = 0;

        while (end < s.length()) { // Find a valid window
            if (map[s.charAt(end)] == 0) counter++;
            map[s.charAt(end)]++;
            end++;

            while (counter > 2) { // Contract till the window becomes invalid
                if (map[s.charAt(start)] == 1)  counter--;
                map[s.charAt(start)]--;
                start++;
            }
            maxLen = Math.max(maxLen, end - start); // ***** // because find maximum substring
        }
        return maxLen;
    }
}
