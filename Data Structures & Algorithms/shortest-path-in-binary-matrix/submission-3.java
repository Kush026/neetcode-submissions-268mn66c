class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        if(grid == null || grid.length == 0 || grid[0].length == 0 ) {
            return -1;
        }

        int length = 0, rows = grid.length, cols = grid[0].length;

        Deque<int[]> que = new ArrayDeque<>();

        que.addLast(new int[]{0, 0});

        while(!que.isEmpty()) {
            int size = que.size();

            for(int i = 0; i < size; i++) {
                int[] pair = que.pollFirst();
                int r = pair[0];
                int c = pair[1];

                if(r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == 1) {
                    continue;
                }

                grid[r][c] = 1;

                if(r == rows-1 && c == cols - 1) {
                    return length+1;
                }

                que.addLast(new int[]{r-1, c-1});
                que.addLast(new int[]{r-1, c});
                que.addLast(new int[]{r-1, c+1});
                que.addLast(new int[]{r, c-1});
                que.addLast(new int[]{r, c+1});
                que.addLast(new int[]{r+1, c-1});
                que.addLast(new int[]{r+1, c});
                que.addLast(new int[]{r+1, c+1});
            }

            length++;
        }


        return -1;
    }
}