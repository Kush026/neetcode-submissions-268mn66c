class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int l = 0, r = k - 1;

        int sum = 0;

        for(int i = l; i <= r; i++) {
            sum += arr[i];
        }

        int out = 0;

        if((sum / k) >= threshold) {
            out++;
        }

        for(r = r + 1; r < arr.length; r++) {
            sum -= arr[l++];
            sum += arr[r];


            if((sum / k) >= threshold) {
                out++;
            }
        }


        return out;
    }
}