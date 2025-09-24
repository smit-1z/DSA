class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] mapS1 = new int[26];
        int[] mapS2 = new int[26];

        for (char c : s1.toCharArray()) {
            mapS1[c - 'a']++;
        }

        for (int i = 0; i < s1.length(); i++) {
            mapS2[s2.charAt(i) - 'a']++;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            if (checkForPermutation(mapS1, mapS2)) {
                return true;
            }
            mapS2[s2.charAt(i) - 'a']++;
            mapS2[s2.charAt(i - s1.length()) - 'a']--;
        }

        return checkForPermutation(mapS1, mapS2);
    }

    public boolean checkForPermutation(int[] mapS1, int[] mapS2) {
        for (int i = 0; i < mapS1.length; i++) {
            if (mapS1[i] != mapS2[i]) {
                return false;
            }
        }
        return true;
    }
}