class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushIndex = 0;
        int popIndex = 0;
        Stack<Integer> stack = new Stack<>();
        while (popIndex < popped.length) {
            int popNum = popped[popIndex];
            if (stack.contains(popNum)) {
                if (stack.pop() == popNum) {
                    popIndex++;
                } else {
                    return false;
                }
            } else {
                int pushNum = pushed[pushIndex];
                stack.push(pushNum);
                while(pushNum != popNum && pushIndex < pushed.length - 1) {
                    pushIndex++;
                    pushNum = pushed[pushIndex];
                    stack.push(pushNum);
                }
                if (pushNum != popNum) {
                    return false;
                } else {
                    stack.pop();
                    popIndex++;
                    pushIndex++;
                }
            }
        }
        return true;
    }
}