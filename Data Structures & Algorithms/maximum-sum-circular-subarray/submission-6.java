class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        // -2,4,-5,4,-5,9,4

        int min = nums[0];
        int cur = 0;
        int max = nums[0], curMax = 0;
        

        int sum = 0;

        for(int val: nums) {
            sum += val;
            cur += val;
            curMax += val;
            max = Math.max(curMax, max);
            min = Math.min(cur, min);

            if(curMax < 0) {
                curMax = 0;
            }

            if(cur > 0) {
                cur = 0;
            }
        }

        System.out.println(max);
        System.out.println(sum-min);

        return max < 0 ? max : Math.max(max, sum - min);
    }
}