class Solution {
    public int orangesRotting(int[][] grid) {

        int rows = grid.length, cols = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        int val = bfs(grid, q);

        if(val == -1) {
            val = 0;
        }

        return isRottenAll(grid) ? val: -1;
    }

    private int bfs(int[][] grid, Deque<int[]> q) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int length = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            boolean changed = false;

            for(int k = 0; k < size; k++) {
                int[] p = q.pollFirst();
                int r = p[0];
                int c = p[1];

                System.out.println(r + ":"+c);

                if(r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == 0 || visited[r][c]) {
                    continue;
                }

                grid[r][c] = 2;
                visited[r][c] = true;
                changed = true;

                q.addLast(new int[]{r-1, c});
                q.addLast(new int[]{r+1, c});
                q.addLast(new int[]{r, c-1});
                q.addLast(new int[]{r, c+1});
            }

            if(changed) {
                length++;
            }
            System.out.println("length: "+length);
        }

        return length-1;
    }

    private boolean isRottenAll(int[][] grid) {

        int rows = grid.length, cols = grid[0].length;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
