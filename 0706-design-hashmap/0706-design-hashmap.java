class Pair<U, V> {
    public U first;
    public V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}

class Bucket {
    private List<Pair<Integer, Integer>> bucket;

    public Bucket() {
        this.bucket = new LinkedList<Pair<Integer, Integer>>();
    }

    public Integer get(Integer key) {
        for (Pair<Integer, Integer> pair : this.bucket) {
            if (pair.first.equals(key)) {
                return pair.second;
            }
        }
        return -1;
    }

    public void update(Integer key, Integer value) {
        for (Pair<Integer, Integer> pair : this.bucket) {
            if (pair.first.equals(key)) {
                pair.second = value;
                return;
            }
        }

        this.bucket.add(new Pair(key, value));

    }

    public void remove(Integer key) {
        for (Pair<Integer, Integer> pair : this.bucket) {
            if (pair.first.equals(key)) {
                this.bucket.remove(pair);
                break;
            }
        }
    }

}

class MyHashMap {
    Bucket map;

    public MyHashMap() {
        this.map = new Bucket();
    }

    public void put(int key, int value) {
        map.update(key, value);
    }

    public int get(int key) {
        return map.get(key);
    }

    public void remove(int key) {
        map.remove(key);
    }
}