package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step7_Recursion.Lec_1;

public class P_7_1_3_CountGoodNumbers {

    static long MOD = (long) (Math.pow(10, 9) + 7);

    public static int countGoodNumbers(long n) {
        if (n == 1) return 5;
        long evenCount = n / 2, oddCount = n / 2;
        if (n % 2 == 1) evenCount += 1;

        long evenPower = myPow(5, evenCount);
        long oddPower = myPow(4, oddCount);
        long ans = ((evenPower % MOD) * (oddPower % MOD)) % MOD;
        return (int) ans;
//        return (int) ((evenPower * oddPower) % MOD);
    }

    private static long myPow(long x, long count) {
        long ans = 1;
        long nn = count;
        while (nn > 0) {
            if (nn % 2 == 0) {
                x = (x * x) % MOD;
                nn = nn / 2;
            } else {
                ans = (ans * x) % MOD;
                nn -= 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

//        System.out.println(countGoodNumbers(1));
//        System.out.println(countGoodNumbers(4));
        System.out.println(countGoodNumbers(1924));
    }
}
