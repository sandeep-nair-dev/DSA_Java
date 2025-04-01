package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step7_Recursion.Lec_1;

public class P_7_1_2_PowXN {

    static long MOD = (long) (Math.pow(10, 9) + 7);

    /**
     * T.C. -> log(n) base 2
     * S.C -> O(1)
     */
    public static double myPow(double x, int n) {
        double ans = 1.0;
        long nn = n;
        if (nn < 0) nn = -1 * nn;
        while (nn > 0) {
            if (nn % 2 == 0) {
                x = x * x;
                nn = nn / 2;
            } else {
                ans = ans * x;
                nn = nn - 1;
            }
        }
        if (n < 0) ans = (double) 1.0 / (double) ans;
        return ans;
    }

    public static double rec(double x, long nn, double ans) {            //to check, not giving proper ans
        if (nn == 0) return ans;
        if (nn % 2 == 0) {
            x = x * x;
            nn = nn / 2;
            rec(x, nn, ans);
        } else {
            nn = nn - 1;
            ans = ans * x;
            rec(x, nn, ans);
        }
        return ans;
    }

    private long myPow(long x, long n) {            //recursive
        if (n == 0) return 1;

        long temp = myPow(x, n / 2);
        if (n % 2 == 0) return (temp * temp) % MOD;
        else return (x * temp * temp) % MOD;
    }

    public static void main(String[] args) {
        System.out.println(myPow(0.00001, 2147483647));
//        System.out.println(rec(2,10, 1.0));
    }
}
