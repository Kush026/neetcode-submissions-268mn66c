class Solution {
    public int rob(int[] nums) {

        if(nums == null || nums.length == 0) {
            return 0;
        }

        int a1 = 0, a2 = 0;

        for(int i = 0; i < nums.length; i++) {
            int max = Math.max(a2, a1+nums[i]);

            a1 = a2;
            a2 = max;
        }

        return a2;
    }
}
