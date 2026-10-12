package com.sandeep.java_dsa.NeetCode150;

import java.util.*;

public class P20_Sliding_Window_Maximum {

    /*
    TC -> O(n * logn)
    SC -> O(n)
     */
    public int[] maxSlidingWindow_MaxHeap(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        int l = 0;
        res[0] = pq.peek();
        int index = 1;

        for (int r = k; r < nums.length; r++) {
            pq.remove(nums[l]);
            pq.add(nums[r]);
            res[index] = pq.peek();
            l++;
            index++;
        }
        return res;
    }

    /*
        Monotonically Decreasing Queue
        Elements stored in non-increasing order

        Note: We are storing the index of element in the deque and not the element itself.

        TC -> O(n)
        SC -> O(n)
     */
    public int[] maxSlidingWindow_Deque(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int l = 0, r = 0;
        int[] result = new int[nums.length - k + 1];

        while (r < nums.length) {

            // For an element, before inserting it in last, remove all the elements that are smaller than this from last. This is done because since if the current element is greater than the previous elements, then there's no chance the previous elements would become maximum as the window moves forward.
            //Eg:  if in window of index 1-3 nums[3] is largest. Then in window 2-4, either nums[3] or nums[4] would be the largest. Since nums[3] was largest in 1-3...1,2 dont have amy chance being the largest till nums[3] is there.
            while (!deque.isEmpty() && nums[r] > nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(r);

            // case where element is the largest but after the window is moved, the largest number is no longer part of the window. In which case, we would have to remove the element from the deque.
            if (l > deque.getFirst()) {
                deque.removeFirst();
            }
            if (r + 1 >= k) {
                result[l] = nums[deque.getFirst()];
                l++;
            }
            r++;
        }
        return result;
    }


    public static void main(String[] args) {
        P20_Sliding_Window_Maximum solution = new P20_Sliding_Window_Maximum();

        System.out.println(Arrays.toString(solution.maxSlidingWindow_Deque(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
