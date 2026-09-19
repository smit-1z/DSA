class RandomizedSet {
    List<Integer> list ;
    HashMap<Integer,Integer> map;
    public RandomizedSet() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
    }   
    
    public boolean insert(int val) {

        if(!map.containsKey(val)){
            list.add(val);
            map.put(val,list.size() -1);
            return true;

        }

        return false;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val) ){
            return false;
        }
        int index = map.get(val);
        int lastElement = list.get(list.size()-1);

        list.set(index, lastElement);
        map.put(lastElement,index);
        list.remove(list.size() -1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        double random = list.size() * Math.random();
        return list.get((int)random);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */