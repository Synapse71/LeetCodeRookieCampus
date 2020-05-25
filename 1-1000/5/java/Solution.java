class Solution {
    public String longestPalindrome(String s) {
        Stack<Character> stack = new Stack<Character>();
        int length = s.length();
        int maxSub = 0;
        String result = "";
        for (int index = 0; index < length - 1; index++) {
            if (s.charAt(index) == s.charAt(index + 1)) {
                // 长度为偶数的回文
                Stack<Character> temp = (Stack<Character>)stack.clone();
                int subLen = 2;
                int base = 2;
                while (!temp.empty() && index + base < length && temp.pop() == s.charAt(index + base)) {
                    base++;
                    subLen += 2;
                }
                if (subLen > maxSub) {
                    maxSub = subLen;
                    result = s.substring(index - subLen / 2 + 1, index + subLen / 2 + 1);
                }
            }
            if (!stack.empty() && stack.peek() == s.charAt(index + 1)) {
                // 长度为奇数的回文
                Stack<Character> temp = (Stack<Character>)stack.clone();
                int subLen = 3;
                temp.pop();
                int base = 2;
                while (!temp.empty() && index + base < length && temp.pop() == s.charAt(index + base)) {
                    base++;
                    subLen += 2;
                }
                if (subLen > maxSub) {
                    maxSub = subLen;
                    result = s.substring(index - subLen / 2, index + subLen / 2 + 1);
                }
            }
            stack.push(s.charAt(index));
        }
        if (maxSub == 0 && length > 0) {
            result = s.substring(0, 1);
        }
        return result;
    }
}
