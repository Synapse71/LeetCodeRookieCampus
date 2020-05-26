class Solution {
    List<String> result = new ArrayList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return result.toArray(new String[result.size()]);
    }

    private void dfs(int x) {
        if (x == c.length - 1) {
            result.add(String.valueOf(c));
        }
        Set<Character> charSet = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (charSet.contains(c[i])) {
                // 重复字符跳过
                continue;
            }
            charSet.add(c[i]);
            swap(x, i);
            dfs(x + 1);
            swap(x, i);
        }
    }

    private void swap(int x, int i) {
        char temp = c[x];
        c[x] = c[i];
        c[i] = temp;
    }
}