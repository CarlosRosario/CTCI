package com.rosario.carlos;

import java.util.*;

public class Main {

    // Questions to ask for this question:
    // 1. Can we assume that a 'Z' is the same as a 'z' ?
    // 2. ASCII vs Unicode ?
    // 3. Any limit on length of string?


    public static void main(String[] args) {
        String testString1 = "pizza";
        System.out.println(hasAllUniqueCharactersV5(testString1));
    }

    // Run time: O(n)
    // Space:    O(n) or O(1)..?
    public static boolean hasAllUniqueCharactersV1(String s){
        Map<Character, Integer> characterCountMap = new HashMap<>();

        for(char ch: s.toCharArray()){
            updateCharacterCountMap(ch, characterCountMap);
        }

        return determineCharacterUniqueness(characterCountMap);
    }

    public static void updateCharacterCountMap(char ch, Map<Character, Integer> map){
        if(!map.containsKey(ch)){
            map.put(ch, 1);
        }
        else {
            map.put(ch, map.get(ch) + 1);
        }
    }

    public static boolean determineCharacterUniqueness(Map<Character, Integer> map){
        boolean hasAllUniqueCharacters = true;

        for(int counts: map.values()){
            if(counts > 1){
                hasAllUniqueCharacters = false;
                break;
            }
        }

        return hasAllUniqueCharacters;
    }

    /*************************************************************************************/

    // Run time: O(n)
    // Space:    O(n) or O(1)..?
    public static boolean hasAllUniqueCharactersV2(String s){

        Set<Character> uniqueCharactersSet = new HashSet<>();
        boolean isAllUniqueCharacters = true;

        for(char ch: s.toCharArray()){
            if(uniqueCharactersSet.contains(ch)){
                isAllUniqueCharacters = false;
                break;
            }
            else {
                uniqueCharactersSet.add(ch);
            }
        }

        return isAllUniqueCharacters;
    }

    /*************************************************************************************/

    // Run time: O(n)
    // Space:    O(1)
    public static boolean hasAllUniqueCharactersV3(String s){
        boolean[] characterExistsArray = new boolean [128];

        for(char ch: s.toCharArray()){
            int val = (int)ch;
            if(characterExistsArray[val] == true){
                return false;
            }
            else{
                characterExistsArray[val] = true;
            }
        }
        return true;
    }

    /*************************************************************************************/

    // Run time: O(n)
    // Space:    O(1)
    public static boolean hasAllUniqueCharactersV4(String s){
        int check = 0;
        for(char ch: s.toCharArray()){
            int val = ch - 'a'; // make sure the difference is less than 32 in order to avoid wrapping when bit shifting

            if((check & (1 << val)) > 0){
                return false;
            }

            check = check | (1 << val);
        }
        return true;
    }

    /*************************************************************************************/

    // Run time: O(n logn) assuming an nlogn sort is used
    // Space:    O(1) but the underlying sorting algorithm may also use some space
    public static boolean hasAllUniqueCharactersV5(String s){
        char[] chars = s.toLowerCase().toCharArray();
        Arrays.sort(chars);

        for(int i = 1; i < chars.length; i++){
            if(chars[i-1] == chars[i]){
                return false;
            }
        }
        return true;
    }
}
