class TimeMap {
    Map<String, List<Pair<Integer, String>>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return "";

        List<Pair<Integer, String>> entry = map.get(key);
        
        String res = "";

        int l = 0;
        int r = entry.size()-1;

        while(l<=r){
            int mid = l + (r-l)/2;
            if(entry.get(mid).getKey() <= timestamp){
                res = entry.get(mid).getValue();
                l = mid+1;
            }else{
                r = mid-1;
            }
        }

        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */