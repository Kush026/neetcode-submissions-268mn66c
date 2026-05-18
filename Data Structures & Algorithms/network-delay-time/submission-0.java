class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<int[]>[] adj = new ArrayList[n+1];

        for(int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<int[]>();
        }

        for(int[] time: times) {
            int sr = time[0], des = time[1], t = time[2];
            adj[sr].add(new int[]{des, t});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{k, 0});

        int min = 0;
        boolean[] visited = new boolean[n+1];

        while(n > 0 && !pq.isEmpty()) {
            int[] polled = pq.poll();

            // System.out.println("indx: " + polled[0] + ", sum: "+ polled[1] + ", time: " + polled[2]);

            if(visited[polled[0]]) {
                continue;
            }

            visited[polled[0]] = true;
            n--;
            int time = polled[1];
            min = polled[1];

            for(int[] child: adj[polled[0]]) {
                pq.add(new int[]{child[0], time + child[1]});
            }
        }

        return n > 0 ? -1 : min;
    }

    /**

    */
}
