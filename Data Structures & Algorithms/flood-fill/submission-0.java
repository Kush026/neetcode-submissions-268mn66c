class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        dfs(image, sr, sc, color, image[sr][sc]);

        return image;
    }

    private void dfs(int[][] image, int r, int c, int color, int old) {

        if(Math.min(r, c) < 0 || r == image.length || c == image[0].length ||
        image[r][c] != old || image[r][c] == color) {
            return;
        }

        image[r][c] = color;

        dfs(image, r, c+1, color, old);
        dfs(image, r, c-1, color, old);
        dfs(image, r+1, c, color, old);
        dfs(image, r-1, c, color, old);
    }
}