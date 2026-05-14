class Solution {
    public int findDuplicate(int[] nums) {

        int n = nums.length, i = 1;

        while(i <= n) {

            if(nums[i-1] < i) {
                return nums[i-1];
            }
            else if(nums[i-1] > i) {
                int temp = nums[i-1];

                if(temp == nums[temp - 1]) {
                    return temp;
                }
                
                nums[i-1] = nums[temp - 1];
                nums[temp - 1] = temp;
                System.out.println("temp: " + temp + " i: " + nums[i-1] + 
                " temp: "+nums[temp-1]);
            }
            else {
                i++;
            }

        }

        return -1;
    }
}
