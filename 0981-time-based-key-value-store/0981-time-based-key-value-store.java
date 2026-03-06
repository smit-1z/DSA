class TimeMap {
    Map<String,TreeMap<Integer,String>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key,k-> new TreeMap<>());
        map.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        TreeMap<Integer,String> tMap = map.get(key);
        Integer floorKey = tMap.floorKey(timestamp);

        if(floorKey != null){
            return tMap.get(floorKey);
        }
        return "";
    }
}
