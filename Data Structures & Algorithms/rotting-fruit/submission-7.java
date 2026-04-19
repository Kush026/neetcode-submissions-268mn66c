class Solution {
    public int orangesRotting(int[][] grid) {

        if(grid == null || grid.length == 0) return 0;

        int rows = grid.length, cols = grid[0].length;
        int fresh = 0;

        Deque<int[]> deck = new ArrayDeque<>();

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 2) {
                    deck.offer(new int[]{i, j});
                }

                if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int min = 0;

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(fresh > 0 && !deck.isEmpty()) {
            int size = deck.size();

            for(int i = 0; i < size; i++) {
                int[] p = deck.poll();
                int r = p[0];
                int c = p[1];

                for(int[] dir: dirs) {
                    int r1 = r + dir[0];
                    int c1 = c + dir[1];

                    if(r1 >= 0 && c1 >= 0 && r1 < rows && c1 < cols && grid[r1][c1] == 1) {
                        grid[r1][c1] = 2;
                        deck.offer(new int[]{r1, c1});
                        fresh--;
                    }
                }


            }

            min++;

        }

        return fresh > 0 ? -1 : min;
        
    }
}
