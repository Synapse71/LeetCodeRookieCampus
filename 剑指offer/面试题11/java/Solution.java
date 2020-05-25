class Solution {
    public int minArray(int[] numbers) {
        int length = numbers.length;
        if (length == 1) {
            return numbers[0];
        }
        if (length == 2) {
            return Math.min(numbers[0], numbers[1]);
        }
        int left = 0;
        int right = length - 1;
        int origin = (right + left) / 2;
        while(origin - left >= 1 && right - origin >= 1) {
            if (numbers[left] > numbers[origin]) {
                right = origin;
                origin = (right + left) / 2;
            } else if(numbers[right] < numbers[origin]) {
                left = origin;
                origin = (right + left) / 2;
            } else if (numbers[right] == numbers[origin] && numbers[left] == numbers[origin]) {
                left++;
                origin = (right + left) / 2;
            } else {
                return numbers[left];
            }
        }
        if (left == origin) {
            return Math.min(numbers[origin], numbers[right]);
        }
        else {
            return Math.min(numbers[origin], numbers[left]);
        }
    }
}