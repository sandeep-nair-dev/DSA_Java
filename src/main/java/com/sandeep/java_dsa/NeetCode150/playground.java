package com.sandeep.java_dsa.NeetCode150;

import java.util.*;

public class playground {

    static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] hashtable = new int[26];
            for (int i = 0; i < s.length(); i++) {
                hashtable[s.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(hashtable);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            arr.add(new int[]{entry.getValue(), entry.getKey()});
        }

        arr.sort((a, b) -> b[0] - a[0]);

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[1];
        }
        return res;
    }

    static int[] topKFrequent_MinHeap(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[1];
        }
        return res;
    }

    static int[] topKFrequent_BucketSort(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n : freq[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }

    static String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for (String s : strs) {
            encoded.append(s.length()).append("#").append(s);
        }
        return encoded.toString();
    }

    static List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            decoded.add(str.substring(i, j));
            i = j;
        }

        return decoded;
    }

    static int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;
        for (int n : nums) {
            if (n != 0) {
                product *= n;
            } else {
                zeroCount++;
            }
        }
        int[] res = new int[nums.length];
        if (zeroCount > 1) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 0) {
                if (nums[i] == 0) res[i] = product;
                else res[i] = 0;
            } else {
                res[i] = product / nums[i];
            }
        }
        return res;
    }

    static int[] productExceptSelfWithoutDivision(int[] nums) {
        int[] prefixProd = new int[nums.length];
        int[] suffixProd = new int[nums.length];
        int[] res = new int[nums.length];

        prefixProd[0] = 1;
        suffixProd[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefixProd[i] = prefixProd[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            suffixProd[i] = suffixProd[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            res[i] = prefixProd[i] * suffixProd[i];
        }
        return res;
    }

    static int[] productExceptSelfWithoutDivisionOneArray(int[] nums) {
        int[] res = new int[nums.length];

        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int postfix = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }

        return res;
    }

    static boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '.') continue;
                if (set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        for (int i = 0; i < cols; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < rows; j++) {
                if (board[j][i] == '.') continue;
                if (set.contains(board[j][i])) return false;
                set.add(board[j][i]);
            }
        }

        for (int sq = 0; sq < 9; sq++) {
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (sq / 3) * 3 + i;
                    int col = (sq % 3) * 3 + j;
                    if (board[row][col] == '.') continue;
                    if (set.contains(board[row][col])) return false;
                    set.add(board[row][col]);
                }
            }
        }
        return true;
    }

    static boolean sudokuOnePass(char[][] board) {
        HashMap<Integer, HashSet<Character>> row = new HashMap<>();
        HashMap<Integer, HashSet<Character>> col = new HashMap<>();
        HashMap<String, HashSet<Character>> sq = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;
                String squareKey = (i / 3) + "," + (j / 3);
                if (row.computeIfAbsent(i, k -> new HashSet<>()).contains(board[i][j]) ||
                        col.computeIfAbsent(j, k -> new HashSet<>()).contains(board[i][j]) ||
                        sq.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(board[i][j])) {
                    return false;
                }

                row.get(i).add(board[i][j]);
                col.get(j).add(board[i][j]);
                sq.get(squareKey).add(board[i][j]);
            }
        }
        return true;
    }

    static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int longest = 0;
        int current = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                current++;
            } else {
                current = 1;
            }
            longest = Math.max(longest, current);
        }
        return longest;
    }

    static int longestConsecutiveOn(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int longest = 0;

        for (Integer i : set) {
            if (!set.contains(i - 1)) {
                int len = 1;
                int ele = i;
                while (set.contains(ele + 1)) {
                    len++;
                    ele++;
                }
                longest = Math.max(longest, len);
            }
        }

        return longest;
    }

    static boolean isPalindrome(String s) {
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

    static boolean isPalindromeRecursion(String s, int i, int j) {
        if (i >= j) return true;
        if (!Character.isLetterOrDigit(s.charAt(i))) return isPalindromeRecursion(s, i + 1, j);
        if (!Character.isLetterOrDigit(s.charAt(j))) return isPalindromeRecursion(s, i, j - 1);
        if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
            return false;
        }
        return isPalindromeRecursion(s, i + 1, j - 1);
    }

    static int[] twoSum(int[] numbers, int target) {
        int lo = 0, hi = numbers.length - 1;
        while (lo < hi) {
            int sum = numbers[lo] + numbers[hi];
            if (sum == target) {
                return new int[]{lo + 1, hi + 1};
            } else if (sum < target) {
                lo++;
            } else {
                hi--;
            }
        }
        return new int[]{-1, -1};
    }

    static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                } else if (sum < 0) j++;
                else k--;
            }
        }
        return result;
    }

    static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            maxArea = Math.max(maxArea, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) l++;
            else r--;
        }
        return maxArea;
    }

    public int trapRainwater(int[] height) {
        int l = 0, r = height.length - 1;
        int maxL = height[l];
        int maxR = height[r];
        int trapped = 0;
        while (l < r) {
            if (maxL < maxR) {
                l++;
                maxL = Math.max(maxL, height[l]);
                trapped += maxL - height[l];
            } else {
                r--;
                maxR = Math.max(maxR, height[r]);
                trapped += maxR - height[r];
            }
        }
        return trapped;
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minBuy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minBuy = Math.min(minBuy, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minBuy);
        }
        return maxProfit;
    }

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int maxCount = 0;
        for (int r = 0; r < s.length(); r++) {
            if (map.containsKey(s.charAt(r))) {
                maxCount = Math.max(maxCount, r - l);
                l = Math.max(map.get(s.charAt(r)) + 1, l);
            }
            map.put(s.charAt(r), r);
        }
        maxCount = Math.max(maxCount, s.length() - l);
        return maxCount;
    }

    public int characterReplacement(String s, int k) {
        HashSet<Character> charSet = new HashSet<>();
        int longest = 0;
        for (Character c : s.toCharArray()) {
            charSet.add(c);
        }
        for (Character c : charSet) {
            int l = 0;
            int diff = 0;
            for (int r = 0; r < s.length(); r++) {
                if (s.charAt(r) != c) {
                    diff++;
                }
                while (diff > k) {
                    if (s.charAt(l) != c) {
                        diff--;
                    }
                    l++;
                }
                longest = Math.max(longest, r - l + 1);
            }
        }
        return longest;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] f1 = new int[26];
        int[] f2 = new int[26];

        for (Character c : s1.toCharArray()) {
            f1[c - 'a']++;
        }

        for (int i = 0; i < s1.length(); i++) {
            f2[s2.charAt(i) - 'a']++;
        }
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (f1[i] == f2[i]) matches++;
        }


        int l = 0;
        for (int i = s1.length(); i < s2.length(); i++) {
            String curr = s2.substring(l, i);
            if (matches == 26) return true;

            int incIndex = s2.charAt(i) - 'a';
            int decIndex = s2.charAt(l) - 'a';
            l++;

            f2[incIndex]++;
            if (f1[incIndex] == f2[incIndex]) {
                matches++;
            } else if (f1[incIndex] + 1 == f2[incIndex]) {
                matches--;
            }

            f2[decIndex]--;
            if (f1[decIndex] == f2[decIndex]) matches++;
            else if (f1[decIndex] - 1 == f2[decIndex]) matches--;
        }

        return matches == 26;
    }

    static boolean compareHashMap(HashMap<Character, Integer> m1, HashMap<Character, Integer> m2) {
        for (Map.Entry<Character, Integer> e : m1.entrySet()) {
            if (!m2.containsKey(e.getKey()) || m2.get(e.getKey()) < e.getValue()) return false;
        }
        return true;
    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        String minRes = s;
        boolean matches = false;

        for (Character c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0;

        for (; r < t.length(); r++) {
            sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r), 0) + 1);
        }

        while (r < s.length()) {
            if (compareHashMap(tMap, sMap)) {
                matches = true;
                if (r - l < minRes.length()) minRes = s.substring(l, r);
                sMap.put(s.charAt(l), sMap.get(s.charAt(l)) - 1);
                l++;
            } else {
                sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r), 0) + 1);
                r++;
            }
        }

        while (compareHashMap(tMap, sMap)) {
            matches = true;
            String substring = s.substring(l, r);
            if (substring.length() < minRes.length()) minRes = substring;
            sMap.put(s.charAt(l), sMap.get(s.charAt(l)) - 1);
            l++;
        }

        return matches ? minRes : "";
    }

    public String minWindowOptimised(String s, String t) {
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();


        for (Character c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int minLength = Integer.MAX_VALUE;
        int[] res = new int[]{-1, -1};
        int have = 0;
        int need = tMap.size();
        int l = 0, r = 0;

        for (; r < s.length(); r++) {
            char c = s.charAt(r);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            if (tMap.containsKey(c) && tMap.get(c).equals(sMap.get(c))) {
                have++;
            }

            while (have == need) {
                if (r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char lc = s.charAt(l);
                sMap.put(lc, sMap.getOrDefault(lc, 0) - 1);
                if (tMap.containsKey(lc) && sMap.get(lc) < tMap.get(lc)) {
                    have--;
                }
                l++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }


    public static void main(String[] args) {
        playground playground = new playground();

        System.out.println(playground.minWindow("OUZODYXAZV", "XYZ"));
    }
}
