class Solution {
    public String minNumber(int[] nums) {
        List<String> numStrs = new ArrayList<>();
        for (int num : nums) {
            numStrs.add(String.valueOf(num));
        }
        Collections.sort(numStrs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int charIndex = 0;
                if (o1.length() == 0 && o2.length() == 0) {
                    return 0;
                }
                if (o1.length() == 0) {
                    return -1;
                }
                if (o2.length() == 0) {
                    return 1;
                }
                while (true) {
                    if (charIndex == o1.length() && charIndex == o2.length()) {
                        return 0;
                    }
                    if (charIndex == o1.length() || charIndex == o2.length()) {
                        return (Integer.parseInt(o1 + o2) - Integer.parseInt(o2 + o1));
                    }
                    int digit1 = Integer.parseInt(String.valueOf(o1.charAt(charIndex)));
                    int digit2 = Integer.parseInt(String.valueOf(o2.charAt(charIndex)));
                    if (digit1 != digit2) {
                        return digit1 - digit2;
                    }
                    charIndex++;
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String num:numStrs) {
            sb.append(num);
        }
        return sb.toString();
    }
}