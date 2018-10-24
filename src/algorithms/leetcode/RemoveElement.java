package algorithms.leetcode;

public class RemoveElement {

    public int solution(int[] nums, int val) {
        int begin = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val)
                nums[begin++] = nums[i];
        }
        return begin;
    }
}
