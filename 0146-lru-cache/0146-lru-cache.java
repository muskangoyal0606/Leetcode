

class LRUCache {
    private final int capacity;
    private final Map<Integer, Integer> map; // Stores key-value pairs
    private final Deque<Integer> queue; // Maintains order of usage

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.queue = new LinkedList<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        // Move key to the front since it was recently used
        queue.remove(key);
        queue.addFirst(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Update value and move key to front
            map.put(key, value);
            queue.remove(key);
            queue.addFirst(key);
            return;
        }

        // If cache is full, remove the least recently used (back of queue)
        if (map.size() >= capacity) {
            int lru = queue.removeLast();
            map.remove(lru);
        }

        // Add new key-value pair
        map.put(key, value);
        queue.addFirst(key);
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */