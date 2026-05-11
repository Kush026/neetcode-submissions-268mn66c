class Solution {
    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        int count = 0, sum = 0;

        for(int i = 0; i < nums.length; i++) {

            sum += nums[i];
            System.out.println(sum);

            if(sum == k) {
                count++;
            }

            if(map.containsKey(sum-k)) {
                System.out.println(sum);
                count += map.get(sum-k);
            }

            int val = map.getOrDefault(sum, 0);

            map.put(sum, val+1);
        }

        return count;
    }
}