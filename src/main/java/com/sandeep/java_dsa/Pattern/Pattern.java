package com.sandeep.java_dsa.Pattern;

public class Pattern {
    public static void main(String[] args) {
        int n=5;
//        System.out.println("--------com.sandeep.java_dsa.Pattern 1---------");
//        Pattern1(n);
//        System.out.println("--------com.sandeep.java_dsa.Pattern 2---------");
//        Pattern2(n);
//        System.out.println("--------com.sandeep.java_dsa.Pattern 3---------");
//        Pattern3(n);
//        System.out.println("--------com.sandeep.java_dsa.Pattern 4---------");
//        Pattern4(n);
        System.out.println("--------com.sandeep.java_dsa.Pattern 5---------");
        Pattern5(n);
        System.out.println("--------com.sandeep.java_dsa.Pattern 6---------");
        Pattern6(n);
//        System.out.println("--------com.sandeep.java_dsa.Pattern 7---------");
//        Pattern7(n);
//        System.out.println("--------com.sandeep.java_dsa.Pattern 8---------");
//        Pattern8(n);
//        System.out.println("--------com.sandeep.java_dsa.Pattern 9---------");
//        Pattern9(n);
//        System.out.println("--------com.sandeep.java_dsa.Pattern 10---------");
//        Pattern10(n);
//        System.out.println("--------com.sandeep.java_dsa.Pattern 11---------");
//        Pattern11(n);
//        System.out.println("--------com.sandeep.java_dsa.Pattern 12---------");
//        Pattern12(n);
//        System.out.println("--------com.sandeep.java_dsa.Pattern 13---------");
//        Pattern13(n);
//        System.out.println("--------com.sandeep.java_dsa.Pattern 14---------");
//        Pattern14(n);
//        System.out.println("--------com.sandeep.java_dsa.Pattern 15---------");
//        Pattern15(n);
//        System.out.println("--------com.sandeep.java_dsa.Pattern 16---------");
//        Pattern16(n);
//        System.out.println("--------com.sandeep.java_dsa.Pattern 17---------");
//        Pattern17(n);
//        System.out.println("--------com.sandeep.java_dsa.Pattern 18---------");
//        Pattern18(n);
//        System.out.println("--------com.sandeep.java_dsa.Pattern 19---------");
//        Pattern19(n);
//        System.out.println("--------com.sandeep.java_dsa.Pattern 20---------");
//        Pattern20(n);
//        System.out.println("--------com.sandeep.java_dsa.Pattern 21---------");
//        Pattern21(n);
//        System.out.println("--------com.sandeep.java_dsa.Pattern 22---------");
//        Pattern22(n);
    }

//    private static void com.sandeep.java_dsa.Pattern(int n){}

    private static void Pattern5(int n) {
        for(int i=1;i<=n;i++){
            for(int j=1;j<=(n-i+1);j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    private static void Pattern6(int n) {
        for(int i=1;i<=n;i++){
            for(int j=1;j<=(n-i+1);j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
