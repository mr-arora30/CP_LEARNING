package com.leetcode.slidingwindow;

import java.util.*;
/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/


 */
public class LongestSubStringWithoutRepChars {

    public static void  main(String args[]){
        System.out.println(new LongestSubStringWithoutRepChars().lengthOfLongestSubstring("abcabcbb"));
    }
    public int lengthOfLongestSubstring(String s) {
        int windowStart = 0;
        int maxLen = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {

            char rightChar = s.charAt(windowEnd);

            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

//            we are only accessing element once in below while loop
            while (map.get(rightChar) > 1) {

                char leftChar = s.charAt(windowStart);

                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(rightChar) == 0)
                    map.remove(rightChar);
                windowStart++;


            }

            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);


        }
        return maxLen;
    }
}
