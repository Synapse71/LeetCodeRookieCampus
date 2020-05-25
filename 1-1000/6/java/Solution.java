class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int len = s.length();
        int gap = 2 * (numRows-1);
        List<Integer> charIndex = new ArrayList<>();
        for (int n = 0; n < numRows; n++) {
            int index = n;
            if (n == 0 || n == numRows -1) {
                while (index < len) {
                    charIndex.add(index);
                    index += gap;
                }
            } else {
                int gap1 = 2 * n;
                int gap2 = gap - gap1;
                while (index < len) {
                    charIndex.add(index);
                    index += gap2;
                    if (index >= len) {
                        break;
                    }
                    charIndex.add(index);
                    index += gap1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Integer index: charIndex) {
            sb.append(s.charAt(index));
        }
        return sb.toString();
    }
}