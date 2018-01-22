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
    public static boolean areStringsPermutationsV1(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }

        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);

        System.out.println("First String sorted: " + Arrays.toString(s1Array));
        System.out.println("Second String sorted: " + Arrays.toString(s2Array));

        if(Arrays.toString(s1Array).equals(Arrays.toString(s2Array))){
            return true;
        }

        return false;
    }

    // Run time complexity: O(n) where n is length of strings
    // Space complexity: O(n)
    public static boolean areStringsPermutationsV2(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();

        for(char ch: s1.toCharArray()){
            if (!s1Map.containsKey(ch)) {
                s1Map.put(ch,0);
            }
            else {
                s1Map.put(ch, s1Map.get(ch) + 1);
            }
        }

        for(char ch: s2.toCharArray()){
            if (!s2Map.containsKey(ch)) {
                s2Map.put(ch,0);
            }
            else {
                s2Map.put(ch, s2Map.get(ch) + 1);
            }
        }

        for(char ch: s1Map.keySet()){
            if(!s2Map.containsKey(ch) || s2Map.get(ch) != s1Map.get(ch)){
                return false;
            }
        }

        return true;
    }
}
