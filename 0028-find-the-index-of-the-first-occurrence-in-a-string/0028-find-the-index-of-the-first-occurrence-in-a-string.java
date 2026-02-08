class Solution {
    public int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        // edge case
        if (m == 0) return 0;

        // slide needle over haystack
        for (int i = 0; i <= n - m; i++) {

            int j = 0;
            // check if needle matches starting at i
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            // if all characters matched
            if (j == m) {
                return i;
            }
        }

        return -1;
    }
}
