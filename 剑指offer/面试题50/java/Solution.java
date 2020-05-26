class Solution {
    public char firstUniqChar(String s) {
        if (s.length() == 0) {
            return ' ';
        }
        LinkedList<Character> queue= new LinkedList<>();
        Map<Character, Character> map = new HashMap<>();
        for (int index = 0; index < s.length(); index++) {
            Character target = s.charAt(index);
            if (map.containsKey(target)) {
                if (queue.contains(target)) {
                    queue.remove(target);
                }
                continue;
            }
            queue.addLast(target);
            map.put(target, target);
        }
        return queue.size() == 0 ? ' ' : queue.get(0);
    }
}