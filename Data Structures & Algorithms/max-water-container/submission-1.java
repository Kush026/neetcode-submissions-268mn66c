class Solution {
    public int maxArea(int[] heights) {

        int l = 0, r = heights.length - 1;
        int max = 0;

        while(l < r) {
            int minH = Math.min(heights[l], heights[r]);
            max = Math.max(max, (r - l)*minH);

            if(heights[l] < heights[r]) {
                l++;
            }
            else {
                r--;
            }
        }

        return max;
    }
}
