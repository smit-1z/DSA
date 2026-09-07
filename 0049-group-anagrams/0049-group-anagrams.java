class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String str : strs){
            String key = getKey(str);
            map.computeIfAbsent(key, k-> new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>( map.values());
    }

    public String getKey(String str){
        StringBuilder key = new StringBuilder();
        char[] keyCharArray = str.toCharArray();
        Arrays.sort(keyCharArray);

        for(char s : keyCharArray){
            key.append(s).append('!');
        }

        return key.toString();
    }
}