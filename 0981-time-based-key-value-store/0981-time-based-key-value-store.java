class TimeMap {
    Map<String,TreeMap<Integer,String>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new TreeMap<>());
        }
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        TreeMap<Integer,String> entry = map.get(key);
        Integer floorKey = entry.floorKey(timestamp);
        if(floorKey!= null) return entry.get(floorKey); 

       return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */