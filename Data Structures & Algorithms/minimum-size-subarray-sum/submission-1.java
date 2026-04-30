class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int l = 0, sum = 0;
        int minL = 0;

        for(int r = 0; r < nums.length; r++) {
            sum += nums[r];

            while(sum >= target && l <= r) {
                if(minL == 0) {
                    minL = r - l + 1;
                }
                else {
                    minL = Math.min(minL, r - l + 1);
                }

                sum -= nums[l++];
            }


        }


        return minL;
    }
}