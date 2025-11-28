
class Solution {
    public int hIndex(int[] citations) {

        //x will be H-index of there are x index with index =equal to x or > x

        // Step 1: Create bucket array of size n+1
        int n = citations.length;
        int[] bucket = new int[n + 1];

        // Step 2: Fill the bucket
        for (int c : citations) {
            if (c >= n)
                bucket[n]++;      // count all large citation values in the last bucket
            else
                bucket[c]++;
        }

        // Step 3: Find H-Index (traverse backwards)
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += bucket[i];   // total papers with >= i citations
            if (count >= i)
                return i;         // this is the H-index
        }

        return 0;  // default (will never hit for valid inputs)
    }
}
