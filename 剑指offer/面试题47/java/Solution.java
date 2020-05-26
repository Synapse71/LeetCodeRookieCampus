class Solution {
    private int maxValue = 0;

    public int maxValue(int[][] grid) {
        maxValue = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int [][] pointMaxValue = new int[grid.length][grid[0].length];
        seek(grid, 0, 0, 0, pointMaxValue);
        return this.maxValue;
    }

    public void seek(int[][] grid, int x, int y, int value, int[][] pointMaxValue) {
        value += grid[y][x];
        if (value <= pointMaxValue[y][x] && value != 0) {
            return;
        } else {
            pointMaxValue[y][x] = value;
        }
        if (y == grid.length - 1 && x == grid[0].length - 1) {
            if (value > maxValue) {
                maxValue = value;
            }
            return;
        }
        if (y < grid.length - 1) {
            seek(grid, x, y+1, value, pointMaxValue);
        }
        if (x < grid[0].length - 1) {
            seek(grid, x+1, y, value, pointMaxValue);
        }
    }
}