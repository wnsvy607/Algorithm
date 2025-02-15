class Solution {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int max = 0;
        int[] charIndex = new int[128];
        for(int i = 0; i < 128; i++) charIndex[i] = -1;
        int left = 0;

        for(int right = 0; right < len; right++) {
            if(charIndex[s.charAt(right)] >= left) {
                left = charIndex[s.charAt(right)] + 1;
            }

            charIndex[s.charAt(right)] = right;
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}