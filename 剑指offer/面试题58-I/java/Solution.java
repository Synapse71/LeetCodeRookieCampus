class Solution {
    public String reverseWords(String s) {
        List<String> words = Arrays.asList(s.split(" ")).stream().filter(str -> str.trim().length() > 0).collect(Collectors.toList());
        Collections.reverse(words);
        return String.join(" ", words.toArray(new String[words.size()]));
    }
}