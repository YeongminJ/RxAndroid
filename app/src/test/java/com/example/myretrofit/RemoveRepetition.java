package com.example.myretrofit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class RemoveRepetition {
    public static String transform(String input) {
        char[] chars = input.toCharArray();
        Set<Character> charSet = new LinkedHashSet<Character>();
        for (char c : chars) {
            charSet.add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : charSet) {
            sb.append(character);
        }
        return sb.toString();
//        char repeatChar = 0;
//        for (int i = 0; i < input.length(); i++) {
//            if (repeatChar == 0) {
//                //insert New
//                repeatChar = input.charAt(i);
//                res += input.charAt(i);
//            }
//            else {
//                //Compare
//                if (input.charAt(i) == repeatChar) {
//                    //skip
//                }
//                else {
//                    repeatChar = input.charAt(i);
//                    res += input.charAt(i);
//                }
//            }
//        }
//        char[] chars = input.toCharArray();


//        return res;
    }

    public static void main(String[] args) {
        System.out.println(RemoveRepetition.transform("abbcbbb"));
    }
}
