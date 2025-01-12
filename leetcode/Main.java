package leetcode;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        // int[] nums = { 1, 1, 2 };
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int result = sol.removeDuplicates(nums);
        System.out.println(result);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);

        }

    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
}
