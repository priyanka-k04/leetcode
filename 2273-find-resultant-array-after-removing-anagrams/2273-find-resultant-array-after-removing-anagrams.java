class Solution {
    public List<String> removeAnagrams(String[] words) {
        int curr = 1;
        int prev = 0;
        List<String> result = new ArrayList<>();
        result.add(words[0]);

        while (curr < words.length) {
            if (!isAnagram(words[curr], words[prev])) {
                result.add(words[curr]);
                prev = curr;
            }
            curr++;
        }

        return result;
    }

    // Helper method to check if two words are anagrams
    private boolean isAnagram(String w1, String w2) {
        if (w1.length() != w2.length()) return false;

        char[] a = w1.toCharArray();
        char[] b = w2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }
}