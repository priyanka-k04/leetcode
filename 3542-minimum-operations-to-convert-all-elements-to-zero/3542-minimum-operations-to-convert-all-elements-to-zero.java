class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int operations = 0;

        for (int n : nums) {
            // Step 1: Pop larger elements (decreasing height)
            while (!stack.isEmpty() && stack.peek() > n) {
                stack.pop();
            }

            // Step 2: Ignore zeros (no operation needed)
            if (n == 0) continue;

            // Step 3: Push new heights (new operations)
            if (stack.isEmpty() || stack.peek() < n) {
                operations++;
                stack.push(n);
            }
        }

        return operations;
    }
}