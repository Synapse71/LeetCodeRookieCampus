class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        List<Integer> list = IntStream.of(arr).boxed().sorted().collect(Collectors.toList());
        int[] result = new int[k];
        for (int i=0;i<k;i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}