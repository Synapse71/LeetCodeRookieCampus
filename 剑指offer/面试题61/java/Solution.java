class Solution {
    public boolean isStraight(int[] nums) {
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(numsList);
        int jokers = 0;
        int lastCard = -1;
        for (Integer num:numsList) {
            if (num == 0) {
                jokers++;
            } else {
                if (lastCard != -1) {
                    if (num == lastCard) {
                        return false;
                    }
                    if (num != lastCard + 1) {
                        if (jokers == 0) {
                            return false;
                        } else {
                            while(num != lastCard + 1 && jokers > 0) {
                                jokers--;
                                lastCard++;
                            }
                            if (num != lastCard + 1) {
                                return false;
                            }
                        }
                    }
                    lastCard++;
                } else {
                    lastCard = num;
                }
            }
        }
        return true;
    }
}