class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = piles[0];

        for(int i = 1; i < piles.length; i++) {
            if(piles[i] > max) {
                max = piles[i];
            }
        }

        int l = 1, r = max;

        while(true) {

            if(l >= r) {
                return r;
            }

            int mid = l + (r-l)/2;

            if(isValid(piles, h, mid)) {
                r = mid;
            }
            else {
                l = mid+1;
            }
        }
    }

    private boolean isValid(int[] piles, int h, int rate) {
        int noOfHrs = 0;
        for(int i = 0; i < piles.length; i++) {
            noOfHrs += piles[i]/rate;
            noOfHrs += (piles[i] % rate == 0) ? 0 : 1;
        }

        return noOfHrs <= h ? true : false;
    }
}
