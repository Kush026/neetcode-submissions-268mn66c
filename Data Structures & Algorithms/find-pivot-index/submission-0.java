class Solution {
    public int pivotIndex(int[] nums) {
        int length = nums.length+1;

        int[] pref = new int[length];

        for(int i = 1; i < length; i++) {
            pref[i] = pref[i-1]+nums[i-1];
            System.out.print(pref[i] + " ");
        }

        for(int i = 1; i < length; i++) {
            if(pref[i-1] == (pref[length-1]-pref[i])) {
                return i - 1;
            }
        }

        return -1;
    }
}