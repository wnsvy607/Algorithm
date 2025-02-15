class Solution {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;

        Set<Character> set = new HashSet<>();

        int start = 0;
        int end = 0;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            while(set.contains(ch) && start < s.length()) {
                set.remove(s.charAt(start++));
            }

            set.add(ch);
            end = i;
            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}