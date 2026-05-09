class Solution {
    public boolean canPartition(int[] nums) {

        int sum = 0;

        for(int val: nums) {
            sum += val;
        }

        if(sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        /**
        0, 1, 2, 3, 4, 5
        f, t, f, f, f, f
        f, t, 

        dp[i] = dp[i-1]
        */


        boolean[] dp = new boolean[target+1];

        for(int i = 0; i <= target; i++) {
            if(i == nums[0]) {
                dp[i] = true;
            }
        }

        for(int row = 1; row < nums.length; row++) {
            boolean[] newDp = new boolean[target+1];
            newDp[0] = dp[0];

            for(int i = 1; i <= target; i++) {
                newDp[i] = dp[i];
                int include = i - nums[row];
                if(include >= 0 && dp[include]) {
                    newDp[i] = true;
                }
            }

            dp = newDp;
        }

        return dp[target];
    }
}
