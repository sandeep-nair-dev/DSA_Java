package com.sandeep.java_dsa.NeetCode150;

public class P10_ValidPalindrome {

    public static boolean checkValidPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++;
            j--;
        }
        return true;
    }

    public static boolean checkValidPalindromeRecursion(String s, int i, int j) {
        if (i >= j) return true;
        if (!Character.isLetterOrDigit(s.charAt(i))) return checkValidPalindromeRecursion(s, i + 1, j);
        if (!Character.isLetterOrDigit(s.charAt(j))) return checkValidPalindromeRecursion(s, i, j - 1);
        if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
        return checkValidPalindromeRecursion(s, i+1, j-1);
    }

    public static void main(String[] args) {
        String s = "Was it a car or a cat I saw?";
        System.out.println(checkValidPalindrome(s));
        System.out.println(checkValidPalindromeRecursion(s, 0, s.length()-1));
    }
}
