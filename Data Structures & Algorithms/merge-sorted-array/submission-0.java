class Solution {

    /**
    nums1 = [1, 3, 4, 0, 0]
    nums2 = [2, 5]
    **/
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int ptr1 = m-1;
        int ptr2 = n-1;
        int cur = m+n-1;

        
        while(ptr2 >= 0 && ptr1 >= 0) {
            if(nums1[ptr1] > nums2[ptr2]) {
                nums1[cur--] = nums1[ptr1--];
            }
            else {
                nums1[cur--] = nums2[ptr2--];
            }
        }

        while (ptr2 >= 0) {
            nums1[cur--] = nums2[ptr2--];
        }
    }
}