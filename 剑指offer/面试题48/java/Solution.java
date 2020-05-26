class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int[] bp = new int[s.length()];
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                bp[i] = 1;
                result = 1;
                charMap.put(s.charAt(i), i);
                continue;
            }
            if (charMap.containsKey(s.charAt(i))) {
                bp[i] = Math.min(i - charMap.get(s.charAt(i)), bp[i - 1] + 1);
            } else {
                bp[i] = bp[i - 1] + 1;
            }
            if (bp[i] > result) {
                result = bp[i];
            }
            charMap.put(s.charAt(i), i);
        }
        return result;
    }
}