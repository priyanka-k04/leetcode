class Solution {
    public int characterReplacement(String s, int k) {
        //sliding windoe + hash map
         int[] freq = new int[26];
    int left = 0;
    int maxFreq = 0;
    int maxWindow = 0;
    
    for (int right = 0; right < s.length(); right++) {
        // Update the frequency of the current character
        freq[s.charAt(right) - 'A']++;
        
        // Update the max frequency in current window
        maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
        
        // Calculate current window length
        int windowLength = right - left + 1;
        
        // If the number of characters to replace exceeds k,
        // then we need to shrink the window
        if (windowLength - maxFreq > k) {
            freq[s.charAt(left) - 'A']--;
            left++;
        }
        
        // Update max window length
        windowLength = right - left + 1;
        maxWindow = Math.max(maxWindow, windowLength);
    }
        return maxWindow;

}
}