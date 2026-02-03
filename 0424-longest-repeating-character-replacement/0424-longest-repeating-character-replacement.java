class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq=new int[26];
        char[] string=s.toCharArray();
        int maxsubstring=0;
        int maxfreq=0;
        int left=0;
        int right=0;
        while(right<s.length()){
            freq[string[right]-'A']++;
            maxfreq=Math.max(maxfreq,freq[string[right]-'A']);
        int window_size=right-left+1;
            while(window_size-maxfreq>k){
                freq[string[left]-'A']--;
                left++;
                window_size=right-left+1;
            }
        maxsubstring=Math.max(maxsubstring,right-left+1);
        right++;
        }
        return maxsubstring;
    }
}
