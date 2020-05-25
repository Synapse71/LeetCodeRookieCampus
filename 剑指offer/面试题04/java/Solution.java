class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 特判
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int x = column - 1;
        int y = 0;
        while (x > -1 && y < row) {
            if (matrix[y][x] > target) {
                x--;
                continue;
            }
            if (matrix[y][x] < target) {
                y++;
                continue;
            }
            if (matrix[y][x] == target) {
                return true;
            }
        }
        return false;
    }
}