class Solution {
    public int findMaxLength(int[] nums) {
        // Step 1: Initialize map and variables
        HashMap<Integer, Integer> firstSeen = new HashMap<>();
        firstSeen.put(0, -1);  // Difference 0 seen before we start
        int maxLength = 0;
        int difference = 0;

        // Step 2: Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                difference--;  // 0 counts as -1
            } else {
                difference++;  // 1 counts as +1
            }

            // Step 3: Check if this difference was seen before
            if (firstSeen.containsKey(difference)) {
                int previousIndex = firstSeen.get(difference);
                int currentLength = i - previousIndex;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                // First time we see this difference, record the index
                firstSeen.put(difference, i);
            }
        }

        return maxLength;
    }
}