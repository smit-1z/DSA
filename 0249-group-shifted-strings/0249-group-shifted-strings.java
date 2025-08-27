class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();

        for(String item : strings){
            StringBuilder key = new StringBuilder();
            key.append("#");

            for(int i = 1;i<item.length();i++){
                int code = (item.charAt(i) - item.charAt(i-1) + 26) %26;
                key.append(code).append("#");
            }

            map.computeIfAbsent(key.toString(), k -> new ArrayList<>());
            map.get(key.toString()).add(item);
        }
        
        return new ArrayList<>(map.values());
    }
}