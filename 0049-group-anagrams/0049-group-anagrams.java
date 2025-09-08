class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String key = getKey(str);

            map.computeIfAbsent(key, k -> new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public String getKey(String key) {
        int[] freqCount = new int[26];

        for (char c : key.toCharArray()) {
            freqCount[c - 'a']++;
        }

        StringBuilder res = new StringBuilder();

        for (int count : freqCount) {
            res.append(count).append("#");
        }

        return res.toString();
    }
}