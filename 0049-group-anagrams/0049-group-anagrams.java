class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String key = getKey(str);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public String getKey(String keyStr) {
        StringBuilder key = new StringBuilder();
        int[] charMap = new int[26];

        for (char c : keyStr.toCharArray()) {
            charMap[c - 'a']++;
        }

        for (int freq : charMap) {
            key.append(freq).append('#');
        }
        return key.toString();
    }
}