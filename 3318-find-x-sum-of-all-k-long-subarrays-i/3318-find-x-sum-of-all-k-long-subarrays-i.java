class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] answer = new int[n - k + 1];
        
        for (int i = 0; i <= n - k; i++) {
            answer[i] = (int)calculateXSum(nums, i, i + k - 1, x);
        }
        
        return answer;
    }
    
    private long calculateXSum(int[] nums, int start, int end, int x) {
        // Count frequencies
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = start; i <= end; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        
        // Sort by frequency (desc) then by value (desc)
        List<Integer> elements = new ArrayList<>(freq.keySet());
        elements.sort((a, b) -> {int freqCompare = Integer.compare(freq.get(b), freq.get(a));
            if (freqCompare != 0) return freqCompare;
            return Integer.compare(b, a);
        });
        
        // Sum top x elements
        long sum = 0;
        for (int i = 0; i < Math.min(x, elements.size()); i++) {
            int element = elements.get(i);
            sum += (long) element * freq.get(element);
        }
        
        return sum;
    }
}