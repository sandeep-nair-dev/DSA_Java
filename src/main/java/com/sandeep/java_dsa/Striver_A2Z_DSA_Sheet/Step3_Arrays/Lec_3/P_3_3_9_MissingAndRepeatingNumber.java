package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step3_Arrays.Lec_3;

import java.util.ArrayList;
import java.util.List;

public class P_3_3_9_MissingAndRepeatingNumber {

    /*
        Brute Force method is calculation frequency for each element by looping through and checing freq 0 and 2
        TC -> O(N^2)
        SC -> O(1)
     */

    /*
        Better solutionOptimal:
        TC -> O(N)+O(N)
        SC -> O(N)
     */
    private static List<Integer> betterSolution(int[] arr) {
        int[] freq = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i] - 1]++;
        }
        int repeating = -1, missing = -1;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) missing = i + 1;
            if (freq[i] > 1) repeating = i + 1;
            if (repeating != -1 && missing != -1)
                break;
        }
        if (missing == -1) missing = arr.length;
        return List.of(repeating, missing);
    }

    /*
        Optimal Solution 1: Using maths

Step 1: Form equation 1:
Now, we know the summation of the first N numbers is: Sn = (N*(N+1))/2
Let’s say, S = the summation of all the elements in the given array.
Therefore, S - Sn = X - Y…………………equation 1

Step 2: Form equation 2:
Now, we know the summation of squares of the first N numbers is:
S2n = (N*(N+1)*(2N+1))/6
Let’s say, S2 = the summation of squares of all the elements in the given array.
Therefore, S2-S2n = X^2-Y^2...................equation 2
From equation 2 we can conclude,
X^2-Y^2 = S2-S2n
(X+Y)(X-Y) = S2-S2n
X+Y = (S2 - S2n) / (X-Y) [Since X^2-Y^2 = (X+Y)(X-Y)... and From equation 1, we get the value X-Y] ………… equation 3
From equation 1 and equation 3, we can easily find the value of X and Y. And this is what we want.

            TC -> O(N)
            SC -> O(1)
     */

    private static ArrayList<Integer> optimal1UsingMaths(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        long sumOfNNaturalNumbers = ((long) n * (n + 1)) / 2;
        long sumOfSquareOfNNaturalNumbers = (long) (n * (n + 1) * ((2L * n) + 1)) / 6;

        long sumOfArrayElements = 0;
        long sumOfSquaresOfArrayElements = 0;
        for (int i = 0; i < arr.length; i++) {
            sumOfArrayElements += arr[i];
            sumOfSquaresOfArrayElements += (long) arr[i] * (long) arr[i];
        }
        long eq1 = sumOfArrayElements - sumOfNNaturalNumbers;       // sumOfArrayElements-sumOfNNaturalNumbers = x-y where x is repeating number and y is missing number
        long eq2 = (sumOfSquaresOfArrayElements - sumOfSquareOfNNaturalNumbers) / eq1;  // sumOfSquaresOfArrayElements-sumOfSquareOfNNaturalNumbers = x^2-y^2.......(x^2-y^2) = (x+y)(x-y)...and replacing value of x-y from eq1 we get x+y = (sumOfSquaresOfArrayElements-sumOfSquareOfNNaturalNumbers)/(x-y)
        long x = (eq1 + eq2) / 2;
        long y = eq2 - x;
        ans.add((int) x);
        ans.add((int) y);
        return ans;
    }

    /*
        Optimal Solution 1: Using XOR
     */
    private static ArrayList<Integer> optimal2UsingXOR(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        int repeating, missing;
        long n = arr.length;
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor = xor ^ arr[i];
            xor = xor ^ (i + 1);
        }

        int bitNo = 0;
        while ((xor & (1 << bitNo)) == 0) {
            bitNo++;
        }
        int zeroClub = 0, oneClub = 0;
        for (int i = 0; i < n; i++) {
            if ((arr[i] & (1 << bitNo)) != 0) {
                oneClub = oneClub ^ arr[i];
            } else {
                zeroClub = zeroClub ^ arr[i];
            }

            if (((i + 1) & (1 << bitNo)) != 0) {
                oneClub = oneClub ^ (i + 1);
            } else {
                zeroClub = zeroClub ^ (i + 1);
            }
        }

        int countOfZeroClubElement = 0;
        for (int j : arr) {
            if (j == zeroClub) countOfZeroClubElement++;
        }

        if (countOfZeroClubElement > 1) {
            repeating = zeroClub;
            missing = oneClub;
        } else {
            repeating = oneClub;
            missing = zeroClub;
        }

        result.add(repeating);
        result.add(missing);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 6, 2, 4, 6};
        System.out.println("Repeating and missing numbers are: " + betterSolution(arr));
        System.out.println("Repeating and missing numbers are: " + optimal1UsingMaths(arr));
        System.out.println("Repeating and missing numbers are: " + optimal2UsingXOR(arr));
    }
}
