class Solution {
    public int findKthLargest(int[] nums, int k) {

        // -1, 2, 0

        int left = 0;
        int right = nums.length-1; // 2

        int target = nums.length - k; // 1

        while(true) {

            int pos = partition(nums, left, right);

            System.out.printf("pos: %d, val: %d, left: %d, right: %d\n", pos, nums[pos], left, right);

            if(pos == target) {
                return nums[pos];
            }
            else if (pos < target) {
                left = pos + 1;
            }
            else {
                right = pos - 1;
            }

        }
    }

    private int partition(int[] nums, int s, int e) {

        // s = 0, e = 2

        int mid = (s + e) >> 1;
        swap(nums, mid, e);

        int pivot = nums[e];

        int ptr = s;

        for(int i = s; i < e; i++) {
            if(nums[i] <= pivot) {
                swap(nums, ptr, i);
                ptr++;
            }
        }
        
        swap(nums, ptr, e);

        return ptr;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
