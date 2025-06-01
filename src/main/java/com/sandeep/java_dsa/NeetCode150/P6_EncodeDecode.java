package com.sandeep.java_dsa.NeetCode150;

import java.util.ArrayList;
import java.util.List;

public class P6_EncodeDecode {

    public static String encode(List<String> list){
        StringBuilder str = new StringBuilder();
        for (String s : list) {
            str.append(s.length()).append('#').append(s);
        }
        return str.toString();
    }

    public static List<String> decode(String s){
        int i=0;
        List<String> decodedResult = new ArrayList<>();
        while (i<s.length()){
            int j=i;
            while (s.charAt(j)!='#'){
                j++;
            }
            int length = Integer.parseInt(s.substring(i, j));
            i=j+1;
            j=i+length;
            decodedResult.add(s.substring(i,j));
            i=j;
        }
        return decodedResult;
    }

    public static void main(String[] args) {
        List <String> toEncode = List.of("we","say",":","yes","!@#$%^&*()");
        String encodedString = encode(toEncode);
        System.out.println("Encoded string: " + encodedString);
        List<String> decode = decode(encodedString);
        System.out.println("Decoded Result: " + decode);
    }
}
