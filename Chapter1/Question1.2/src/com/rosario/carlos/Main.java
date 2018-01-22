package com.rosario.carlos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String testString1 = "Bell";
        String testString2 = "lelB";

        System.out.println(areStringsPermutationsV2(testString1, testString2));
    }


    // Run time complexity: O(nlgn)
    // Space complexity: O(1) or whatever the underlying sorting algorithm uses
    public static String sort(String s){
        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);
        return Arrays.toString(sArray);
    }

    public static boolean areStringsPermutationsV1(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }

        return sort(s1).equals(sort(s2));
    }

    /********************************************************************************************************/

    // Run time complexity: O(n) where n is length of strings
    // Space complexity: O(n)

    public static void createCharacterCountMap(Map<Character, Integer> map, String s){
        for(char ch: s.toCharArray()){
            if (!map.containsKey(ch)) {
                map.put(ch,1);
            }
            else {
                map.put(ch, map.get(ch) + 1);
            }
        }
    }

    public static boolean areStringsPermutationsV2(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        Map<Character, Integer> s1Map = new HashMap<>();
        createCharacterCountMap(s1Map, s1);
        
        for(char ch: s2.toCharArray()){
            int charCount = s1Map.get(ch) - 1;
            if(charCount < 0){
                return false;
            }
            s1Map.put(ch, charCount );
        }

        return true;
    }
}
