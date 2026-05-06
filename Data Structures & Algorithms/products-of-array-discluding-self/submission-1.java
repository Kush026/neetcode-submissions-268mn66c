class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 1, 1, 2, 8
        // 48,24, 6, 1
        // 48, 24, 12, 8

        int l = nums.length;

        int[] out = new int[l];
        out[0] = 1;

        for(int i = 1; i < l; i++) {
            out[i] = out[i-1]*nums[i-1];
        }

        int multi = 1;

        for(int i = l - 2; i >= 0; i--) {
            out[i] = out[i]*multi*nums[i+1];
            multi = multi*nums[i+1];
        }

        return out;
    }
}  
