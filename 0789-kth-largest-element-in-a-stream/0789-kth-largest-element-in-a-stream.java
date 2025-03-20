import java.util.PriorityQueue;

class KthLargest {
    private PriorityQueue<Integer> minHeap;  // Min-heap to store top k elements
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        
        // Add initial values to the heap
        for (int num : nums) {
            add(num);  // Using add() ensures heap size stays at k
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);  // Add the new element
        if (minHeap.size() > k) {
            minHeap.poll();  // Remove the smallest element if heap exceeds k
        }
        return minHeap.peek();  // The root is the kth largest
    }
}


/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */