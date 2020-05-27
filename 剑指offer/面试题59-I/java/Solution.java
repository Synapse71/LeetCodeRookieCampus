class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0 || nums == null || nums.length == 0) {
            return new int[0];
        }
        if (nums.length < k) {
            return new int[0];
        }
        int index = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (; index < k; index++) {
            maxHeap.add(nums[index]);
        }
        List<Integer> result = new ArrayList<>();
        result.add(maxHeap.peek());
        for (; index < nums.length; index++) {
            maxHeap.remove(nums[index - k]);
            maxHeap.add(nums[index]);
            result.add(maxHeap.peek());
        }
        int[] resArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArray[i] = result.get(i);
        }
        return resArray;
    }
}