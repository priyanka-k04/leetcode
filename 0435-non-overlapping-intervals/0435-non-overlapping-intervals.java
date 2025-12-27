class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Step 1: Sort by end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int countKept = 1;               // keep first interval
        int lastEnd = intervals[0][1];

        // Step 2: Traverse remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= lastEnd) {
                countKept++;
                lastEnd = intervals[i][1];
            }
        }

        // Step 3: intervals to remove
        return intervals.length - countKept;
    }
}
