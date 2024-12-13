package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step1_LearnTheBasics.Lec_5;

public class P_1_5_8_CheckPalindrome {

    public static boolean checkPalindrome(String s, int start, int end){
        if(start>=end) return true;
        if(!Character.isLetterOrDigit(s.charAt(start))) return checkPalindrome(s, start+1, end);
        if(!Character.isLetterOrDigit(s.charAt(end))) return checkPalindrome(s, start, end-1);
        if(Character.toLowerCase(s.charAt(start))!=Character.toLowerCase(s.charAt(end))){
            return false;
        }
        return checkPalindrome(s, start+1, end-1);
    }

    public static boolean isPalindrome(String s) {
        s=s.trim();
        return checkPalindrome(s, 0, s.length()-1);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
