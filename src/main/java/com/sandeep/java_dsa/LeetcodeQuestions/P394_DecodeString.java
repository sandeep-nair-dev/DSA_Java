package com.sandeep.java_dsa.LeetcodeQuestions;

import java.util.Stack;

/**
 * <h3><b>Problem Statement</b></h3>
 * <p>Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.<br>
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].<br>
 * The test cases are generated so that the length of the output will never exceed 105.<br><br>
 * Example 1:<br>
 * Input: s = "3[a]2[bc]"<br>
 * Output: "aaabcbc"
 * <br><br>
 * Example 2:<br>
 * Input: s = "3[a2[c]]"<br>
 * Output: "accaccacc"
 * <br><br>
 * Example 3:<br>
 * Input: s = "2[abc]3[cd]ef"<br>
 * Output: "abcabccdcdcdef"</p>
 */
public class P394_DecodeString {

    /**
     * <b>Approach</b>
     * <p>
     *     Have 2 stack, one for storing numbers and one for storing intermediate results. Now traverse through the string
     * <ul>
     *     <li>if character <b>is digit</b>, use that to create n that will be later added to count stack</li>
     *     <li>if character <b>'is ['</b>:
     *     <ul>
     *         <li>push n to count stack and reset n to 0</li>
     *         <li>push res to result stack and reset res</li>
     *     </ul>
     *     </li>
     *     <li>if character <b>'is ]'</b>:
     *     <ul>
     *         <li>get the top number(topcount) from count stack</li>
     *         <li>get the top StringBuilder from result stack(topString)</li>
     *         <li>repeat current "res" topCount number of times and append it to topString</li>
     *         <li>set "res" to the final string we got above</li>
     *     </ul>
     *     </li>
     *     <li>if character <b>is letter</b>: append it to "res"</li>
     * </ul>
     *
     * Our final result will be in "res"
     * </p>
     */
    private static String decodeString(String s){
        Stack<Integer> count = new Stack<>();
        Stack<StringBuilder> result = new Stack<>();
        StringBuilder res = new StringBuilder();
        int n=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                n=n*10 + (c -'0');
            }else if(c =='['){
                count.add(n);
                n=0;
                result.add(res);
                res = new StringBuilder();
            }else if(c ==']'){
                int repeat = count.pop();
                StringBuilder temp = result.pop();
                temp.append(res.toString().repeat(repeat));
                res=temp;
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s1 = "3[a]2[bc]";
        String s2 = "3[a2[c]]";
        String s3 = "2[abc]3[cd]ef";
        System.out.println("s1: " + decodeString(s1));
        System.out.println("s2: " + decodeString(s2));
        System.out.println("s3: " + decodeString(s3));
    }
}
