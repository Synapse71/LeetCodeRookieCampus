class Solution {
    public boolean verifyPostorder(int[] postorder) {
        int length = postorder.length;
        if (length <= 2) {
            return true;
        }
        int rootVal = postorder[length - 1];
        int splitIndex = 0;
        while (postorder[splitIndex] < rootVal && splitIndex < length - 1) {
            splitIndex++;
        }
        for (int index = splitIndex + 1; index < length - 1; index++) {
            if (postorder[index] <= rootVal) {
                return false;
            }
        }
        return verifyPostorder(Arrays.copyOfRange(postorder, 0, splitIndex))
                && verifyPostorder(Arrays.copyOfRange(postorder, splitIndex, length - 1));
    }
}