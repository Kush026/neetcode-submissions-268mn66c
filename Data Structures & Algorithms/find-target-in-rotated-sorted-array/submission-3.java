class Solution {
    public int search(int[] nums, int target) {

        // 0, 1, 2, 3, 4, 5, 6
        // 4, 5, 6, 7, 0, 1, 2
        // 0, 7, 3
        // 4, 7, 5
        // 4, 5, 4
        // 4, 4

        int l = 0, r = nums.length - 1, mid;

        while(l <= r) {
            mid = (l + r) / 2;

            System.out.println("l: "+ l + ", r: "+ r + ", mid: "+mid);

            if(nums[mid] == target) {
                return mid;
            }

            if(nums[l] <= nums[mid]) {
                if(target < nums[mid] && target >= nums[l]) {
                    r = mid - 1;
                }
                else {
                    l = mid + 1;
                }
            }
            else {
                if(target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }
        }



        return -1;
    }
}
