class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        dfs(nums, target, new ArrayList<>(), 0);
        
        return res;
    }

    private void dfs(int[] nums, int target, List<Integer> arr, int idx) {

        if(target == 0) {
            res.add(new ArrayList<>(arr));
            return;
        }

        if(target < 0) {
            return;
        }

        for(int i = idx; i < nums.length; i++) {
            arr.add(nums[i]);
            dfs(nums, target-nums[i], arr, i);
            arr.remove(arr.size() - 1);
        }

    }
}
