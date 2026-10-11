class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String str : strs){
            map.computeIfAbsent(getKey(str), k-> new ArrayList<>()).add(str);
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