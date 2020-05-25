class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] tuple = new int[2];
        for (int index = 0; index < nums.length; index++) {
            Integer another = target - nums[index];
            if (map.containsKey(another)) {
                tuple[0] = map.get(another);
                tuple[1] = index;
                break;
            }
            map.put(nums[index], index);
        }
        return tuple;
    }
}