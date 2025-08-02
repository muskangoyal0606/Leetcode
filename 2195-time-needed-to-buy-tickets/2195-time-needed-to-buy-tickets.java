class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<int[]> q = new LinkedList<>(); // Each element is {index, tickets}
        for (int i = 0; i < tickets.length; i++) {
            q.offer(new int[]{i, tickets[i]});
        }

        int time = 0;

        while (!q.isEmpty()) {
            int[] person = q.poll(); // remove from front
            person[1]--; // decrement ticket count
            time++;

            if (person[0] == k && person[1] == 0) {
                // kth person has bought all tickets
                return time;
            }

            if (person[1] > 0) {
                q.offer(person); // push to back
            }
        }

        return time; 

    }
}