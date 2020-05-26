class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int length = matrix.length * matrix[0].length;
        int[] result = new int[length];
        int minX = -1;
        int minY = -1;
        int maxX = matrix[0].length;
        int maxY = matrix.length;
        int loop = 0;
        int counter = 0;
        int x = -1;
        int y = 0;
        while(counter < length) {
            switch (loop) {
                case 0 -> {
                    x++;
                    for (; x < maxX; x++) {
                        result[counter] = matrix[y][x];
                        counter++;
                    }
                    x--;
                    minY++;
                }
                case 1 -> {
                    y++;
                    for (; y < maxY; y++) {
                        result[counter] = matrix[y][x];
                        counter++;
                    }
                    y--;
                    maxX--;
                }
                case 2 -> {
                    x--;
                    for (; x > minX; x--) {
                        result[counter] = matrix[y][x];
                        counter++;
                    }
                    x++;
                    maxY--;
                }
                default -> {
                    y--;
                    for (; y > minY; y--) {
                        result[counter] = matrix[y][x];
                        counter++;
                    }
                    y++;
                    minX++;
                }
            }
            loop = (loop + 1) % 4;
        }
        return result;
    }
}