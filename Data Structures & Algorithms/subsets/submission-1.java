class Solution {
    List<List<Integer>> out = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        out.add(new ArrayList<>());
        dfs(nums, 0, new ArrayList<>());

        return out;
    }

    private void dfs(int[] nums, int i, List<Integer> arr) {

        if(i >= nums.length) {
            return;
        }

        arr.add(nums[i]);
        out.add(new ArrayList<>(arr));
        
        dfs(nums, i+1, arr);
        arr.removeLast();
        dfs(nums, i+1, arr);
    }
}
