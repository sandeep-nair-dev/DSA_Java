package com.sandeep.java_dsa.NeetCode150;

public class P2_ValidAnagram {

    static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] l1 = new char[26];
        char[] l2 = new char[26];

        for (int i = 0; i < s.length(); i++) {
            l1[s.charAt(i) - 'a']++;
            l2[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (l1[i] != l2[i]) return false;
        }

        return true;
    }

    //used single array for hashtable -> s increases and t decreases so overall if anagram, then all val should be 0
    static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] count = new char[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int val:count){
            if(val!=0) return false;
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(isAnagram2("anagram", "nagaram"));
    }
}
