class Solution {
    private static final String[] DICT = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    public int translateNum(int num) {
        Set<String> resultSet = new HashSet<>();
        translate(String.valueOf(num), "", resultSet);
        return resultSet.size();
    }

    private void translate(String numStr, String resultStr, Set<String> resultSet) {
        if (numStr.length() == 0) {
            resultSet.add(resultStr);
            return;
        }
        int oneDigit = Integer.parseInt(numStr.substring(0, 1));
        translate(numStr.substring(1), resultStr+DICT[oneDigit], resultSet);
        if (numStr.length() >= 2 && oneDigit > 0) {
            int twoDigit = Integer.parseInt(numStr.substring(0, 2));
            if (twoDigit < DICT.length) {
                translate(numStr.substring(2), resultStr+DICT[twoDigit], resultSet);
            }
        }
    }
}