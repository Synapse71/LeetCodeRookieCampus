class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> list= new HashSet<>();
        for (int num:nums) {
            if(list.contains(num)) {
                return num;
            }
            list.add(num);
        }
        return 0;
    }
}