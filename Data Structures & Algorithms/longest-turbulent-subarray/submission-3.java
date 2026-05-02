class Solution {
    public int maxTurbulenceSize(int[] arr) {

        int l = 0, max = 1, cur = 0;

        for(int r = 1; r < arr.length; r++) {

            if(arr[r-1] == arr[r]) {
                l = r;
                cur = 0;
            }
            else if(arr[r-1] < arr[r] && cur == 1) {
                l = r-1;
            }
            else if ((arr[r-1] > arr[r]) && cur == 2) {
                l = r-1;
            }

            if(arr[r-1] < arr[r]) {
                cur = 1;
            }
            else if (arr[r-1] > arr[r]) {
                cur = 2;
            }

            System.out.println("l: " + l + " r: " + r + " max: " + max);

            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}