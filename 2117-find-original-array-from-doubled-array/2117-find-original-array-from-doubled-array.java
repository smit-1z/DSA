class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0)
            return new int[] {};
        int max = 0;

        for (int num : changed) {
            max = Math.max(num, max);
        }

        int[] freq = new int[max * 2 + 1];
        
        for (int num : changed) {
            freq[num]++;
        }

        int[] res = new int[changed.length / 2];
        int counter = 0;

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {

                freq[i]--;
                int twice = i * 2;

                if (freq[twice] > 0) {
                    freq[twice]--;
                    res[counter++] = i;
                    i--;
                } else {
                    return new int[] {};
                }
            }
        }
        return res;
    }
}

//123468