class LRUCache {

    private int capacity;
    private Map<Integer, Integer> cache;
    private Set<Integer> lruSet;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        lruSet = new LinkedHashSet(capacity);
        cache = new HashMap<>(capacity);
    }
    
    public int get(int key) {
        Integer r = cache.get(key);
        if (r == null) {
            return -1;
        }

        addToDeque(key);
        return r;
    }
    
    public void put(int key, int value) {
        removeLRU(key);
        cache.put(key, value);
        addToDeque(key);
    }

    private void addToDeque(int key) {
        lruSet.remove(key);
        lruSet.add(key);
    }

    private void removeLRU(int key) {
        if (capacity == cache.size() && !cache.containsKey(key)) {
            Integer lruKey = lruSet.iterator().next();
            cache.remove(lruKey);
            lruSet.remove(lruKey);
        }
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */