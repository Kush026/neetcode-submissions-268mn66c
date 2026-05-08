class Solution {
    public int trap(int[] height) {

        // [0,2,0,3,1,0,1,3,2,1]
        // 2 + 2 + 3 + 2 = 9

        // [0,2,0,3,1,0,1,2,2,1]
        // 2 + 

        int out = 0, length = height.length, l = 0;

        int h = height[0];

        for(int r = 1; r < length; r++) {

            if(height[r] >= h) {
                // it can contain water


                for(int i = l+1; i < r; i++) {
                    out += h-height[i];
                }

                h = height[r];
                l = r;
                
            }
            
        }

        int r = length-1;

        h = height[r];

        for(l = r-1; l >= 0; l--) {

            if(height[l] > h) {
                // it can contain water

                for(int i = l+1; i < r; i++) {
                    System.out.println("l: " + l + ", r: "+ r);
                    out += h-height[i];
                }

                h = height[l];
                r = l;
            }
            
        }

        return out;
    }
}
