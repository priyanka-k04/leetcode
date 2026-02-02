class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0, right = 0;
        int maxfreq = 0, maxsubstring = 0;

        while (right < s.length()) {
            freq[s.charAt(right) - 'A']++;
            maxfreq = Math.max(maxfreq, freq[s.charAt(right) - 'A']);

            while ((right - left + 1) - maxfreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxsubstring = Math.max(maxsubstring, right - left + 1);
            right++; // ✅ VERY IMPORTANT
        }
        return maxsubstring;
    }
}
