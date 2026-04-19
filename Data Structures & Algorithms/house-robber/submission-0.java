class Solution {
    public int rob(int[] nums) {

        if(nums == null || nums.length == 0) {
            return 0;
        }

        if(nums.length == 1) {
            return nums[0];
        }

        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int a1 = nums[0], a2 = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++) {
            int max = Math.max(a2, a1+nums[i]);

            a1 = a2;
            a2 = max;
        }

        return a2;
    }
}
