package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step7_Recursion.Lec_1;

public class P_7_1_1_Recursiveatoi {
    public static int recursiveAtoI(String s, int i, int num, boolean isPositive) {
        if (i >= s.length()) {
            return num;
        }
        if (!Character.isDigit(s.charAt(i))) {
            if (i != 0) return num;
            else {
                if (s.charAt(i) == '-') isPositive = false;
                else if (s.charAt(i) != '+') return num;
            }
        } else {
            int parseInt = Integer.parseInt(String.valueOf(s.charAt(i)));
            if (num < 0 || !isPositive) {
                if (num < (Integer.MIN_VALUE + parseInt) / 10) {
                    return Integer.MIN_VALUE;
                }
                num = (num * 10) - parseInt;
            } else {
                if (num > (Integer.MAX_VALUE - parseInt) / 10) {
                    return Integer.MAX_VALUE;
                }
                num = (num * 10) + parseInt;
            }
        }
        return recursiveAtoI(s, i + 1, num, isPositive);
    }

//    public static int Iterativeatoi(String s){
//        s=s.trim();
//        for(int i=0;i<s.length();i++){
//
//        }
//    }

    public static void main(String[] args) {
        String s = ".1.";
        System.out.println(recursiveAtoI(s.trim(), 0, 0, true));
        double a = 0.00001;
        double b = 0.00001;
        System.out.println();
//        System.out.println(Integer.MIN_VALUE);
    }
}
