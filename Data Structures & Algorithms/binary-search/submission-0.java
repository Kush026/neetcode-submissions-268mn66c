class Solution {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }

    private int search(int[] nums, int target, int s, int e) {

        if(s > e) {
            return -1;
        }

        if (nums[s] == target) {
            return s;
        }

        int mid = s + (e-s)/2;

        if (nums[mid] == target) {
            return mid;
        }

        int res = search(nums, target, s, mid-1);

        return (res != -1) ? res : search(nums, target, mid+1, e);
    }
}
