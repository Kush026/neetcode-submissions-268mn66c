class Solution {
    public int rob(int[] nums) {

        if(nums == null || nums.length == 0) {
            return 0;
        }

        if(nums.length == 1) {
            return nums[0];
        }

        int a1 = 0, a2 = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int max = Math.max(a2, a1+nums[i]);

            a1 = a2;
            a2 = max;
        }

        return a2;
    }
}
