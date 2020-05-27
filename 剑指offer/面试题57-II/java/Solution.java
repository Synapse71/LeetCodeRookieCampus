class Solution {
    public int[][] findContinuousSequence(int target) {
        int leftIndex = 1;
        int rightIndex = 2;
        int ending = target / 2 + 1;
        List<int[]> arrayList = new ArrayList<>();
        while (rightIndex <= ending) {
            int rangeSum = rangeSum(leftIndex, rightIndex);
            if (rangeSum == target) {
                arrayList.add(range(leftIndex, rightIndex));
                rightIndex++;
            } else {
                if (rangeSum < target) {
                    rightIndex++;
                } else {
                    leftIndex++;
                }
            }
        }
        int [][] result = new int[arrayList.size()][];
        int index = 0;
        for (int[] array : arrayList) {
            result[index] = array;
            index++;
        }
        return result;
    }

    private int rangeSum(int start, int end) {
        return (int)((double)((start + end) * (end - start + 1)) / 2);
    }

    private int[] range(int start, int end) {
        int[] range = new int[end - start + 1];
        int index = 0;
        for (int num = start; num <= end; num++) {
            range[index] = num;
            index++;
        }
        return range;
    }
}