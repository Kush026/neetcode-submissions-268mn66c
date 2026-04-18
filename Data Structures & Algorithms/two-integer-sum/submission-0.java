class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int pair = target - val;

            if(map.containsKey(pair)) {
                return new int[]{map.get(pair), i};
            }

            map.put(val, i);
        }

        return new int[2];
    }
}
