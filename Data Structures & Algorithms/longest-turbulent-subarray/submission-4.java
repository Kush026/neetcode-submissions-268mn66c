class Solution {
    public int maxTurbulenceSize(int[] arr) {

        int l = 0, max = 1, cur = 0;

        for(int r = 1; r < arr.length; r++) {

            if(arr[r-1] == arr[r]) {
                l = r;
                cur = 0;
            }
            else if(arr[r-1] < arr[r]) {
                if(cur == 1) {
                    l = r-1;
                }
                cur = 1;
            }
            else if ((arr[r-1] > arr[r])) {
                if(cur == 2) {
                    l = r-1;
                }
                cur = 2;
            }

            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}