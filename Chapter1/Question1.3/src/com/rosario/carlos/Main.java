package com.rosario.carlos;

public class Main {

    // Questions:
    // 1. What exactly is 'true' length
    // 2. Is it okay to loop through the string multiple times?
    // 3. Can there be more than one space in a row?

    public static void main(String[] args) {
        String s = "a smelly pizza is better than smelly brocolli              "; // tl = 45
        int trueLength = 45;
        String urlifiedString = urlify(s.toCharArray(), trueLength);
        System.out.println(urlifiedString);
    }

    public static String urlify(char[] chars, int trueLength){
        int numSpaces = 0, spacesEncountered = 0;

        // First pass to get the number of spaces
        for(int i = 0; i < trueLength; i++){
            if(chars[i] == ' ') numSpaces++;
        }

        // Run through string backwards, move characters down and replace spaces with %20
        for(int i = trueLength-1; i >= 0; i--){
            char ch = chars[i];
            int stepSize = (numSpaces*2) - (spacesEncountered*2);

            chars[i+stepSize] = ch;
            if(ch == ' '){
                spacesEncountered++;
                chars[i+stepSize] = '0';
                chars[i+stepSize-1] = '2';
                chars[i+stepSize-2] = '%';
            }
        }

        return String.valueOf(chars);
    }
}
