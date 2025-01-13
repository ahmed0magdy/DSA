package leetcode;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        // int[] nums = { 3, 2, 2, 3 };
        // int val = 3;
        int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
        int val = 2;
        var result = sol.removeElement(nums, val);
        System.out.println(result);
        for(int i=0;i<nums.length;i++)
        System.out.println(nums[i]);
    }
}

class Solution {
    public int removeElement(int[] nums, int val) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val)
                nums[p++] = nums[i];
        }
        return p;
    }
}
