class Solution {
    public boolean wordPattern(String pattern, String s) {
        // Step 1: Split string into words
        String[] words = s.split(" ");
        
        // Step 2: Length check - pattern and words must have same length
        if (pattern.length() != words.length) {
            return false;
        }
        
        // Step 3: Create two HashMaps for bi-directional mapping
        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();
        
        // Step 4: Check each character-word pair
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            
            // Check if character already has a mapping
            if (charToWord.containsKey(c)) {
                // If mapped to different word, return false
                if (!charToWord.get(c).equals(word)) {
                    return false;
                }
            } else {
                // Create new mapping
                charToWord.put(c, word);
            }
            
            // Check if word already has a mapping
            if (wordToChar.containsKey(word)) {
                // If mapped to different character, return false
                if (wordToChar.get(word) != c) {
                    return false;
                }
            } else {
                // Create new mapping
                wordToChar.put(word, c);
            }
        }
        
        // All checks passed
        return true;

        
    }
}