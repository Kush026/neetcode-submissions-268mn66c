class NumMatrix {

    private int[][] prefSum;
    private int rows;
    private int cols;

    public NumMatrix(int[][] matrix) {
        this.rows = matrix.length+1;
        this.cols = matrix[0].length+1;
        this.prefSum = new int[rows][cols];

        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                prefSum[i][j] = prefSum[i][j-1] + prefSum[i-1][j] + matrix[i-1][j-1] - prefSum[i-1][j-1];
                System.out.print(prefSum[i][j] + " ");
            }

            System.out.println();
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {

        return prefSum[row2+1][col2+1] - prefSum[row2+1][col1] - prefSum[row1][col2+1] + prefSum[row1][col1];        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */