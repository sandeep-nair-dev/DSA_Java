package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step5_Strings.Lec_2;

public class P_5_2_4_ImplementAtoI_Iterative {

    public static int myAtoiIterative(String s) {
        int INT_MAX = 2147483647, INT_MIN = -2147483648;
        int result = 0, sign = 1;

        int i = 0;
        String str = s.trim();
        if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            int num = str.charAt(i) - '0';
            if (result > (INT_MAX - num) / 10) {
                return sign == 1 ? INT_MAX : INT_MIN;
            }
            result = result * 10 + num;
            i++;
        }
        return sign * result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoiIterative("42"));
        System.out.println(myAtoiIterative(" -042"));
        System.out.println(myAtoiIterative("1337c0d3"));
        System.out.println(myAtoiIterative("0-1"));
        System.out.println(myAtoiIterative("words and 987"));
    }
}