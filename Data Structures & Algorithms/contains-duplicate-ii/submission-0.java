class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if(k == 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        int size = k + 1;

        int s = 0, e = 0;

        for(int n: nums) {

            if (set.size() >= size) {
                set.remove(nums[s++]);
            }

            if(set.contains(n)) {
                return true;
            }

            set.add(n);
            e++;

        }

        return false;
    }
}