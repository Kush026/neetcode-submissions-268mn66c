class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
            double disA = Math.sqrt(a[0]*a[0]+a[1]*a[1]);
            double disB = Math.sqrt(b[0]*b[0]+b[1]*b[1]);

            double diff = (disA - disB);

            if(diff == 0.0) {
                return 0;
            }

            return diff < 0 ? -1 : 1;
        }
        );


        for(int[] p: points) {
            pq.add(p);
        }

        int[][] out = new int[k][];


        for(int i = 0; i < k; i++) {
            out[i] = pq.poll();
        }
        return out;
    }
}
