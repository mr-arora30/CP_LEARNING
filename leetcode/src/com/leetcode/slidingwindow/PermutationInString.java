package com.leetcode.slidingwindow;

import java.util.*;
class PermutationInString{
/*
Given a string and a pattern, find out if the string contains any permutation of the pattern.

Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations:

abc
acb
bac
bca
cab
cba
If a string has ‘n’ distinct characters, it will have n!n! permutations.

Example 1:

Input: String="oidbcaf", Pattern="abc"
Output: true
Explanation: The string contains "bca" which is a permutation of the given pattern.
Example 2:

Input: String="odicf", Pattern="dc"
Output: false
Explanation: No permutation of the pattern is present in the given string as a substring.
Example 3:

Input: String="bcdxabcdy", Pattern="bcdyabcdx"
Output: true
Explanation: Both the string and the pattern are a permutation of each other.
Example 4:

Input: String="aaacb", Pattern="abc"
Output: true
Explanation: The string contains "acb" which is a permutation of the given pattern.
*/
  public static void main(String args[]){
    System.out.println(findPermutation("bcdxabcdy","bcdyabcdx"));
  }
  /*
  In the question basically window size is given and we just 
  have to find if all the pattern characters exist in this window or not.
  */
/*Approach 1 : using ascii values of characters, add ascii value of each character
  of pattern and check if sum of all the ascii value of characters in the window,
  if equal then pattern is present.
  Complexity is O(Pattern) + O(N)
*/
  public static boolean findPermutation(String str, String pattern) {
   
  int windowStart=0;
        int windowSize=pattern.length(); 
        long sum=0;
        long patSum=0;
        for(int i=0;i<windowSize;i++){
            patSum+= (long) pattern.charAt(i);
        }
        for(int windowEnd=0;windowEnd<str.length();windowEnd++){

            int right = (int) str.charAt(windowEnd);
            sum+=right;
            if(windowEnd-windowStart+1==windowSize ){
                if(sum==patSum){
                    return  true;
                }
                int left =(int) str.charAt(windowStart);
                sum-=left;
                windowStart++;

            }

        }
        return false;
  }
  /*
  Approach 2: use a Hashmap to remember the frequenuencies of each character of the pattern (add each character of the pattern to the hashmap )
  and deduct the frequency if it matches a character in target string if it equals to zero then maintain a variable to check if match==window size to return true, then shrink the window to match the pattern's size
  complexity - O(Pattern)+O(N)
  */

  public static boolean findPermutation2(String str, String pattern) {
    int windowStart = 0, matched = 0;
    Map<Character, Integer> charFrequencyMap = new HashMap<>();
    for (char chr : pattern.toCharArray())
      charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

    // our goal is to match all the characters from the 'charFrequencyMap' with the current window
    // try to extend the range [windowStart, windowEnd]
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      if (charFrequencyMap.containsKey(rightChar)) {
        // decrement the frequency of the matched character
        charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
        if (charFrequencyMap.get(rightChar) == 0) // character is completely matched
          matched++;
      }

      if (matched == charFrequencyMap.size())
        return true;

      if (windowEnd >= pattern.length() - 1) { // shrink the window by one character
        char leftChar = str.charAt(windowStart++);
        if (charFrequencyMap.containsKey(leftChar)) {
          if (charFrequencyMap.get(leftChar) == 0)
            matched--; // before putting the character back, decrement the matched count
          // put the character back for matching
          charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
        }
      }
    }

    return false;
  }
}